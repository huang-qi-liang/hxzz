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
    /*
   public PersonD showDCTrimMan(){return personDMapper.showDCTrimMan();}
    PersonD showDCDomainMan();
    PersonD showDCGateLineMan();
    PersonD showDCTerminalLineMan();
    PersonD showDDTrimman();
    PersonD showDDDomainMan();
    PersonD showDDGateLineMan();
    PersonD showDDTerminalLineMan();
    PersonD showDDebugMna();
    PersonDShow showDCTrim();
    PersonDShow showDCDomain();
    PersonDShow showDCGateLine();
    PersonDShow showDCTerminalLine();
    PersonDShow showDDTrim();
    PersonDShow showDDDomain();
    PersonDShow showDDGateLine();
    PersonDShow showDDTerminalLine();
    PersonDShow showDDebug();
    List<PersonD> getDCTrimMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDCDomainMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDCGateLineMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDCTerminalLineMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDDTrimMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDDDomainMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDDGateLineMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDDTerminalLineMan(LocalDate date1,LocalDate date2);
    List<PersonD> getDDebugMan(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDCTrim(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDCDomain(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDCGateLine(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDCTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDDTrim(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDDDomain(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDDGateLine(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDDTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonDShow> getDDebug(LocalDate date1,LocalDate date2);

     */
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
