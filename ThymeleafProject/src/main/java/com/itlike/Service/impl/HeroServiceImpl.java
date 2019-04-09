package com.itlike.Service.impl;

import com.itlike.Service.HeroService;
import com.itlike.mapper.HeroMapepr;
import com.itlike.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;
@Service
public class HeroServiceImpl implements HeroService {

      @Autowired
      private HeroMapepr heroMapepr;
    @Override
    public List<Hero> getAllHero() {
        List<Hero> heroes = heroMapepr.selectAll();

        return heroes;
    }

    @Override
    public void insertHero(Hero hero) {
        heroMapepr.insert(hero);
    }

    @Override
    public Hero getOneHero(Integer id) {
        Hero hero = heroMapepr.selectByPrimaryKey(id);
        return hero;
    }

    @Override
    public void updateHero(Hero hero) {
        heroMapepr.updateByPrimaryKey(hero);
    }

    @Override
    public void deleteHero(Integer id) {
        heroMapepr.deleteByPrimaryKey(id);
    }
}
