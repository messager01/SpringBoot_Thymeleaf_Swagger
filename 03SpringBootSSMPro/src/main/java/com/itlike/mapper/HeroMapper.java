package com.itlike.mapper;

import com.itlike.pojo.Hero;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HeroMapper extends Mapper<Hero> {
    public List<Hero> getAllHero();




}
