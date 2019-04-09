package com.itlike.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jdbc")
//  @Data的作用相当于  setter  getter
@Data
public class JdbcProperties {
    private String url;

    private String driver;

    private String username;

    private String password;
}
