package spring6study.config_aop.parentBean;

import org.springframework.stereotype.Component;

@Component
class BankController {
    
    // TransferServiceImpl을 직접 주입받으려고 함
    private final TransferServiceImpl transferService;

    // 문제 발생: No qualifying bean ...
    public BankController(TransferServiceImpl transferService) {
        this.transferService = transferService;
    }

    public void processTransfer() {
        transferService.transfer();
    }
}