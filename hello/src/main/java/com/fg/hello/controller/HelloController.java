package com.fg.hello.controller;

import com.fg.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @Value("${server.port}")
    String port;

    @RequestMapping("/describe")
    @ResponseBody
    public Object getNames() {
        return service.getNames();
    }



}
