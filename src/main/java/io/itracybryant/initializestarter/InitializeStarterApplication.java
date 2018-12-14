package io.itracybryant.initializestarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot启动类
 * 扫 mybatis mapper包路径
 * 扫所有要的包，包括自用工具类包所在路径
 * idworker 基于twitter的分布式id生成器
 * @author Administrator
 */
@SpringBootApplication
@MapperScan(basePackages = "io.itracybryant.initializestarter.mapper")
@ComponentScan(basePackages = {"io.itracybryant.initializestarter", "org.n3r.idworker"})
public class InitializeStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitializeStarterApplication.class, args);
    }
}
