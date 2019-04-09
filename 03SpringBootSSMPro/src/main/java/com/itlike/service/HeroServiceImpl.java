package com.itlike.service;

import com.itlike.mapper.HeroMapper;
import com.itlike.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroMapper heroMapper;

    @Override
    public List<Hero> getAllHero() {
        List<Hero> allHero = heroMapper.getAllHero();
        List<Hero> heroes = heroMapper.selectAll();
        //System.out.println(heroes);
        return allHero;
    }
}
