package com.duong.backend;

import com.duong.backend.configs.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.sql.DataSource;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
