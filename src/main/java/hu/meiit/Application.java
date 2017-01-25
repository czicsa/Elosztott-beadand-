package hu.meiit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ImportResource({ "/spring/sajat-servlet.xml", "/spring/sajat-servlet-integration.xml" })
@ComponentScan(basePackages = {
        "hu.meiit" }, excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
