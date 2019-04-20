package com.fg.hello.controller;

import com.fg.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @Value("${server.port}")
    String port;

    @RequestMapping("/getNames")
    public String getNames(String name) {
        List<String> names = service.getNames();
        return "Hello "+name+" !\n This is port "+this.port+".\n We have "+names.size()+" members and they are "+names.toString();
    }

}
