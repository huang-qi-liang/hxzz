package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.entity.PersonD;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-23
 */
@Component

public interface PersonDMapper extends BaseMapper<PersonD> {
PersonD showDCTrimMan();
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
void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
          Integer bereavementLeave);
void del(Integer id);
void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave,
            Integer nursingLeave,
            Integer bereavementLeave);
}
