package spring6study.config_aop.multiProfile;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppConfig {

    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void init() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length > 0) {
            System.out.println("활성화된 프로파일: " + Arrays.toString(activeProfiles));
        } else {
            System.out.println("활성화된 프로파일이 없습니다. 기본 설정을 사용합니다.");
        }

        // 환경별 속성 값 출력
        String appName = environment.getProperty("app.name");
        String description = environment.getProperty("app.description");
        String dbUrl = environment.getProperty("app.database.url");
        String dbUsername = environment.getProperty("app.database.username");
        String dbPassword = environment.getProperty("app.database.password");
        String logMessage = environment.getProperty("app.log.message", "Default log message");

        System.out.println("\n=== 애플리케이션 설정 ===");
        System.out.println("애플리케이션 이름: " + appName);
        System.out.println("설명: " + description);
        System.out.println("\n=== 데이터베이스 설정 ===");
        System.out.println("DB URL: " + dbUrl);
        System.out.println("DB Username: " + dbUsername);
        System.out.println("DB Password: " + dbPassword);
        System.out.println("\n=== 로그 메시지 ===");
        System.out.println(logMessage);
    }
}
