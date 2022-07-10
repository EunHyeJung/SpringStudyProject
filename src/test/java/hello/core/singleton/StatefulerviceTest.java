package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulerviceTest {

    @Test
    void satefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        Statefulervice statefulervice1 = ac.getBean(Statefulervice.class);
        Statefulervice statefulervice2 = ac.getBean(Statefulervice.class);

        // ThreadA : A사용자가 만원(10,000) 주문
        statefulervice1.order("userA", 10000);
        // ThreadB : B사용자가 이만원(20,000) 주문
        statefulervice2.order("userB", 20000);

        // ThreadA: 사용자A 주문 금액 조회
        int price = statefulervice1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulervice1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public Statefulervice statefulervice() {
            return new Statefulervice();
        }
    }
}