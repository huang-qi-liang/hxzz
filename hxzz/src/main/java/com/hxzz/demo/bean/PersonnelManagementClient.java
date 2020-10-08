package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data

public class PersonnelManagementClient {
    private String name;

    private Integer establishment;


    private Integer actualNumber;


    private Integer availableNumber;


    private Float attendanceRate;


    private Integer shouldArrive;


    private Integer actualArrive;

    private LocalDate date;
}
