package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class SgmwSelect {
    private  String name;
    private Integer safe;

    private Integer production;

    private Integer lzc;

    private Float quality;

    private Integer personnel;


    private Float energyConsumption;

    private Float equipment;
}
