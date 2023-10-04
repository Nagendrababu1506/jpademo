package project.samplejpa.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan(basePackages = "project.samplejpa.project")
@SpringBootApplication
public class ProjectForJpaAndDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectForJpaAndDatabaseApplication.class, args);
	}

}
