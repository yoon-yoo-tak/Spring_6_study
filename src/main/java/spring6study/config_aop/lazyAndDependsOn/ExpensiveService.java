package spring6study.config_aop.lazyAndDependsOn;

public class ExpensiveService {
    public ExpensiveService(){
        System.out.println("ExpensiveService 객체 생성");
    }

    public void performTask(){
        System.out.println("ExpensiveService 메서드 수행");
    }
}
