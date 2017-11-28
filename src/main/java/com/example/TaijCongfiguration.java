package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FooProperties.class)
public class TaijCongfiguration {
			
		@Autowired
		private FooProperties fp;
		
		@Bean
		public FooProperties myfp() {
			return fp;
		}

	}