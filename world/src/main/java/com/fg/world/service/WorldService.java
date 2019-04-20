package com.fg.world.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("helloServer")
public interface WorldService {

    @RequestMapping("/getNames")
    List<String> getNames();

}
