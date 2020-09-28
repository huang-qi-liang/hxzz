package com.hxzz.demo.mapper;


import com.hxzz.demo.entity.PersonX;
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
public interface PersonXMapper extends BaseMapper<PersonX> {
    PersonX showXBTrim();
    PersonX showXBDomain();
    PersonX showXBGateLine();
    PersonX showXBTerminalLine();
    PersonX showXCTrim();
    PersonX showXCDomain();
    PersonX showXCGateLine();
    PersonX showXCTerminalLine();
    PersonX showXDebug();
    List<PersonX> getXBTrim(LocalDate date1, LocalDate date2);
    List<PersonX> getXBDomain(LocalDate date1,LocalDate date2);
    List<PersonX> getXBGateLine(LocalDate date1,LocalDate date2);
    List<PersonX> getXBTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonX> getXCTrim(LocalDate date1,LocalDate date2);
    List<PersonX> getXCDomain(LocalDate date1,LocalDate date2);
    List<PersonX> getXCGateLine(LocalDate date1,LocalDate date2);
    List<PersonX> getXCTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonX> getXDebug(LocalDate date1,LocalDate date2);
    void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave);
    void del(Integer id);
    void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
                Integer bereavementLeave);

}
