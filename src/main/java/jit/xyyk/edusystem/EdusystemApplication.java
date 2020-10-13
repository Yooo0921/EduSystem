package jit.xyyk.edusystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"jit.xyyk.edusystem.repository"})
public class EdusystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdusystemApplication.class, args);
    }

}
