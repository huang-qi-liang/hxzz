package com.hxzz.demo.service;

import com.hxzz.demo.entity.PersonD;
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
public interface PersonDService extends IService<PersonD> {
    PersonD showDCTrim();
    PersonD showDCDomain();
    PersonD showDCGateLine();
    PersonD showDCTerminalLine();
    PersonD showDDTrim();
    PersonD showDDDomain();
    PersonD showDDGateLine();
    PersonD showDDTerminalLine();
    PersonD showDDebug();
    List<PersonD> getDCTrim(LocalDate date1, LocalDate date2);
    List<PersonD> getDCDomain(LocalDate date1,LocalDate date2);
    List<PersonD> getDCGateLine(LocalDate date1,LocalDate date2);
    List<PersonD> getDCTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonD> getDDTrim(LocalDate date1,LocalDate date2);
    List<PersonD> getDDDomain(LocalDate date1,LocalDate date2);
    List<PersonD> getDDGateLine(LocalDate date1,LocalDate date2);
    List<PersonD> getDDTerminalLine(LocalDate date1,LocalDate date2);
    List<PersonD> getDDebug(LocalDate date1,LocalDate date2);
    void add( String region, Integer personalLeave, Integer sickLeave, Integer annualLeave, Integer nursingLeave,
              Integer bereavementLeave);
    void del(Integer id);
    void change(Integer id,String region,Integer personalLeave, Integer sickLeave, Integer annualLeave,
                Integer nursingLeave,
                Integer bereavementLeave);
}
