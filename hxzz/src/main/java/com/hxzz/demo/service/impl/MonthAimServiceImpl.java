package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.MonthAim;
import com.hxzz.demo.entity.MonthAim;
import com.hxzz.demo.mapper.AimMapper;
import com.hxzz.demo.mapper.MonthAimMapper;
import com.hxzz.demo.service.MonthAimService;
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
 * @since 2020-11-12
 */
@Service
public class MonthAimServiceImpl extends ServiceImpl<MonthAimMapper, MonthAim> implements MonthAimService {
@Autowired
    MonthAimMapper monthAimMapper;
    @Override
    public MonthAim show() {
        return monthAimMapper.show();
    }

    public List<MonthAim> info(LocalDate date1, LocalDate date2) {
        return monthAimMapper.info(date1, date2);
    }

    public MonthAim showClient(){
        return monthAimMapper.showClient();
    }

    public List<MonthAim> infoClient(LocalDate date1, LocalDate date2){
        return monthAimMapper.infoClient(date1, date2);
    }
    public MonthAim aimInfo(LocalDate date1, LocalDate date2){return monthAimMapper.aimInfo(date1, date2);}
    public void add(Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date) {
        monthAimMapper.add(security, lzcsj, quality, equipment, date);
    }

    public void del(Integer id) {
        monthAimMapper.del(id);
    }

    public void change(Integer id, Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date) {
        monthAimMapper.change(id, security, lzcsj, quality, equipment, date);
    }

    public PageInfo<MonthAim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<MonthAim> list = monthAimMapper.info(date1, date2);
        PageInfo<MonthAim> pageInfo = new PageInfo<MonthAim>(list);
        return pageInfo;
    }
}
