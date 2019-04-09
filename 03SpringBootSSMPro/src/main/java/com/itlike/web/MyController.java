package com.itlike.web;

import com.itlike.pojo.Hero;
import com.itlike.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class MyController {

    @Autowired
    private HeroService heroService;

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
}
