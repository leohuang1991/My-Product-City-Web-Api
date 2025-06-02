package com.example.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

	@Bean
	public float confloat() {
		return 1.0f;
	}
}
