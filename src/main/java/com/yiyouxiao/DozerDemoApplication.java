package com.yiyouxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author clx
 * @version 1.0
 * @date 2020/9/29 15:42
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DozerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DozerDemoApplication.class, args);
    }
}
