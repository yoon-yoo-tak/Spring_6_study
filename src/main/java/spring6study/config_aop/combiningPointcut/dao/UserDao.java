package spring6study.config_aop.combiningPointcut.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void saveUser() {
        System.out.println("UserDao: 사용자 저장\n");
    }
}