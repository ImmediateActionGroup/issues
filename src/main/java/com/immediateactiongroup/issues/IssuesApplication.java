package com.immediateactiongroup.issues;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.immediateactiongroup.issues.model.dao")
public class IssuesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuesApplication.class, args);
	}
}
