package com.hoaxify.ws;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


// @SpringBootApplication(exclude = SecurityAutoConfiguration.class) // spring security yi devre dışı bırakmak için
@SpringBootApplication
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);

    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setUsername("user1");
                user.setDisplayname("display1");
                user.setPassword("P4ssword");
                userService.save(user);
            }
        };
    }

}
