package com.halen.c2c.social.govern.reviewer;

import com.halen.c2c.social.govern.reviewer.db.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class SocialGovernReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialGovernReviewerApplication.class, args);
    }

}
