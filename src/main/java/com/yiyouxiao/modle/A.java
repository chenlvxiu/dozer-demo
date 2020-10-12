package com.yiyouxiao.modle;

import lombok.Builder;
import lombok.Data;

/**
 * @author clx
 * @version 1.0
 * @date 2020/9/29 15:21
 */
@Data
@Builder
public class A {

    private String desc;

    private String num;

    private Long[] ids;

//    @Mapping("bName")
    private String aName;

    private String date;

    private C c;


}
