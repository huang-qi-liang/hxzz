package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.DateAim;
import com.hxzz.demo.entity.DateAim;
import com.hxzz.demo.mapper.DateAimMapper;
import com.hxzz.demo.mapper.MonthAimMapper;
import com.hxzz.demo.service.DateAimService;
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
public class DateAimServiceImpl extends ServiceImpl<DateAimMapper, DateAim> implements DateAimService {
@Autowired
    DateAimMapper dateAimMapper;

    @Override
    public DateAim show() {
        return dateAimMapper.show();
    }

    public List<DateAim> info(LocalDate date1, LocalDate date2) {
        return dateAimMapper.info(date1, date2);
    }

    public DateAim showClient(){
        return dateAimMapper.showClient();
    }

    public DateAim infoClient(LocalDate date1, LocalDate date2){
        return dateAimMapper.infoClient(date1, date2);
    }
    public void add( Integer lzcsj,  LocalDate date) {
        dateAimMapper.add( lzcsj,  date);
    }

    public void del(Integer id) {
        dateAimMapper.del(id);
    }

    public void change(Integer id,  Integer lzcsj,  LocalDate date) {
        dateAimMapper.change(id,  lzcsj, date);
    }

    public PageInfo<DateAim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<DateAim> list = dateAimMapper.info(date1, date2);
        PageInfo<DateAim> pageInfo = new PageInfo<DateAim>(list);
        return pageInfo;
    }
}
