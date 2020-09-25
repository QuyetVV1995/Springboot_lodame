package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		// Spring đặt tên cho container là ApplicationContext, đặt tên cho các dependency là Bean
		// ApplicationContext chứa toàn bộ dependency trong project.
		ApplicationContext context = SpringApplication.run(DemoSpringBootApplication.class, args);

		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh dấu @Component
		// Lấy Bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);
		outfit.wear();

		Girl girl = context.getBean(Girl.class);

		System.out.println("Girl Instance: " + girl);

		System.out.println("Girl Outfit: " + girl.outfit);

		girl.outfit.wear();

	}

}
