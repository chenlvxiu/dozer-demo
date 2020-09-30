package com.yiyouxiao;

import com.yiyouxiao.modle.A;
import com.yiyouxiao.modle.B;
import com.yiyouxiao.modle.E;
import com.yiyouxiao.util.BeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author clx
 * @version 1.0
 * @date 2020/9/29 15:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DozerTest {

    @Test
    public void test() {

        A a = A.builder().num("10")
                .aName("hello")
                .desc("this is A")
                .ids(new Long[]{1l, 2l, 3l})
                .date(new Date())
                .innerProp("C.properties")
                .build();
        B b = BeanUtil.bean2bean(a, B.class);

        System.out.println(b);


    }

    @Test
    public void test2() {
        A a = A.builder().desc("1,2,3").build();
        E e = BeanUtil.bean2bean(a, E.class);
        System.out.println(e);

    }

}
