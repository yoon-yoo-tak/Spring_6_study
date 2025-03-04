package spring6study.config_aop.lookup;

public interface Command
{
    void setState(Object commandState);
    Object execute();
}
