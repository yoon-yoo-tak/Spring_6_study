package spring6study.config_aop.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AsyncCommand implements Command{
    private Object state;

    @Override
    public void setState(Object commandState) {
        this.state = commandState;
    }

    @Override
    public Object execute() {
        System.out.println("Executing command with state: " + state);
        return "Command Result: " + state;
    }
}
