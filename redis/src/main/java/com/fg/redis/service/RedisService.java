package com.fg.redis.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("helloServer")
public interface RedisService {

    @RequestMapping("/describe")
    List<String> getNames();

}
