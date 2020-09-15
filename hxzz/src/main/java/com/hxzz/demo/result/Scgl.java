package com.hxzz.demo.result;

import com.hxzz.demo.service.ScglDCService;
import com.hxzz.demo.service.ScglDDService;
import com.hxzz.demo.service.ScglXCService;
import com.hxzz.demo.service.ScglXDService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class Scgl {
    @Autowired
    ScglDCService scglDCService;
    @Autowired
    ScglDDService scglDDService;
    @Autowired
    ScglXCService scglXCService;
    @Autowired
    ScglXDService scglXDService;

    private  Integer targetCapacitySum;

    private Float actualCapacitySum;

    private Float targetEfficiencySum;

    private Float actualEfficiencySum;

    private Float workingHoursSum;

    private Float theoreticalCapacitySum;

    public  Integer targetCapacitySum(){
        targetCapacitySum=scglDCService.showIN().getTargetCapacity()+scglDDService.showIN().getTargetCapacity()+scglXCService.showIN().getTargetCapacity()+scglXDService.showIN().getTargetCapacity();
       log.println(targetCapacitySum);
       return targetCapacitySum;
    }
    public Float actualCapacitySum(){
        actualCapacitySum=scglDCService.showIN().getActualCapacity()+scglDDService.showIN().getActualCapacity()+scglXCService.showIN().getActualCapacity()+scglXDService.showIN().getActualCapacity();
        return  actualCapacitySum;

    }
    public Float targetEfficiencySum(){
        targetEfficiencySum=scglDCService.showIN().getTargetEfficiency()+scglDDService.showIN().getTargetEfficiency()+scglXCService.showIN().getTargetEfficiency()+scglXDService.showIN().getTargetEfficiency();
        return targetEfficiencySum;
    }
public Float actualEfficiencySum(){
    actualEfficiencySum=scglDCService.showIN().getActualEfficiency()+scglDDService.showIN().getActualEfficiency()+scglXCService.showIN().getActualEfficiency()+scglXDService.showIN().getActualEfficiency();
        return actualEfficiencySum;
}
public Float workingHoursSum(){
    workingHoursSum=scglDCService.showIN().getWorkingHours()+scglDDService.showIN().getWorkingHours()+scglXCService.showIN().getWorkingHours()+scglXDService.showIN().getWorkingHours();
    return workingHoursSum;
}
public Float theoreticalCapacitySum(){
    theoreticalCapacitySum=scglDCService.showIN().getTheoreticalCapacity()+scglDDService.showIN().getTheoreticalCapacity()+scglXCService.showIN().getTheoreticalCapacity()+scglXDService.showIN().getTheoreticalCapacity();
    return theoreticalCapacitySum;

}

}
