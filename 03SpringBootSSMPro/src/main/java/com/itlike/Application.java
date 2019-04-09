package com.itlike;

/*import org.mybatis.spring.annotation.MapperScan;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.itlike.mapper")     // 已经自动扫面   将mapper的接口交由spring管理   引入tk mapperScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
