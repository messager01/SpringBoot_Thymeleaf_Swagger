package com.itlike.config;


import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        /*接受语言的参数*/
        String lan = request.getParameter("lan");
        /*判断lan是否接收到了参数，接受到的话使用lan   没有接收到就 使用 默认的locale*/
        Locale locale = Locale.getDefault();
        if(!Strings.isEmpty(lan)){
            //zh_CN
            String[] s = lan.split("_");
              locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
