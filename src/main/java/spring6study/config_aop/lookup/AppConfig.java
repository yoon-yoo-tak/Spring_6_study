package spring6study.config_aop.lookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    @Scope("prototype") // 요청할 때마다 새로운 객체 생성
    public AsyncCommand asyncCommand() {
        return new AsyncCommand();
    }

    // 룩업 메서드 주입을 활용한 CommandManager 등록
    @Bean
    public CommandManager commandManager() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }

}
