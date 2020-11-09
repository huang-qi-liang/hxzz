package com.hxzz.demo.result;

import com.hxzz.demo.service.Quality3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class Quality3Package {
    @Autowired
    Quality3Service quality3Service;
    public List line(String date, String name) {

        List list = new ArrayList();
        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);

        list.addAll(quality3Service.each(date2, name));
        return list;
    }

}
