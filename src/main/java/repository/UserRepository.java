package repository;

import entity.User;
import utility.JdbcConnection;

import java.sql.*;
import java.time.LocalDate;

public class UserRepository implements Crud {


    @Override
    public void save(User user) {
        String sqlQuery = "insert into users (username, user_password, signup_date) VALUES (?,?,?)";

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            prestatement.setString(1, user.getUsername());
            prestatement.setString(2, user.getPassword());
            prestatement.setDate(3, Date.valueOf(LocalDate.now()));
            prestatement.execute();
            ResultSet resultSet = prestatement.getGeneratedKeys();
            resultSet.next();
            int generatedId = resultSet.getInt(1);
            user.setUserId(generatedId);


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void saveAll(User[] users) {
        String sqlQuery = "insert into users (username, user_password, signup_date) VALUES (?,?,?)";

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery)) {
            for (User user : users) {
                prestatement.setString(1, user.getUsername());
                prestatement.setString(2, user.getPassword());
                prestatement.setDate(3, Date.valueOf(LocalDate.now()));
                prestatement.addBatch();
            }
            prestatement.executeBatch();


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void delete(int userId) {
        String sqlQuery = "delete from users where user_id=? ";

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery)) {
            prestatement.setInt(1, userId);
            prestatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(User user) {
        String sqlQuery = "update users set username=? ,user_password=? where user_id = ?";
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery)) {
            prestatement.setString(1, user.getUsername());
            prestatement.setString(2, user.getPassword());
            prestatement.setInt(3, user.getUserId());
            prestatement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public User load(int userId) {
        String sqlQuery = "select * from users where user_id=? ";
        User user = new User();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery)) {
            prestatement.setInt(1, userId);
            ResultSet resultSet = prestatement.executeQuery();
            resultSet.next();
            user.setUserId(resultSet.getInt("user_id"));
            user.setPassword(resultSet.getString("user_password"));
            user.setUsername(resultSet.getString("username"));
            user.setSignupDate(resultSet.getDate("signup_date").toLocalDate());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public User[] loadAll(int limit) {
        String sqlQuery = "select * from users  order by user_id limit ?";

        User[] users = new User[limit];
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement prestatement = connection.prepareStatement(sqlQuery)) {
            prestatement.setInt(1, limit);
            ResultSet resultSet = prestatement.executeQuery();
            int index = 0;
            while (resultSet.next()) {
                users[index] = new User();
                users[index].setUserId(resultSet.getInt("user_id"));
                users[index].setPassword(resultSet.getString("user_password"));
                users[index].setUsername(resultSet.getString("username"));
                users[index].setSignupDate(resultSet.getDate("signup_date").toLocalDate());
                index++;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return users;
    }
}
