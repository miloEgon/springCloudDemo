package com.fg.redis.controller;

import com.fg.redis.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
public class RedisController {

    @Resource
    private RedisService service;

    public final Jedis jedis = new Jedis("122.112.216.37");

    @RequestMapping("/viewUsers")
    public Set<String> viewUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        //获取存储的数据并输出
        System.out.println( "redis存储的用户有: "+ jedis.smembers("site-list") );
        return jedis.smembers("site-list");
    }

    @RequestMapping("/addUsers")
    public String addUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        List<String> names = service.getNames();
        for (String name : names) {
            /*jedis.lpush("site-list", name);*/
            jedis.sadd("site-list",name);
        }
        return "保存成功";
    }

    @RequestMapping("/delUsers")
    public String delUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        Long del = jedis.del("site-list");
        if (del > 0) return "删除成功";
        else return "删除失败";
    }


}
