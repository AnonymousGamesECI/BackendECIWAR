package edu.eci.arsw.eciwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.eciwar"})
public class ECIWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECIWarApplication.class, args);
	}
}
