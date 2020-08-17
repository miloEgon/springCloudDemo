package com.fg.redis.controller;

import com.fg.redis.pojo.User;
import com.fg.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RedisController {

    @Resource
    private RedisService service;

    public final Jedis jedis = new Jedis("122.112.216.37");

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;

    @RequestMapping("/set")
    public String setPojo(){
        User user = new User();
        user.setAge("18");
        user.setGender("男");
        user.setNickname("cherish");
        user.setPassword("123456");
        user.setUsername("admin");
        redisTemplate.opsForValue().set("user1", user);
        redisTemplate.opsForValue().set("name1", user.getNickname());
        return "存储对象";
    }

    @RequestMapping("/getPojo")
    public Object getPojo(){
        return redisTemplate.opsForValue().get("user1");
    }

    @RequestMapping("/getStr")
    public Object getStr() {
        return redisTemplate.opsForValue().get("name1");
    }

    @RequestMapping("/viewUsers")
    public Object viewUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        Map<String, Object> map = new HashMap<>();
        if (jedis.get("name") != null && jedis.get("name") != "")
            map.put("name",jedis.get("name"));
        if (jedis.lrange("site-list",0,4).size() > 0)
            map.put("site-list",jedis.lrange("site-list",0,4));
        if (jedis.smembers("site-set").size() > 0)
            map.put("site-set",jedis.smembers("site-set"));
        return map;
    }

    @RequestMapping("/addUsers")
    public String addUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        /** List & Set*/
        String result = "OK";
        List<String> names = service.getNames();
        for (String name : names) {
            jedis.lpush("site-list", name);
            jedis.sadd("site-set", name);
        }
        System.out.println(jedis.lrange("site-list",0,4));
        System.out.println(jedis.smembers("site-set"));

        /** Hash*/
        /*Map<String,String> map = new HashMap<>();
        map.put("field1","Hello");
        map.put("field2","World");
        String result = jedis.hmset("myhash", map);
        System.out.println(jedis.hget("myhash","field1")+" "+jedis.hget("myhash","field2"));*/

        /** String*/
        /*String result = jedis.set("name", "丁企瀚");
        System.out.println(jedis.get("name"));*/

        if (result.equals("OK")) return "保存成功";
        return "保存失败";
    }

    @RequestMapping("/delUsers")
    public String delUsers() {
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        boolean flag = true;
        String[] array = {"name","site-list","myhash"};
        for (int i = 0; i < 3; i++) {
            if (jedis.del(array[i]) == 0) {
                flag = false;
                break;
            }
        }
        if (flag) return "删除成功";
        return "删除失败";
    }


}
