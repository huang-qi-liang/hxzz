package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.ScglShow;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Scgl;
import com.hxzz.demo.entity.Scgl;
import com.hxzz.demo.mapper.ScglMapper;
import com.hxzz.demo.service.ScglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-10-12
 */
@Service
public class ScglServiceImpl extends ServiceImpl<ScglMapper, Scgl> implements ScglService {
    @Autowired
    ScglMapper scglMapper;

    @Override
    public List<Scgl> show() {
        return scglMapper.show();
    }

    public List<ScglShow> showClient() {
        return scglMapper.showClient();
    }

    public ScglShow showSum() {
        return scglMapper.showSum();
    }

    public List<Scgl> info(LocalDate date1, LocalDate date2) {
        return scglMapper.info(date1, date2);
    }

    public List<ScglShow> infoClient(LocalDate date1, LocalDate date2) {
        return scglMapper.infoClient(date1, date2);
    }

    public ScglShow infoSum(LocalDate date1, LocalDate date2) {
        return scglMapper.infoSum(date1, date2);
    }

    public void add(String name, Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
                    Float beat, LocalDate date) {
        scglMapper.add(name, targetCapacity, actualCapacity, targetEfficiency,
                workingHours, beat, date);
    }

    public void del(Integer id) {
        scglMapper.del(id);
    }

    public void change(Integer id, String name, Integer targetCapacity, Float actualCapacity, Float targetEfficiency,
                       Float workingHours,
                       Float beat, LocalDate date) {
        scglMapper.change(id, name, targetCapacity, actualCapacity,
                targetEfficiency, workingHours, beat, date);
    }

    public PageInfo<Scgl> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<Scgl> list = scglMapper.info(date1, date2);
        PageInfo<Scgl> pageInfo = new PageInfo<Scgl>(list);
        return pageInfo;
    }

}
