package com.itlike.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlike.pojo.Hero;
import com.itlike.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@Controller
@Slf4j
public class MyController {

    @Autowired
    private HeroService heroService;
    @Autowired
    private CacheManager cacheManager;

    //private static final Logger log = LoggerFactory.getLogger(MyController.class);
    @RequestMapping("/hello")
    public String hello(Model model){
        //System.out.println("hello SpringBoot");
        log.info("hello info  log-info级别");
        log.debug("hello  info  log-debug级别");
        List<Hero> allHero = heroService.getAllHero();
        for (Hero hero : allHero) {
            System.out.println(hero);
        }

        model.addAttribute("name","shipeixin000111");
       model.addAttribute("allHero",allHero);
        Hero hero = new Hero();
        hero.setId(1);
        hero.setUsername("what");
        hero.setPhone("10010");
        model.addAttribute("hero",hero);
        return "MyHello";
    }



    @RequestMapping("/getAllHero/{pageNum}/{pageSize}")
    @ResponseBody
    public Object getAllHero(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Hero> allHero = heroService.getAllHero();
        PageInfo<Hero> info = new PageInfo<>(allHero);
        return info;
    }


    @RequestMapping("/getOneHero/{id}")
    @ResponseBody
    public Hero getHeroById(@PathVariable("id") Integer id){
        return heroService.getHeroById(id);
    }

    @RequestMapping("/updateHero/{id}/{name}")
    @ResponseBody
    public String updateHero(@PathVariable("id")Integer id,@PathVariable("name")String name ){
        heroService.updateHero(id,name);
        cacheManager.getCache("baseCache").clear();
        return "update success";
    }

}
