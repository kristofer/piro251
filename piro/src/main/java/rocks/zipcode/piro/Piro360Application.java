package rocks.zipcode.piro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Piro360Application {

	public static void main(String[] args) {
		SpringApplication.run(Piro360Application.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Allow all paths
                .allowedOrigins("*") // Allow all origins
                .allowedMethods("*") // Allow all methods (GET, POST, PUT, etc.)
                .allowedHeaders("*"); // Allow all headers
				//registry.addMapping("/api/*").allowedOrigins("http://localhost:9000");
			}
		};
	}

}
