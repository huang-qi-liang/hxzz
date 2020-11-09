package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.mapper.PersonDMapper;
import com.hxzz.demo.result.PersonDPackage;
import com.hxzz.demo.service.PersonDService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-09-23
 */
@Service
public class PersonDServiceImpl extends ServiceImpl<PersonDMapper, PersonD> implements PersonDService {
    @Autowired
    PersonDMapper personDMapper;

    @Override
    public List<PersonD> show() {
        return personDMapper.show();
    }

    public List<PersonDShow> showClient() {
        return personDMapper.showClient();
    }

    public PersonDShow Sum() {
        return personDMapper.Sum();
    }

    public List<PersonD> getData(LocalDate date1, LocalDate date2) {
        return personDMapper.getData(date1, date2);
    }

    public List<PersonDShow> getClient(LocalDate date1, LocalDate date2) {
        return personDMapper.getClient(date1, date2);
    }

    public PersonDShow sumClient(LocalDate date1, LocalDate date2) {
        return personDMapper.sumClient(date1, date2);
    }
    public   List<View> each(Integer date, String name){
        return personDMapper.each(date,name);
    }

    public View eachYear(Integer date, String name){return
            personDMapper.eachYear(date,name);}

    public List<View> total(Integer date){return
            personDMapper.total(date);}

    public View totalYear(Integer date){return personDMapper.totalYear(date);}
    public void add(String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                    Integer bereavementLeave,String shift, LocalDate date) {
        personDMapper.add(region, personalLeave, sickLeave, annualLeave, nursingLeave,
                bereavementLeave,shift, date);
    }

    public void del(Integer id) {
        personDMapper.del(id);
    }

    public void change(Integer id, String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                       Integer bereavementLeave, String shift,LocalDate date) {
        personDMapper.change(id, region, personalLeave, sickLeave, annualLeave, nursingLeave,
                bereavementLeave, shift,date);
    }

    public PageInfo<PersonD> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonD> list = personDMapper.getData(date1, date2);
        PageInfo<PersonD> pageInfo = new PageInfo<PersonD>(list);
        return pageInfo;
    }

}
