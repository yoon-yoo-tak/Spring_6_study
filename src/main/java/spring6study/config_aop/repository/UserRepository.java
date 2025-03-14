package spring6study.config_aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6study.config_aop.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // 인덱스 있음 (빠름)
    Optional<User> findByEmail(String email); // 인덱스 없음 (느림)
}