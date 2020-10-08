package com.hxzz.demo.service;

import com.hxzz.demo.bean.PersonnelManagementClient;
import com.hxzz.demo.entity.PersonnelManagement;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
public interface PersonnelManagementService extends IService<PersonnelManagement> {
    PersonnelManagement showSgmwIN();
    PersonnelManagement showOutsourceIN();
    List<PersonnelManagement> getData(LocalDate date1, LocalDate date2);

    PersonnelManagementClient showSgmwClient();
    PersonnelManagementClient showOutsourceClient();

    List<PersonnelManagementClient> getClient(LocalDate date1, LocalDate date2);
    void addIN(String name,Integer establishment,Integer actualNumber,Integer availableNumber,Float attendanceRate,
             Integer shouldArrive,Integer actualArrive);
    void delIN(Integer id);
    void changeIN(Integer id,String name,Integer establishment,Integer actualNumber,Integer availableNumber,
                Float attendanceRate,
                Integer shouldArrive,Integer actualArrive);

}
