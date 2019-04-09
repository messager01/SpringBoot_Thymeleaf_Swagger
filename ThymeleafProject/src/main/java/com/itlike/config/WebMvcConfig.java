package com.itlike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","login","userLogin","/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*设置默认跳转的视图*/
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean      //把返回的对象交由spring来管理
    public LocaleResolver localeResolver(){
        return  new MyLocalResolver();
    }


}
