package by.mishota.graduation.dao.impl;

import by.mishota.graduation.dao.ConnectionPool;
import by.mishota.graduation.dao.UserDao;
import by.mishota.graduation.entity.Gender;
import by.mishota.graduation.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoDb implements UserDao {

    private static Logger logger = LogManager.getLogger();

    private static final String SELECT_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_FIND_BY_ID = "SELECT * FROM users where id=";

    @Override
    public List<User> findAll() {
        ConnectionPool pool = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_FIND_ALL_USERS);

            while (rs.next()) {
                User user = createUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Error in find by id user: " + e);
        } catch (InterruptedException e) {
            logger.error("Waiting for connection was interrupted: " + e);
        } finally {
            close(pool, connection, statement, rs);
        }
        return users;
    }

    @Override
    public Optional<User> findById(int id) {

        ConnectionPool pool = null;
        Connection connection = null;
        Statement statement = null;
        Optional<User> optionalUser = Optional.empty();
        ResultSet rs = null;
        try {
            pool = ConnectionPool.getInstance();
            connection = pool.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_FIND_BY_ID);

            if (rs.next()) {
                optionalUser = Optional.of(createUser(rs));
            }
        } catch (SQLException e) {
            logger.error("Error in find by id user: " + e);
        } catch (InterruptedException e) {
            logger.error("Waiting for connection was interrupted: " + e);
        } finally {
            close(pool, connection, statement, rs);
        }
        return optionalUser;
    }

    private void close(ConnectionPool pool, Connection connection, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Error in closing result set: " + e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Error in closing statement: " + e);
            }
        }

        if (connection != null) {
            pool.closeConnection(connection);
        }
    }

    @Override
    public List<User> findAllMoreBirth(LocalDate dateBirth) {
        return null;
    }

    private User createUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int passportId = rs.getInt("passport_id");
        LocalDate date_birth = rs.getDate("date_birth").toLocalDate();
        String login = rs.getString("login");
        String password = rs.getString("password");
        String email = rs.getString("email");
        String firstName = rs.getString("first_name");
        String surname = rs.getString("surname");
        String fatherName = rs.getString("father_name");
        Gender gender = Gender.valueOfIgnoreCase(rs.getString("gender"));
        boolean confirmed = rs.getBoolean("confirmed");

        return User.create(id, passportId, date_birth, login, password, firstName, surname, fatherName, gender, confirmed);
    }

}
