package com.hxzz.demo.result;

import com.hxzz.demo.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class EnergyPackage {
    @Autowired
    EnergyService energyService;
}
