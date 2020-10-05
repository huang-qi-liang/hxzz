package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
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
PersonD showDCTrim();
PersonD showDCDomain();
PersonD showDCGateLine();
PersonD showDCTerminalLine();
PersonD showDDTrim();
PersonD showDDDomain();
PersonD showDDGateLine();
PersonD showDDTerminalLine();
PersonD showDDebug();
List<PersonD> getDCTrim(LocalDate date1,LocalDate date2);
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
