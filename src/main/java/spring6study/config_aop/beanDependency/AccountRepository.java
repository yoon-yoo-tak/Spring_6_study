package spring6study.config_aop.beanDependency;

public interface AccountRepository {
    void updateAccount(String accountId, double amount);
}