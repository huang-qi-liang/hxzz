package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Safe;
import com.hxzz.demo.entity.Safe;
import com.hxzz.demo.mapper.SafeMapper;
import com.hxzz.demo.service.SafeService;
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
 * @since 2020-09-27
 */
@Service
public class SafeServiceImpl extends ServiceImpl<SafeMapper, Safe> implements SafeService {
@Autowired
SafeMapper safeMapper;
   public List<Safe> showClient(String date){return safeMapper.showClient(date);}
    public List<Safe> show(){return safeMapper.show();}
    public List<Safe> info(LocalDate date1,LocalDate date2){return safeMapper.info(date1,date2);}
 public  Safe showSum(){return safeMapper.showSum();}
   public Safe infoSum(LocalDate date1,LocalDate date2){return  safeMapper.infoSum( date1, date2);}
   public List<Safe> amount(LocalDate date1,LocalDate date2){return  safeMapper.amount(date1,date2);}
    public void del(Integer id){safeMapper.del(id);}
    public void add(Integer grey, Integer blue, Integer yellow, Integer red, LocalDate date){safeMapper.add(grey, blue, yellow, red, date);}
    public void change(Integer id,Integer grey,Integer blue,Integer yellow,Integer red,LocalDate date){safeMapper.change(id, grey, blue, yellow, red, date);}
 public PageInfo<Safe> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
  PageHelper.startPage(pageNum,pageSize);
  List<Safe> list=safeMapper.info(date1,date2);
  PageInfo<Safe> pageInfo=new PageInfo<Safe>(list);
  return pageInfo;
 }
}
