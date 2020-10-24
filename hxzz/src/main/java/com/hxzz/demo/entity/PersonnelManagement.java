package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PersonnelManagement")
public class PersonnelManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer establishment;

    @TableField("actualNumber")
    private Integer actualNumber;

    @TableField("availableNumber")
    private Integer availableNumber;

    @TableField("attendanceRate")
    private Float attendanceRate;

    @TableField("shouldArrive")
    private Integer shouldArrive;

    @TableField("actualArrive")
    private Float actualArrive;

    private LocalDate date;


}
