package spring6study.config_aop.beanDependency;

class TransferServiceImpl implements TransferService {
    private final AccountRepository accountRepository;

    // 생성자를 통해 의존성 주입
    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void transfer() {
        System.out.println("Transferring money...");
        accountRepository.save();
    }
}