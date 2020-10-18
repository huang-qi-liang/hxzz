package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.EnvironmentSafe;
import com.hxzz.demo.mapper.EnvironmentSafeMapper;
import com.hxzz.demo.service.EnvironmentSafeService;
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
 * @since 2020-10-17
 */
@Service
public class EnvironmentSafeServiceImpl extends ServiceImpl<EnvironmentSafeMapper, EnvironmentSafe> implements EnvironmentSafeService {
    @Autowired
    EnvironmentSafeMapper environmentSafeMapper;

    public List<EnvironmentSafe> showClient(String date){return environmentSafeMapper.showClient(date);}
    public List<EnvironmentSafe> show(){return environmentSafeMapper.show();}
    public List<EnvironmentSafe> info(LocalDate date1, LocalDate date2){return environmentSafeMapper.info(date1,date2);}
    public  EnvironmentSafe showSum(){return environmentSafeMapper.showSum();}
    public EnvironmentSafe infoSum(LocalDate date1, LocalDate date2){return  environmentSafeMapper.infoSum( date1, date2);}
    public List<EnvironmentSafe> amount(LocalDate date1,LocalDate date2){return  environmentSafeMapper.amount(date1,date2);}
    public void del(Integer id){environmentSafeMapper.del(id);}
    public void add(Integer grey, Integer red,Integer black, LocalDate date){environmentSafeMapper.add(grey, red, black, date);}
    public void change(Integer id,Integer grey, Integer red,Integer black, LocalDate date){environmentSafeMapper.change(id, grey, red, black, date);}
    public PageInfo<EnvironmentSafe> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
        PageHelper.startPage(pageNum,pageSize);
        List<EnvironmentSafe> list=environmentSafeMapper.info(date1,date2);
        PageInfo<EnvironmentSafe> pageInfo=new PageInfo<EnvironmentSafe>(list);
        return pageInfo;
    }
}
