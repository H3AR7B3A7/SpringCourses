package be.dog.d.steven.basemodule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@org.springframework.context.annotation.PropertySource("classpath:application.properties")
public class EnvironmentVariables implements CommandLineRunner {

    @Value("${COMPUTERNAME}")
    String name;

    @Value("${computer-name}")
    String name2;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentVariables.class, args);

        Map<String, String> env = System.getenv();

        System.out.println("From System.getenv() : " + env.get("COMPUTERNAME"));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("From application.properties @Value name2 : " + name2);
        logger.info("From System @Value name: {}", name);
    }

}
