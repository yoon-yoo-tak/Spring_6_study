package spring6study.config_aop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring6study.config_aop.entity.User;
import spring6study.config_aop.service.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @GetMapping("/by-username")
    public Optional<User> getUserByUsername(@RequestParam(name = "username") String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/by-email")
    public Optional<User> getUserByEmail(@RequestParam(name = "email") String email) {
        return userService.findByEmail(email);
    }
}