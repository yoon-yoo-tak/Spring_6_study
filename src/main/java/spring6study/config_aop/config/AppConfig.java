package spring6study.config_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring6study.config_aop") // 패키지 내 모든 컴포넌트 자동 스캔
public class AppConfig {
}