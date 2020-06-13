package by.artiomN.dao;

import by.artiomN.connection.ConnectionManager;
import by.artiomN.dto.UserBasicDto;
import by.artiomN.dto.UserDto;
import by.artiomN.entity.User;

import java.sql.*;
import java.util.LinkedList;

public enum UserDao {
    INSTANCE;


    public User findOne(Long userId) {

        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "SELECT *FROM users.user WHERE user_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new User(resultSet.getLong(1),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<ViewUserBasicDto> getAll() {
//        List<ViewUserBasicDto> users = new ArrayList<>();
//        try (Connection connection = ConnectionManager.newConnection()) {
//            String sql = "SELECT *FROM users.user ";
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                users.add(new ViewUserBasicDto(resultSet.getLong(1),
//                        resultSet.getString("login")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
public User findByLogin(UserBasicDto userBasicDto){

    try( Connection connection = ConnectionManager.newConnection()) {
        String sql = "select *from user where (login=? and password=?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userBasicDto.getLogin());

        preparedStatement.setString(2,userBasicDto.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           return new User(resultSet.getLong(1),
                    resultSet.getString("login"),
                    resultSet.getString("password"));
        }
        }
     catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    public Long save(UserDto userDto) {
        Long id=null;
        try (Connection connection = ConnectionManager.newConnection()) {

            // connection.setAutoCommit(false);
            String sql = "insert into user (login,password,first_name,last_name,age,gender) values (?, ?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userDto.getLogin());
            preparedStatement.setString(2, userDto.getPassword());
            preparedStatement.setString(3, userDto.getFirstName());
            preparedStatement.setString(4, userDto.getLastName());
            preparedStatement.setInt(5, userDto.getAge());
            preparedStatement.setString(6, userDto.getGender().toString());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                 id=generatedKeys.getLong(1);
            }
                return id;
            //   preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public LinkedList<User> getUsersByLogin(String login) {
        return null;
    }
}
