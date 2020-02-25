package com.ssm.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.User;
import com.ssm.service.UserService;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午1:05:38
 * @ClassName UserController
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/inset", method = RequestMethod.POST)
	public HashMap select(@RequestParam HashMap<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/* 能够获取map里的数据 */
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("userId"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("userName"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("nickName"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("sex"));
		User user = new User();
		user.setNickName(map.get("nickName"));
		user.setUserId(map.get("userId"));
		user.setSex(Integer.parseInt(map.get("sex")));
		user.setUserName(map.get("userName"));
		HashMap<String, Object> map1 = new HashMap<String, Object>();

		map1.put("data", user);
		map1.put("data2", userService.selectAll());
		return map1;
	}
}
