package spring6study.config_aop.lookup;

import org.springframework.stereotype.Component;

@Component
public abstract class CommandManager {
    public Object process(Object commandState) {
        // 새로운 Command 객체 생성 (Spring이 자동으로 처리)
        Command command = createCommand();

        // Command 객체의 상태 설정
        command.setState(commandState);

        // 비즈니스 로직 실행
        return command.execute();
    }

    // 추상 메서드로 선언하여 Spring이 런타임에 자동으로 구현할 수 있도록 함
    protected abstract Command createCommand();
}
