package com.spring6_study.__comparing_as_is_ans_to_be_codes.java;

public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    public UserService() {
        this.userRepository = new UserRepository();
        this.notificationService = new NotificationService();
    }
    public User findUser(Long userId) {
        User foundUser = userRepository.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        notificationService.sendNotification("찾은 사용자 - " + foundUser.getName());
        return foundUser;
    }
    public User registerUser(Long userId, String name) {
        User registerdUser = userRepository.save(new User(userId, name));
        notificationService.sendNotification("새 사용자 - " + registerdUser.getName());
        return registerdUser;
    }
}
