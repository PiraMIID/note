package com.noteapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Arrays;


@SpringBootApplication
@EnableSwagger2
//@EnableFeignClients
@ConfigurationPropertiesScan
public class DemoApplication {

//    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    final ConfigurableApplicationContext applicationContext = SpringApplication
        .run(DemoApplication.class, args);

//        show create beans in console when app starting
//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(LOG::info);

  }


}
