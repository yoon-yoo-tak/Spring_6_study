package spring6study.config_aop.parentBean;

import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    @Override
    public void transfer() {
        System.out.println("송금중...");
    }
}
