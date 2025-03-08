package spring6study.config_aop.lifeCycle;

class BeanTwo {
    public void customInit() {
        System.out.println("BeanTwo 초기화");
    }

    public void customDestroy() {
        System.out.println("BeanTwo 소멸");
    }
}
