package com.noteapp;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

//todo: 18: all annotations are needed?

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@ConfigurationPropertiesScan
public class DemoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);


//        show create beans in console when app starting
//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(LOG::info);
	}

}
