package com.yiyouxiao.modle;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author clx
 * @version 1.0
 * @date 2020/9/29 15:21
 */
@Data
public class B {

    private String desc;

    private Integer num;

    private List<Long> ids;

    private String bName;

    private String innerProp;

    private Date date;



    public void copyDesc(String desc){
        if(StringUtils.isNotBlank(desc)){
            String replace = desc.replace("A", "B");
            this.desc=replace;
        }
    }

}
