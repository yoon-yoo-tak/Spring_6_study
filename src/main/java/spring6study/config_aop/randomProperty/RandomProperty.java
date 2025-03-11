package spring6study.config_aop.randomProperty;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomProperty {
    @Value("${test.secret}")
    private String secret;

    @Value("${test.number}")
    private int number;

    @Value("${test.bignumber}")
    private long bigNumber;

    @Value("${test.uuid}")
    private UUID uuid;

    @Value("${test.number.less.than.ten}")
    private int lessThanTen;

    @Value("${test.number.in.range}")
    private int numberInRange;

    public void print(){
        System.out.println("secret = " + secret);
        System.out.println("number = " + number);
        System.out.println("bigNumber = " + bigNumber);
        System.out.println("uuid = " + uuid);
        System.out.println("lessThanTen = " + lessThanTen);
        System.out.println("numberInRange = " + numberInRange);
    }
}
