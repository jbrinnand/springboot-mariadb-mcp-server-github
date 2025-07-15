package com.ct.springboot_mariadb;

import com.ct.springboot_mariadb.service.AccountService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootMariadbMCPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMariadbMCPApplication.class, args);
	}

	@Bean
	public List<ToolCallback> toolCallbacks(AccountService accountService) {
		return List.of(ToolCallbacks.from(accountService));
	}
}
