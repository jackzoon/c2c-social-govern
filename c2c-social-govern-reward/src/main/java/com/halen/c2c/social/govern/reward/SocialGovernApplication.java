package com.halen.c2c.social.govern.reward;

import com.halen.c2c.social.govern.reward.db.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class SocialGovernApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialGovernApplication.class, args);
    }

}
