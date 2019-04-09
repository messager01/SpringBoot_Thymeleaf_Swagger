package com.itlike.Service;

import com.itlike.pojo.Hero;

import java.util.List;

public interface HeroService {
    public List<Hero> getAllHero();

    void insertHero(Hero hero);

    Hero getOneHero(Integer id);

    void updateHero(Hero hero);

    void deleteHero(Integer id);
}
