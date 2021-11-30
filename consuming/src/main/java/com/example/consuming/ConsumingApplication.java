package com.example.consuming;

import com.example.consuming.entity.Joke;
import com.sun.org.apache.xml.internal.utils.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ConsumingApplication {

	//private static final Logger log = LoggerFactory.getLogger(ConsumingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApplication.class, args);
	}

	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Joke joke = restTemplate.getForObject(
					"https://official-joke-api.appspot.com/random_joke", Joke.class);
			log.info(joke.toString());
		};
	}*/

	String a[] = {"100","101","102","200","201","202","203","204","206","207","300","301","302","303","304","305","307","308","400","401","402","403","404","405","406","407","408","409","410","411","412","413","414"

	,"415","416","417","418","420","421","422","423","425","426","429","431","444","450","451","497","498","499","500","501","502","503","504","506","507","508","509","510","511","521","523","525","599"

	};
	List<String>  list = Arrays.asList(a);
	UriComponentsBuilder uriBuilder =  new UriComponentsBuilder().newInstance()
			.uri("https://http.cat/")
			.path(getRandomStatusCode(list))
			.build;
	public String getRandomStatusCode(List<String> list){


		Random rand = new Random();

		int randomItem = rand.nextInt(list.size());

		String randomElement = list.get(randomItem);

		return randomElement;
	}





}
