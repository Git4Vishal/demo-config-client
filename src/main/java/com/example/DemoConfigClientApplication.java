package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoConfigClientApplication {

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("setting environment: " + env.getProperty("configuration.projectName"));
		//System.out.println("setting environment: " + env.getProperty("server.name"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoConfigClientApplication.class, args);
	}
}

@RestController
@RefreshScope
class ProjectNameController {
	
	@Value("${configuration.projectName}")
	String projectName;

	@RequestMapping("/project-name")
	public String projectName() {
		return projectName;
	}
	
}

