package com.hxzz.demo.service;

import com.hxzz.demo.bean.PersonDShow;

import com.hxzz.demo.entity.PersonD;

import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-23
 */
public interface PersonDService extends IService<PersonD> {
    List <PersonD> show();
    List <PersonDShow> showClient();
    PersonDShow Sum();
    List<PersonD> getData(LocalDate date1,LocalDate date2);
    List<PersonDShow> getClient(LocalDate date);
    List<PersonDShow> sumClient(LocalDate date1,LocalDate date2);
    void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave);
    void del(Integer id);
    void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave,
                Integer nursingLeave,
                Integer bereavementLeave);
}
