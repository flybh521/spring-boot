package com.example.demo.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.NeoP;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
public class HelloW {
	@Autowired
	private NeoP aa;
	@Autowired
	private UserService userservice;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	@RequestMapping("/hello")
	@Cacheable(value="userInfo")
    public User index() {
		System.out.println("11111");
		User use=new User();
		use.setAge(10);

		System.out.println(aa.getDescription());
		User userById = userservice.getUserById();
        return use;
    }
	@RequestMapping("/index")

    public String index1(HttpServletRequest re) {
		System.out.println("11111");
		User use=new User();
		use.setAge(10);
		UUID attribute =(UUID) re.getSession().getAttribute("uid");
		System.out.println(attribute.getLeastSignificantBits());
		//User userById = userservice.getUserById();
        return String.valueOf(attribute.getLeastSignificantBits());
    }
	@RequestMapping("/hello1")
    public User index12() {
		System.out.println("11111");
		User use=new User();
		use.setAge(10);
		redisTemplate.delete("userInfo");
		
		System.out.println(redisTemplate.hasKey("userInfo"));
		System.out.println(aa.getDescription());
		User userById = userservice.getUserById();
        return use;
    }
	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
