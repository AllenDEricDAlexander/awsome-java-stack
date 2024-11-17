package top.atluofu.ssmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "top.atluofu.ssmp")
public class SsmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmpApplication.class, args);
    }

}
