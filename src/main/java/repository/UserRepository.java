package repository;

import entity.User;
import utility.JdbcConnection;

import java.sql.*;
import java.time.LocalDate;

public class UserRepository implements Crud {


    @Override
    public void save(User user) {
        String sqlQuery="insert into users (username, user_password, signup_date) VALUES (?,?,?)";

        try(Connection connection= JdbcConnection.getConnection();
            PreparedStatement prestatement=connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS)) {

            prestatement.setString(1, user.getUsername());
            prestatement.setString(2, user.getPassword());
            prestatement.setDate(3, Date.valueOf(LocalDate.now()));
            prestatement.execute();
            ResultSet resultSet=prestatement.getGeneratedKeys();
            resultSet.next();
            int generatedId =resultSet.getInt(1);
            user.setUserId(generatedId);


        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void load() {

    }

    @Override
    public void loadAll() {

    }
}
