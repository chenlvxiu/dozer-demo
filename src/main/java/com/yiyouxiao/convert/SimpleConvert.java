package com.yiyouxiao.convert;

import com.yiyouxiao.modle.A;
import com.yiyouxiao.modle.E;
import lombok.SneakyThrows;
import org.dozer.DozerConverter;

/**
 * @author clx
 * @version 1.0
 * @date 2020/9/30 15:08
 */
public class SimpleConvert extends DozerConverter<A, E> {



    public SimpleConvert() {
        super(A.class, E.class);
    }


    @SneakyThrows
    @Override
    public E convertTo(A a, E e) {
        String desc = a.getDesc();
        String[] split = desc.split(",");
        if(e==null){
            e = E.class.getDeclaredConstructor().newInstance();
        }
        e.setDesc(split);
        return e;
    }

    @SneakyThrows
    @Override
    public A convertFrom(E e, A a) {
        String[] desc = e.getDesc();
        String string = new String(String.valueOf(desc));
        if(a==null){
             a = A.class.getDeclaredConstructor().newInstance();
        }
        a.setDesc(string);
        return a;
    }
}
