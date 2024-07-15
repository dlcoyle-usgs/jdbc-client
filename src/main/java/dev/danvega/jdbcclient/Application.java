package dev.danvega.jdbcclient;

import dev.danvega.jdbcclient.post.Post;
import dev.danvega.jdbcclient.post.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	/**
	 * V1: @Qualifier("jdbcTemplatePostService")
	 * V2:  @Qualifier("JdbcClientPostService")
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			@Qualifier("JdbcClientPostService")
			PostService postService
	) {
		return args -> {
			postService.create(new Post("1234", "Hello World", "hello-world", LocalDate.now(), 1, "java, spring"));
	        };
	}

}
