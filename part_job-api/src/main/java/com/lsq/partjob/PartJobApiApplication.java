package com.lsq.partjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.lsq.*.service", "com.lsq.*.repository", "com.lsq.partjob.*.controller"})
@MapperScan("com.lsq.*.repository.mapper")
@Import(WebSocketConfig.class)
public class PartJobApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PartJobApiApplication.class, args);
    }
}
