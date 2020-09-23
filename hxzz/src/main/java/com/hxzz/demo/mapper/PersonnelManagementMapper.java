package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.PersonnelManagement;
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
 * @since 2020-09-16
 */
@Component
public interface PersonnelManagementMapper extends BaseMapper<PersonnelManagement> {
    PersonnelManagement showSgmw();
    PersonnelManagement showOutsource();
    List<PersonnelManagement> getSgmwData(LocalDate date1, LocalDate date2);
    List<PersonnelManagement> getOutsource(LocalDate date1, LocalDate date2);
    void add(String name,Integer establishment,Integer actualNumber,Integer availableNumber,Float attendanceRate,
             Integer shouldArrive,Integer actualArrive);
    void del(Integer id);
    void change(Integer id,String name,Integer establishment,Integer actualNumber,Integer availableNumber,
                Float attendanceRate,
                Integer shouldArrive,Integer actualArrive);


}
