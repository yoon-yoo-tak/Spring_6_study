package spring6study.config_aop.beanDependency;

public class TransferServiceImpl implements TransferService {
    private final AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer(double amount, String fromAccount, String toAccount) {
        System.out.println("Transferring $" + amount + " from " + fromAccount + " to " + toAccount);
        accountRepository.updateAccount(fromAccount, -amount);
        accountRepository.updateAccount(toAccount, amount);
    }
}