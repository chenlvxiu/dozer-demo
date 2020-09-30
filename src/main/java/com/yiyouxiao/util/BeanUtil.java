package com.yiyouxiao.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by chenkaiwen on 18/3/16.
 */
@Slf4j
@Component
public class BeanUtil {

//    private static DozerBeanMapper mapper = new DozerBeanMapper();

    private static Mapper mapper;

    @Autowired
    private Mapper dozerMapper;

    @PostConstruct
    public void init() {
        mapper = dozerMapper;
    }

    public static <T> T bean2bean(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    public static void bean2bean(Object source, Object target) {
        mapper.map(source, target);
    }

    public static <T> Set<T> toSet(Set source, Class<T> destinationClass) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        Set result = new HashSet();
        for (Object obj : source) {
            result.add(mapper.map(obj, destinationClass));
        }

        return result;
    }


    public static <T> List<T> list2list(List source, Class<T> destinationClass) {
        if (CollectionUtils.isEmpty(source)) return new ArrayList<>();

        List result = new ArrayList();
        for (Object obj : source) {
            result.add(mapper.map(obj, destinationClass));
        }

        return result;
    }


    public static <T> IPage<T> page2page(IPage source, Class<T> clazz) {
        Page<T> page = new Page<>();
        page.setTotal(source.getTotal());
        page.setSize(source.getSize());
        page.setCurrent(source.getCurrent());

        List<T> records = new ArrayList<T>();
        if (CollectionUtils.isNotEmpty(source.getRecords())) {
            for (Object record : source.getRecords()) {
                T t = bean2bean(record, clazz);
                records.add(t);
            }
            page.setRecords(records);
        }

        return page;
    }

    /**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, String> getNamValMap(Object obj, boolean isSort) {
        Map<String, String> map = null;
        if (isSort) {
            map = new TreeMap<>();
        } else {
            map = new HashMap<>();
        }
        Field[] fieldArr = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fieldArr) {
                field.setAccessible(true);
                if (field.get(obj) != null && !"".equals(field.get(obj).toString())) {
                    map.put(field.getName(), field.get(obj).toString());
                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        }
        return map;
    }

}

