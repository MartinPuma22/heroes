package org.example;

import org.example.dao.HeroesDao;
import org.example.dao.HeroesDaoImpl;
import org.example.dto.HeroesDto;

public class Main {
    public static void main(String[] args) {
        HeroesDao heroesDao = new HeroesDaoImpl();

        for (HeroesDto heroes : heroesDao.findAll()){
            System.out.println(heroes);
        }
    }
}