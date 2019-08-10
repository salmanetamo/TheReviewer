package db;

import utils.PasswordHashingUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {
    private final static String TABLE = "users";
    public UserDAO(){
        super();
    }

    @Override
    public User get(int id) throws SQLException, ClassNotFoundException {
        return this.findWith("id", Integer.toString(id));
    }

    @Override
    public List<User> get() throws SQLException, ClassNotFoundException {
        String listUsersQuery = "SELECT id, name, email, password, salt  FROM " + TABLE;
        List<User> users = new ArrayList<>();
        PreparedStatement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);
        try {
            statement = connection.prepareStatement(listUsersQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            connection.commit();
            return users;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        }
    }

    @Override
    public boolean post(User newItem) throws SQLException, ClassNotFoundException {
        String addUserQuery = "INSERT INTO " + TABLE + " (name, email, password, salt) VALUES (?, ?, ?, ?)";
        String salt = PasswordHashingUtil.getNextSalt();
        String hashedPassword = PasswordHashingUtil.getHashedPassword(newItem.getPassword(), salt);
        PreparedStatement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);

        try{
            statement = connection.prepareStatement(addUserQuery);
            statement.setString(1, newItem.getName());
            statement.setString(2, newItem.getEmail());
            statement.setString(3, hashedPassword);
            statement.setString(4, salt);
            statement.execute();
            connection.commit();
            return true;
        } catch (SQLException e){
            connection.rollback();
            return false;
        }
    }

    @Override
    public boolean put(User dummyUser) throws SQLException, ClassNotFoundException {
        if(this.get(dummyUser.getId()) == null){ // User not found
            return false;
        }
        User existingUser = this.get(dummyUser.getId());
        String updateUserQuery = "UPDATE " + TABLE + " SET email = ?, password = ?  WHERE id = ?";

        String hashedPassword = PasswordHashingUtil.getHashedPassword(dummyUser.getPassword(), existingUser.getSalt());
        PreparedStatement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);

        try{
            statement = connection.prepareStatement(updateUserQuery);

            statement.setString(1, dummyUser.getEmail());
            statement.setString(2, hashedPassword);
            statement.setInt(3, existingUser.getId());

            statement.execute();
            connection.commit();
            return true;
        } catch (SQLException e){
            connection.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        if(this.get(id) == null){ return false; }
        String deleteUserQuery = "DELETE FROM " + TABLE + " WHERE id = ?";
        PreparedStatement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);
        try{
            statement = connection.prepareStatement(deleteUserQuery);
            statement.setInt(1, id);
            statement.execute();
            connection.commit();
            return true;
        } catch (SQLException e){
            connection.rollback();
            return false;
        }
    }

    public User findByEmailPassword(String email, String password) throws SQLException, ClassNotFoundException {
        User user = findWith("email", email);
        if(user == null || !user.getPassword().equals(PasswordHashingUtil.getHashedPassword(password, user.getSalt()))){
            return null;
        }
        return user;

    }

    private User findWith(String field, String value) throws SQLException, ClassNotFoundException {
        String query = "SELECT id, name, email, password, salt  FROM " + TABLE +
                " WHERE " + field + " = ?";
        User output = null;
        PreparedStatement statement;
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);
        try {
            statement = connection.prepareStatement(query);
            if(field.equals("email")){
                statement.setString(1, value);
            } else if(field.equals("id")){
                statement.setInt(1, Integer.parseInt(value));
            } else {
                return null;
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                output = new User(
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                connection.commit();
            }
        } catch (SQLException | RuntimeException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return output;
    }
}
