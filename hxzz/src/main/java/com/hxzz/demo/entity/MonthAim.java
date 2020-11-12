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
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("monthAim")
public class MonthAim implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer security;

    private Integer lzcsj;

    private Float quality;

    private Float equipment;

    private LocalDate date;


}
