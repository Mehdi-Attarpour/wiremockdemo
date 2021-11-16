package io.ario.wiremockdemo;

import io.ario.wiremockdemo.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Import(ApplicationConfig.class)
@SpringBootApplication
@ComponentScan(basePackages = "io.ario.wiremockdemo",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
