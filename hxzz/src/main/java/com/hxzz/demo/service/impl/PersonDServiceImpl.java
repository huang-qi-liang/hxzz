package com.hxzz.demo.service.impl;

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
   public PersonD showDCTrim(){return personDMapper.showDCTrim();}
   public PersonD showDCDomain(){return  personDMapper.showDCDomain();}
   public PersonD showDCGateLine(){return  personDMapper.showDCGateLine();}
   public PersonD showDCTerminalLine(){return personDMapper.showDCTerminalLine();}
    public PersonD showDDTrim(){return personDMapper.showDDTrim();}
    public PersonD showDDDomain(){return personDMapper.showDDDomain();}
    public PersonD showDDGateLine(){return personDMapper.showDDGateLine();};
    public PersonD showDDTerminalLine(){return personDMapper.showDDTerminalLine();};
    public PersonD showDDebug(){return personDMapper.showDDebug();}
    public List<PersonD> getDCTrim(LocalDate date1, LocalDate date2){return personDMapper.getDCTrim(date1,date2);}
    public List<PersonD> getDCDomain(LocalDate date1,LocalDate date2){return personDMapper.getDCDomain(date1,date2);}
    public List<PersonD> getDCGateLine(LocalDate date1,LocalDate date2){return personDMapper.getDCGateLine(date1,
            date2);}
    public List<PersonD> getDCTerminalLine(LocalDate date1,LocalDate date2){return  personDMapper.getDCTerminalLine(date1,date2);}
    public List<PersonD> getDDTrim(LocalDate date1,LocalDate date2){return personDMapper.getDDTrim(date1,date2);}
    public List<PersonD> getDDDomain(LocalDate date1,LocalDate date2){return personDMapper.getDDDomain(date1,date2);}
    public List<PersonD> getDDGateLine(LocalDate date1,LocalDate date2){return personDMapper.getDDGateLine(date1,
            date2);}
    public List<PersonD> getDDTerminalLine(LocalDate date1,LocalDate date2){return  personDMapper.getDDTerminalLine(date1,date2);}
    public List<PersonD> getDDebug(LocalDate date1,LocalDate date2){return personDMapper.getDDebug(date1,date2);}
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
