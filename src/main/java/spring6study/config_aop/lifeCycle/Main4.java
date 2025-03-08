package spring6study.config_aop.lifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("=== 컨텍스트 초기화 ===");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig4.class);
        System.out.println("=== 컨텍스트 준비 완료 ===");

        context.close(); // 컨텍스트 종료 시 별도의 소멸 메서드 호출 없음
    }
}