package org.example.dao;

import org.example.dto.HeroesDto;

import java.util.List;

public interface HeroesDao {

    List<HeroesDto> findAll();

    HeroesDao finById(int id);
}
