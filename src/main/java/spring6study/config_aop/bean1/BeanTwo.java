package spring6study.config_aop.bean1;

public class BeanTwo {
    public BeanTwo() {
        System.out.println("BeanTwo 생성");
    }

    public void doSomething(){
        System.out.println("BeanTwo 메서드 실행");
    }
}
