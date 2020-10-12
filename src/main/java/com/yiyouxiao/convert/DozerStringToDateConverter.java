package com.yiyouxiao.convert;

import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.DozerConverter;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DozerStringToDateConverter extends DozerConverter<String, Date> {

    public DozerStringToDateConverter() {
        super(String.class, Date.class);
    }

    @Override
    public String convertFrom(Date source, String destination) {
        if(source==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        destination = formatter.format(source);
        return destination;
    }

    @SneakyThrows
    @Override
    public Date convertTo(String source, Date destination) {
        if(source==null){
            return null;
        }
       /* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        destination = formatter.parse(source, pos);*/
        destination = DateUtils.parseDateStrictly(source, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss");

        return destination;
    }

}
