package com.hxzz.demo.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LzcsjShow {
    private String name;
    private Integer waitingToBeLoaded;


    private Integer loopToCrossTheLine;


    private Integer bhCirculation;


    private Integer actualCirculation;

    private Integer total;
    private LocalDate date;
}
