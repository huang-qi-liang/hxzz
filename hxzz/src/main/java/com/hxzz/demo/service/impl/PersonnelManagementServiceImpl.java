package com.hxzz.demo.service.impl;

import com.hxzz.demo.bean.PersonnelManagementClient;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.mapper.PersonnelManagementMapper;
import com.hxzz.demo.service.PersonnelManagementService;
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
 * @since 2020-09-16
 */
@Service
public class PersonnelManagementServiceImpl extends ServiceImpl<PersonnelManagementMapper, PersonnelManagement> implements PersonnelManagementService {
@Autowired
PersonnelManagementMapper personnelManagementMapper;
@Override
   public PersonnelManagement showSgmwIN(){
    return personnelManagementMapper.showSgmw();
}
  public   PersonnelManagement showOutsourceIN(){
      return personnelManagementMapper.showOutsource();
  }
  public   List<PersonnelManagement> getData(LocalDate date1, LocalDate date2){
      return personnelManagementMapper.getData(date1,date2);
  }

   public PersonnelManagementClient showSgmwClient(){return personnelManagementMapper.showSgmwClient();}
    public  PersonnelManagementClient showOutsourceClient(){return personnelManagementMapper.showOutsourceClient();}

    public List<PersonnelManagementClient> getClient(LocalDate date1, LocalDate date2){return personnelManagementMapper.getClient(date1,date2);}
  public   void addIN(String name,Integer establishment,Integer actualNumber,Integer availableNumber,Float attendanceRate,
               Integer shouldArrive,Integer actualArrive){
      personnelManagementMapper.add(name, establishment, actualNumber, availableNumber, attendanceRate,
              shouldArrive,actualArrive);
  }
   public void delIN(Integer id){
    personnelManagementMapper.del(id);
   };
  public   void changeIN(Integer id,String name,Integer establishment,Integer actualNumber,Integer availableNumber,
                  Float attendanceRate,
                  Integer shouldArrive,Integer actualArrive){
      personnelManagementMapper.change(id,name, establishment, actualNumber, availableNumber, attendanceRate,
              shouldArrive,actualArrive);
  };
}
