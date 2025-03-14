package spring6study.config_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "spring6study.config_aop") // 패키지 내 모든 컴포넌트 자동 스캔
                //,excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class))
public class AppConfig {
}