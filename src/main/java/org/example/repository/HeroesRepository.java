package org.example.repository;

import org.example.dao.HeroesDao;
import org.example.dao.HeroesDaoImpl;
import org.example.dto.HeroesDto;

import java.io.IOException;
import java.util.List;

public class HeroesRepository {

    private final HeroesDao heroesDao;

    public HeroesRepository() {
        this.heroesDao = new HeroesDaoImpl();
    }

    public List<HeroesDto> findAll() throws IOException{
        return heroesDao.findAll();
    }

    public HeroesDto finById(int id) throws IOException{
        return heroesDao.finById(id);
    }

}
