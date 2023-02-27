package ru.example.springexam.bean.config;

import com.example.mylibrary.service.ReplaceableServiceFinal;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "com.example.mylibrary.service",
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ReplaceableServiceFinal.class)})
@ConditionalOnProperty(
    value="config.enable",
    havingValue = "scan"
)
public class ScanConfig {

}
