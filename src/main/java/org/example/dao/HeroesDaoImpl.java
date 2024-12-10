package org.example.dao;

import org.example.commons.database.config.MySQLConnection;
import org.example.dto.HeroesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HeroesDaoImpl implements HeroesDao {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result;

    @Override
    public List<HeroesDto> findAll() {
        try {
            connection = MySQLConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT id, nature,name FROM heroes;");
            result = statement.executeQuery();

            List<HeroesDto> heroesList = new ArrayList<>();
            while (result.next()){
                HeroesDto heroesDto = new HeroesDto();
                heroesDto.setId(result.getInt("id"));
                heroesDto.setNature(result.getString("nature"));
                heroesDto.setName(result.getString("name"));

                heroesList.add(heroesDto);
            }
            connection.commit();
            return heroesList;

        } catch (Exception exception){
            rollback();
            throw new RuntimeException("error to find all employees: " + exception.getMessage());
        }finally {
            closeResources();
        }
    }

    @Override
    public HeroesDto finById(int id) {
        return null;
    }
    private void rollback() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (Exception exception) {
            throw new RuntimeException("error to rollback: " + exception.getMessage());
        }
    }

    private void closeResources() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (Exception exception) {
            throw new RuntimeException("error to close resources: " + exception.getMessage());
        }
    }
}
