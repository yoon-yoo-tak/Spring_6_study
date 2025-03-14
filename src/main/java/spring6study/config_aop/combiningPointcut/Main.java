package spring6study.config_aop.combiningPointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring6study.config_aop.combiningPointcut.dao.UserDao;
import spring6study.config_aop.combiningPointcut.service.AdminService;
import spring6study.config_aop.combiningPointcut.service.UserService;

@Configuration
@ComponentScan("spring6study.config_aop.combiningPointcut")
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        UserService userService = ctx.getBean(UserService.class);
        AdminService adminService = ctx.getBean(AdminService.class);
        UserDao userDao = ctx.getBean(UserDao.class);

        System.out.println("=== AOP TEST ===");

        userService.getUserInfo();
        adminService.manageUsers();
        userDao.saveUser();
    }
}
