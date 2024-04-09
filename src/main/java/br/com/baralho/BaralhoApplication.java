package br.com.baralho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BaralhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaralhoApplication.class, args);
	}

}
