//Main class && Configuration Class
package com.st;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.st.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01FirstAppDiApplication {
	
	@Bean("ldt")
	public LocalDateTime createDateTime() {
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		//Get access to IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj01FirstAppDiApplication.class, args);
		System.out.println(ctx.getClass());
		
		//Get target class method
		WishMessageGenerator generator = ctx.getBean(WishMessageGenerator.class);
		
		String result = generator.generateMsg("Jon Snow");
		
		System.out.println(result);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
