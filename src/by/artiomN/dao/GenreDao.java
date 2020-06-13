package by.artiomN.dao;

import by.artiomN.connection.ConnectionManager;
import by.artiomN.entity.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum  GenreDao {
        INSTANCE;
        public List<Genre> findAll(){
            List<Genre> genres=new ArrayList<>();
            try (Connection connection=ConnectionManager.newConnection()){
                String sql = "SELECT *FROM users.game ";
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    genres.add(new Genre(resultSet.getLong(1),
                            resultSet.getString("genre")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return genres;
        }
}
