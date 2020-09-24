package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.PersonX;
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
@Autowired
public PersonX showXBTrim(){return personXMapper.showXBTrim();}
 public    PersonX showXBDomain(){return personXMapper.showXBDomain();}
 public    PersonX showXBGateLine(){return personXMapper.showXBGateLine();}
 public    PersonX showXBTerminalLine(){return personXMapper.showXBTerminalLine();}
 public    PersonX showXCTrim(){return personXMapper.showXCTrim();}
  public   PersonX showXCDomain(){return personXMapper.showXCDomain();}
  public PersonX showXCGateLine(){return personXMapper.showXCGateLine();}
   public PersonX showXCTerminalLine(){return personXMapper.showXCTerminalLine();}
  public   PersonX showXDebug(){return personXMapper.showXDebug();}
   public List<PersonX> getXBTrim(LocalDate date1, LocalDate date2){return personXMapper.getXBTrim(date1,date2);}
   public List<PersonX> getXBDomain(LocalDate date1,LocalDate date2){return personXMapper.getXBDomain(date1,date2);}
   public List<PersonX> getXBGateLine(LocalDate date1,LocalDate date2){return personXMapper.getXBGateLine(date1,date2);}
   public List<PersonX> getXBTerminalLine(LocalDate date1,LocalDate date2){return personXMapper.getXBTerminalLine(date1,date2);}
    public List<PersonX> getXCTrim(LocalDate date1,LocalDate date2){return personXMapper.getXCTrim(date1,date2);}
   public List<PersonX> getXCDomain(LocalDate date1,LocalDate date2){return personXMapper.getXCDomain(date1,date2);}
   public List<PersonX> getXCGateLine(LocalDate date1,LocalDate date2){return personXMapper.getXCGateLine(date1,date2);}
   public List<PersonX> getXCTerminalLine(LocalDate date1,LocalDate date2){return personXMapper.getXCTerminalLine(date1,date2);}
   public List<PersonX> getXDebug(LocalDate date1,LocalDate date2){return personXMapper.getXDebug(date1,date2);}
   public void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave){personXMapper.add(region,  personalLeave,  sickLeave,  annualLeave,  nursingLeave,
           bereavementLeave);}
   public void del(Integer id){
    personXMapper.del(id);
   }
    public void change(Integer id,Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                Integer bereavementLeave){
    personXMapper.change(id, personalLeave,  sickLeave,  annualLeave,  nursingLeave,
            bereavementLeave);
    }
}
