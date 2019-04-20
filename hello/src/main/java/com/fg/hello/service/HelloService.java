package com.fg.hello.service;

import com.fg.hello.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloMapper mapper;

    public List<String> getNames() {
        return mapper.getNames();
    }

}
