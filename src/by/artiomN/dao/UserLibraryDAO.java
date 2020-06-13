package by.artiomN.dao;

import by.artiomN.connection.ConnectionManager;
import by.artiomN.entity.Game;
import by.artiomN.entity.UserLibrary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum UserLibraryDAO {
    INSTANCE;
    public List<Game> getLibrary(Long userId){
        List<Game> games=new ArrayList<>();
        try (Connection connection=ConnectionManager.newConnection()){
            String sql = "SELECT game.* FROM game inner join user_library on game.id=user_library.gameID and userID=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                games.add(new Game(
                        resultSet.getLong(1),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getString("companyName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    public UserLibrary addToLibrary(UserLibrary userLibrary){

        try (Connection connection = ConnectionManager.newConnection()) {
            if (findPare(userLibrary, connection)) return null;
            // connection.setAutoCommit(false);
            String sql = "insert into user_library (userID,gameID) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userLibrary.getUserId());
            preparedStatement.setLong(2, userLibrary.getGameId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                userLibrary.setUserId(generatedKeys.getLong(1));
                userLibrary.setGameId(generatedKeys.getLong(2));
            }
            return userLibrary;
            //   preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userLibrary;
    }

    private boolean findPare(UserLibrary userLibrary, Connection connection) throws SQLException {
        String sql = "SELECT * FROM user_library WHERE userID=? and gameID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,userLibrary.getUserId());
        preparedStatement.setLong(2,userLibrary.getGameId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        return false;
    }
}
