package com.itlike.web;

import com.itlike.Service.HeroService;
import com.itlike.pojo.Hero;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.PropertyValuesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.swing.*;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Api(value="用户controller",tags={"Hero操作接口"})
@Controller
public class MainController {

    @Autowired
    private HeroService heroService;
    @ApiIgnore
    @GetMapping("/main")
    public String main(Model model){
        List<Hero> allHero = heroService.getAllHero();
        //System.out.println(allHero);
        model.addAttribute("heroList",allHero);
        return "main";
    }

    @ApiIgnore
    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @ApiIgnore
    @PostMapping("/addHero")
    public String addHero(Hero hero){

        heroService.insertHero(hero);
        return "redirect:/main";
    }

    @ApiIgnore
    @PutMapping("addHero")
    public String editHero(Hero hero){

        heroService.updateHero(hero);
        return "redirect:/main";
    }

    /*做一个初始化参数的绑定
    * 修改日期格式
    * */
    @InitBinder
    public void  InitBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            public void setAsText(String value){
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    /*如果不传值  则设置为null值*/
                   setValue(null);
                }
            }

            public String getAsText(){
                return  new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());
            }

        });
    }

    @ApiIgnore
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        //根据当前的id获取记录
        Hero hero = heroService.getOneHero(id);
        //System.out.println(hero);
        model.addAttribute("hero",hero);
        return "add";
    }

    @ApiIgnore
    @DeleteMapping("/edit/{id}")
    public String delete(@PathVariable("id") Integer id){
        heroService.deleteHero(id);
        return "redirect:/main";
    }

    @ApiOperation(value="获取Hero信息",notes="注意问题点",httpMethod="GET")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "path")})
    @GetMapping("/test/{id}")
    @ResponseBody
    public Hero test(@PathVariable("id") Integer id){
        Hero hero = heroService.getOneHero(id);
        return hero;
    }
}
