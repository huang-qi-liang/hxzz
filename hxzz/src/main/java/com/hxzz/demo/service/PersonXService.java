package com.hxzz.demo.service;

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
