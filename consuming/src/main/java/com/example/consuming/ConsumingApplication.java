package com.example.consuming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
@SpringBootApplication
public class ConsumingApplication implements  CommandLineRunner {
	@Autowired
	private RestTemplate restTemplate;
	String[] a = {"100","101","102","200","201","202","203","204","206","207","300","301","302","303","304","305","307","308","400","401","402","403","404","405","406","407","408","409","410","411","412","413","414"
			,"415","416","417","418","420","421","422","423","425","426","429","431","444","450","451","497","498","499","500","501","502","503","504","506","507","508","509","510","511","521","523","525","599"
	};
	public static void main(String[] args) {
		SpringApplication.run(ConsumingApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, List<HttpMessageConverter<?>> messageConverters) {
		return builder.messageConverters(messageConverters)
				.build();
	}
	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}
	@Override
	public void run(String... args) throws Exception {
		List<String>  list = Arrays.asList(a);
		String pictureId = getRandomStatusCode(list);
		String url = "https://http.cat/" + pictureId;
		byte[] imageBytes = restTemplate.getForObject(url, byte[].class);
		Files.write(Paths.get(pictureId + ".jpg"), imageBytes);
	}
	public String getRandomStatusCode(List<String> list){
		Random rand = new Random();
		int randomItem = rand.nextInt(list.size());
		String randomElement = list.get(randomItem);
		return randomElement;
	}
}