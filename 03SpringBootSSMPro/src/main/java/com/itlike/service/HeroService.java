package com.itlike.service;

import com.itlike.pojo.Hero;

import java.util.List;

public interface HeroService {
    public List<Hero> getAllHero();

    public Hero getHeroById(Integer id);

    void updateHero(Integer id ,String name);
}
