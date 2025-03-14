package spring6study.config_aop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring6study.config_aop.entity.User;
import spring6study.config_aop.repository.UserRepository;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class UserInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    public UserInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            Random random = new Random();
            IntStream.range(0, 1000).forEach(i -> {
                String username = "User" + i;
                String email = "user" + i + "@example.com";
                userRepository.save(new User(username, email));
            });
            System.out.println("Inserted 10000 users into H2 database.");
        }
    }
}