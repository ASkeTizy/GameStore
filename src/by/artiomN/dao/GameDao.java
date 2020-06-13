package by.artiomN.dao;

import by.artiomN.connection.ConnectionManager;
import by.artiomN.entity.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum GameDao {
    INSTANCE;

    public Game findOne(Long gameId){

        try (Connection connection=ConnectionManager.newConnection()){
            String sql = "SELECT *FROM users.game WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql);
            preparedStatement.setLong(1,gameId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return new Game(gameId,
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getString("companyName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Long save(Game game){
        Long id=null;

        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "insert into game  (companyName,genre,name) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,game.getCompanyName());
            preparedStatement.setString(2,game.getGenre());
            preparedStatement.setString(3,game.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
               id= generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public List<Game> getAll(){
        List<Game> games=new ArrayList<>();
        try (Connection connection=ConnectionManager.newConnection()){
            String sql = "SELECT *FROM users.game ";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql);
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

}
