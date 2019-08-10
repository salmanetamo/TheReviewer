package db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAO<T> {
    // Database credentials and parameters
    // TODO : Put these parameters in a config file
    protected String hostName = "localhost";
    protected String port = "3306";
    protected String dbName = "reviewer";
    protected String userName = "salmane";
    protected String password = "reviewer";

    public DAO(){
        try {
            this.getConnection();
            this.setUp();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Url to connect to the database
        String url =  "jdbc:mysql://" + hostName + ":" + port + "/" + dbName;

        // Return new connection
        return DriverManager.getConnection(url, userName, password);
    }

    protected void setUp() throws SQLException, ClassNotFoundException {
        // Script to create tables
        // TODO: Set up the path to the script correctly
        String fileName = "C:\\Users\\Student\\Desktop\\Secure Software Development\\Coursework\\TheReviewer\\sqlscript.sql";
        Statement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            statement = connection.createStatement();
            String line;
            // Execute each line in SQL script file
            while ((line = bufferedReader.readLine()) != null) {
                statement.execute(line);
            }
            connection.commit();
        } catch (SQLException | IOException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    abstract T get(int id) throws SQLException, ClassNotFoundException;
    abstract List<T> get() throws SQLException, ClassNotFoundException;
    abstract boolean post(T newItem) throws SQLException, ClassNotFoundException;
    abstract boolean put(T existingItem) throws SQLException, ClassNotFoundException;
    abstract boolean delete(int id) throws SQLException, ClassNotFoundException;
}
