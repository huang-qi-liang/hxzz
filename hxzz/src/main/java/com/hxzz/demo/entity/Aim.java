package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
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
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Aim")
public class Aim implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private int security;
    private Integer lzcsj;

    private Float quality;
    private Float equipment;
    private LocalDate date;


}
