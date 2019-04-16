package com.itlike.mapper;

import com.itlike.pojo.Hero;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@CacheConfig(cacheNames = "baseCache")
public interface HeroMapper extends Mapper<Hero> {

    @Cacheable
    @Select("select * from `tb_hero` where id = #{id}")
    public Hero getAHeroById(@Param("id") Integer id);


    public List<Hero> getAllHero();


    void update(@Param("id") Integer id, @Param("name") String name);




}
