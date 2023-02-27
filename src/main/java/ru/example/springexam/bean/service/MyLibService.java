package ru.example.springexam.bean.service;

import com.example.mylibrary.service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyLibService {

    private final FirstService firstService;

    public String useLibPrimary(){
        return firstService.callQuestionableMethod();
    }

    public String useLib(){
        return firstService.callQuestionableMethodFinal();
    }

}
