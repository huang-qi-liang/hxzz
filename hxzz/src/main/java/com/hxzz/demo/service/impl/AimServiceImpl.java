package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Aim;
import com.hxzz.demo.entity.Aim;
import com.hxzz.demo.mapper.AimMapper;
import com.hxzz.demo.service.AimService;
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
 * @since 2020-10-14
 */
@Service
public class AimServiceImpl extends ServiceImpl<AimMapper, Aim> implements AimService {
    @Autowired
    AimMapper aimMapper;
    @Override
   public Aim show(){return  aimMapper.show();}

   public List<Aim> info(LocalDate date1, LocalDate date2){return aimMapper.info(date1,date2);}
   public void add(Integer security,Integer lzcsj,Float quality,Float equipment,LocalDate date){aimMapper.add(security, lzcsj, quality, equipment, date);}
   public void del(Long id){aimMapper.del(id);}
   public void change( Long id,Integer security,Integer lzcsj,Float quality,Float equipment,LocalDate date){aimMapper.change(id, security, lzcsj, quality, equipment, date);}
    public PageInfo<Aim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
        PageHelper.startPage(pageNum,pageSize);
        List<Aim> list=aimMapper.info(date1,date2);
        PageInfo<Aim> pageInfo=new PageInfo<Aim>(list);
        return pageInfo;
    }
}
