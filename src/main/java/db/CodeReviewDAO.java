package db;

import model.CodeReview;

import java.sql.SQLException;
import java.util.List;

public class CodeReviewDAO extends DAO<CodeReview> {
    public CodeReviewDAO(){
        super();
    }

    @Override
    public CodeReview get(int id) {
        return null;
    }

    @Override
    public List<CodeReview> get() {
        return null;
    }

    @Override
    public boolean post(CodeReview newItem) {
        return true;
    }

    @Override
    boolean put(CodeReview existingItem) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }
}
