package spring6study.config_aop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring6study.config_aop.entity.User;
import spring6study.config_aop.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}