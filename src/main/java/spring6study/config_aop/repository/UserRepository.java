package spring6study.config_aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6study.config_aop.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
