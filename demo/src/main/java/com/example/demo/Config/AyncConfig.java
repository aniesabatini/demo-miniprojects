package com.example.demo.Config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AyncConfig {

    @Bean(name = "paymentExecutor")

	public Executor paymentExecutor() {
    	ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
    	  executor.setCorePoolSize(5);
          executor.setMaxPoolSize(10);
          executor.setQueueCapacity(50);
          executor.setThreadNamePrefix("Payment-Async-");
          executor.initialize();
          return executor;
			
		}
	}

