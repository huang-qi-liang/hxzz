package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.Equipment;
import com.hxzz.demo.entity.Equipmentstatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.Equipmentstatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
@Component
public interface EquipmentstatusMapper extends BaseMapper<Equipmentstatus> {
    List<Equipmentstatus> show();

    List<Equipmentstatus> showClient();

    List<Equipmentstatus> info(LocalDate date1, LocalDate date2);

    List<Equipmentstatus> infoClient(LocalDate date1, LocalDate date2);

    Equipmentstatus showSum();

    //计算一段时间的设备故障率
    Equipmentstatus infoSum(LocalDate date1, LocalDate date2);

    /* Integer waitingToBeLoadedSum(LocalDate date);
     Integer loopToCrossTheLineSum(LocalDate date);
     Integer bhCirculationSum(LocalDate date);
     Integer actualCirculationSum(LocalDate date);
     Integer totalSum(LocalDate date);

     */
    List<Equipment> each(Integer date, String name);

    Equipment eachYear(Integer date, String name);

    List<Equipment> total(Integer date);

    Equipment totalYear(Integer date);


    void add(String name, Float failureTime, Float officeTime,String shift, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Float failureTime, Float officeTime,String shift, LocalDate date);

}
