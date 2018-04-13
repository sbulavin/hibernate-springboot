package com.example.hibernate.springboot;

import com.example.hibernate.springboot.service.ManageEmployeeService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ManageEmployeeService manageEmployeeService;

//	@EventListener(ContextStartedEvent.class)
//	public void onStartup(){
//		manageEmployeeService
//	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
