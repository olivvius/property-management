package com.propertymanagement;

import com.propertymanagement.entity.PropertyEntity;
import com.propertymanagement.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@AllArgsConstructor
@SpringBootApplication
public class PropertyManagementApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PropertyManagementApplication.class, args);



		PropertyRepository propertyRepository = ctx.getBean(PropertyRepository.class);

		PropertyEntity pe = new PropertyEntity("this title", "a very simple desc", "mr Bean", "bean@gmail.com", 20.0, "New York street");

		propertyRepository.save(pe);




	}

}
