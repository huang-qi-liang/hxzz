package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.PersonnelManagementClient;
import com.hxzz.demo.entity.PersonnelManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Quality3;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
public interface PersonnelManagementService extends IService<PersonnelManagement> {
    List<PersonnelManagement> show();

    List<PersonnelManagement> showClient();

    List<PersonnelManagement> info(LocalDate date1, LocalDate date2);

    List<PersonnelManagement> infoClient(LocalDate date1, LocalDate date2);

    PersonnelManagement showSum();

    PersonnelManagement infoSum(LocalDate date1, LocalDate date2);

    void add(String name, Integer establishment, Integer actualNumber, Integer availableNumber,
               Integer shouldArrive, Float actualArrive, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer establishment, Integer actualNumber, Integer availableNumber,

                  Integer shouldArrive, Float actualArrive, LocalDate date);

    PageInfo<PersonnelManagement> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
