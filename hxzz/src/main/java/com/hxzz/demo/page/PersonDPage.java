package com.hxzz.demo.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.result.PersonDPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class PersonDPage {
    @Autowired
    PersonDPackage personDPackage;

    public void clientPage(int pageNum, int pageSize, LocalDate date1, LocalDate date2) throws Exception {
/*
        List<PersonDShow> personDList = personDPackage.PersonDList(date1, date2);
        List list =new ArrayList();
        if (personDList != null && personDList.size() > 0) {
            int size = personDList.size();
            int fromIndex = pageNum * pageSize;
            int endIndex = (pageNum + 1) * pageSize;
            if (endIndex > size) {
                endIndex = size;
            }

             list = personDList.subList(fromIndex, endIndex);
        }
else {
    throw new Exception("数据为空");
        }
        return list;

*/
    }


}