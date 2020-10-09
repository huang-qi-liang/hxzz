package com.hxzz.demo.service.impl;

import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.mapper.PersonDMapper;
import com.hxzz.demo.service.PersonDService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
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
    public List<PersonD> show(){return personDMapper.show();}
    public List<PersonDShow> showClient(){return personDMapper.showClient();}
    public PersonDShow Sum(){return personDMapper.Sum();}
    public List<PersonD> getData(LocalDate date1,LocalDate date2){return personDMapper.getData(date1,date2);}
    public List<PersonDShow> getClient(LocalDate date){return personDMapper.getClient(date);}
    public List<PersonDShow> sumClient(LocalDate date1,LocalDate date2){return personDMapper.sumClient(date1,date2);}
    public void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave){
        personDMapper.add(region,  personalLeave,  sickLeave,  annualLeave,  nursingLeave,
             bereavementLeave);}
    public void del(Integer id){personDMapper.del(id);}
    public void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                Integer bereavementLeave){
        personDMapper.change( id,region, personalLeave,  sickLeave,  annualLeave,  nursingLeave,
                 bereavementLeave);
    }
}
