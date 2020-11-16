package com.lin.EnjoyLife;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.EnjoyLife.mapper")
public class EnjoyLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnjoyLifeApplication.class, args);
	}

}
