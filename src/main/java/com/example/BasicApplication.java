package com.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 新建一个Spring Boot项目，名字为basic  要求运行后
1.	访问http://localhost:8080/em/info能看到git的信息,和你自己的名字，电话，邮箱等
2.	访问http://localhost:8080/em/health能看到是否能访问互联网
3.	访问 http://localhost:8080/em/metrics能访问到访问http://localhost:8080/xyz的信息
4.	使用log4j2来做日志系统
5.	定义一个TaijCongfiguration,利用FooProperties的所有属性(包括集合等)
6.	定制banner显示为太极学院
7.	提交到github上
 */

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(BasicApplication.class, args);
		
		System.out.println( run.getBean("myfp") );
		
		
	}
	
	@Bean
	public Health health() {		
		boolean errorCode = check(); 
		if(errorCode) {
			return Health.down().withDetail("Error Code", errorCode).build();
		    }
		return Health.up().build();	
	}

	public boolean check(){
		String host =  "www.baidu.com" ;       
		int  timeOut =  6000 ;
		boolean status = false;
		try {
			status = InetAddress.getByName(host).isReachable(timeOut);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return status;
	}
	
	
//	@Autowired
//	private CounterService counterService;
//	@Bean
//	public ApplicationListener<ApplicationEvent> helloListener() {
//		final String HELLO_URL = "/xyz";
//		return (ApplicationEvent event) -> {
//			if (event instanceof ServletRequestHandledEvent) {
//				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
//				if (e.getRequestUrl().equals(HELLO_URL))
//					counterService.increment("xyz+1");
//			}
//		};
//	}
	
}
