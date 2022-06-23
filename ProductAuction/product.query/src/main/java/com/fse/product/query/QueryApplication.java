package com.fse.product.query;

import com.fse.cqrs.core.infrastructure.QueryDispatcher;
import com.fse.product.query.api.queries.FindProductByIdQuery;
import com.fse.product.query.api.queries.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
public class QueryApplication {

	@Autowired
	private QueryDispatcher queryDispatcher;

	@Autowired
	private QueryHandler queryHandler;

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

	@PostConstruct
	public void registerHandlers() {

		queryDispatcher.registerHandler(FindProductByIdQuery.class, queryHandler::handle);
	}

}
