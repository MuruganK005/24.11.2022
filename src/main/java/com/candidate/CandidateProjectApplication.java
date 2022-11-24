package com.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CandidateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateProjectApplication.class, args);
	}

	//create global utc date format
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


	//create password encode method for password
	public static String encodePassword(String password) {
        return new String(password.getBytes());
    }


}
