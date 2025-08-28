package online.agatstudio.activemq_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqDemo1Application.class, args);
    }

}
