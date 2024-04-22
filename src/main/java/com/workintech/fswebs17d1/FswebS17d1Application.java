package com.workintech.fswebs17d1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FswebS17d1Application {

	@Value("${course.name}")
	static String courseName;

	@Value("${project.developer.fullname}")
	static String projectDeveloperFullname;

	public static void main(String[] args) {
		SpringApplication.run(FswebS17d1Application.class, args);

		System.out.println("courseName = " + courseName);
		System.out.println("projectDeveloperFullname = " + projectDeveloperFullname);
	}

	@Bean
	public String courseName() {
		return courseName;
	}

	@Bean
	public String projectDeveloperFullname() {
		return projectDeveloperFullname;
	}


}
