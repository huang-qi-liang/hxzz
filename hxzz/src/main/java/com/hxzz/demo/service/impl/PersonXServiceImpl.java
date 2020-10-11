package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonXShow;
import com.hxzz.demo.entity.PersonX;
import com.hxzz.demo.entity.PersonX;
import com.hxzz.demo.mapper.PersonDMapper;
import com.hxzz.demo.mapper.PersonXMapper;
import com.hxzz.demo.service.PersonXService;
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
public class PersonXServiceImpl extends ServiceImpl<PersonXMapper, PersonX> implements PersonXService {
@Autowired
    PersonXMapper personXMapper;

 @Override
 public List<PersonX> show(){return personXMapper.show();}
 public List<PersonXShow> showClient(){return personXMapper.showClient();}
 public PersonXShow Sum(){return personXMapper.Sum();}
 public List<PersonX> getData(LocalDate date1,LocalDate date2){return personXMapper.getData(date1,date2);}
 public List<PersonXShow> getClient(LocalDate date1,LocalDate date2){return personXMapper.getClient(date1,date2);}
 public PersonXShow sumClient(LocalDate date1,LocalDate date2){return personXMapper.sumClient(date1,date2);}
 public void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                  Integer bereavementLeave){
  personXMapper.add(region,  personalLeave,  sickLeave,  annualLeave,  nursingLeave,
          bereavementLeave);}
 public void del(Integer id){personXMapper.del(id);}
 public void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                    Integer bereavementLeave){
  personXMapper.change( id,region, personalLeave,  sickLeave,  annualLeave,  nursingLeave,
          bereavementLeave);
 }
 public PageInfo<PersonX> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
  PageHelper.startPage(pageNum,pageSize);
  List<PersonX> list=personXMapper.getData(date1,date2);
  PageInfo<PersonX> pageInfo=new PageInfo<PersonX>(list);
  return pageInfo;
 }

}
