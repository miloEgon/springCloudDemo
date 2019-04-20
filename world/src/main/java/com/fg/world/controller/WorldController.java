package com.fg.world.controller;

import com.fg.world.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorldController {

    @Autowired
    WorldService service;

    @Value("${server.port}")
    String port;

    @RequestMapping("/describe")
    public String describe(String name) {
        List<String> names = service.getNames();
        return "Hello "+name+" ! This is port "+this.port+". We have "+names.size()+" members and they are "+names.toString();
    }


}
