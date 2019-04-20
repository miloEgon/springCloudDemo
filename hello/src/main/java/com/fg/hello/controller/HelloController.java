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
    public List<String> getNames() {
        return service.getNames();
    }



}
