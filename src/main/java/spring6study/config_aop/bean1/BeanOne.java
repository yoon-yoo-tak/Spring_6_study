package spring6study.config_aop.bean1;

public class BeanOne {

    private final BeanTwo beanTwo;

    public BeanOne(BeanTwo beanTwo) {
        this.beanTwo = beanTwo;
        System.out.println("BeanOne 생성");
    }

    public void execute(){
        System.out.println("BeanOne에서 BeanTwo 메서드 호출");
        beanTwo.doSomething();
    }
}
