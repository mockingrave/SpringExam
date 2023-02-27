package ru.example.springexam.bean.service;

import com.example.mylibrary.service.ReplaceableService;
import com.example.mylibrary.service.SecondService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ReplaceableServiceImpl extends ReplaceableService {

    private final SecondService secondService;

    public ReplaceableServiceImpl(SecondService secondService) {
        super(secondService);
        this.secondService = secondService;
    }

    public String questionableMethod() {
        return secondService.connectByParam(goodMethod());
    }

    private String goodMethod() {
        return "Good connection";
    }

}
