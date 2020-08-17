package com.fg.hello.service;

import com.fg.hello.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloMapper mapper;

    public Object getNames() {
        Object names = mapper.getNames();
        System.out.println(names);
        return names;
    }

}
