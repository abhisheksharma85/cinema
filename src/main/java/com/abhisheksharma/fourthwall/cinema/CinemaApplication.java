package com.abhisheksharma.fourthwall.cinema;

import com.abhisheksharma.fourthwall.cinema.config.ApplicationProperties;
import com.abhisheksharma.fourthwall.cinema.config.FWProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class, FWProperties.class})
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

}
