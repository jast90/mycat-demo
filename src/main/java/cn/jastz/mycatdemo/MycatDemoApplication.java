package cn.jastz.mycatdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "cn.jastz.mycatdemo")
@Configuration
@MapperScan(basePackages = "cn.jastz.mycatdemo.dao")
public class MycatDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatDemoApplication.class, args);
    }

}
