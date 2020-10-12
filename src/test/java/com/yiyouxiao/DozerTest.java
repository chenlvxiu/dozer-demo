package com.yiyouxiao;

import com.yiyouxiao.modle.*;
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

        C c = new C();
        c.setInnerProp("ccc");
        A a = A.builder().num("10")
                .aName("hello")
                .desc("this is A")
                .ids(new Long[]{1l, 2l, 3l})
                .date("2020-10-12 10:47:33")
                .c(c)
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

    @Test
    public void test3 (){
        A a = A.builder().desc("1,2,3").build();
        D d = BeanUtil.bean2bean(a, D.class);
        System.out.println(d);
    }

}
