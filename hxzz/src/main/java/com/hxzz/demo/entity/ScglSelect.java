package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ScglSelect {

    private Integer targetCapacity;


    private Float actualCapacity;


    private Float targetEfficiency;


    private Float actualEfficiency;


    private Float workingHours;


    private Float theoreticalCapacity;
}
