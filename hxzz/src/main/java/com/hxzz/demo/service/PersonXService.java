package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.bean.PersonXShow;
import com.hxzz.demo.entity.PersonX;

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
public interface PersonXService extends IService<PersonX> {
    List <PersonX> show();
    List <PersonXShow> showClient();
    PersonXShow Sum();
    List<PersonX> getData(LocalDate date1,LocalDate date2);
    List<PersonXShow> getClient(LocalDate date1,LocalDate date2);
    PersonXShow sumClient(LocalDate date1,LocalDate date2);
    void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave,LocalDate date);
    void del(Integer id);
    void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave,
                Integer nursingLeave,
                Integer bereavementLeave,LocalDate date);
    PageInfo<PersonX> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
