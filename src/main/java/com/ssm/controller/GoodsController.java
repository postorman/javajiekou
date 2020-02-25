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

import com.ssm.pojo.Goods;
import com.ssm.service.GoodsService;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月24日 下午6:33:59
 * @ClassName GoodsController
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/insetGoods", method = RequestMethod.POST)
	public HashMap<String, Object> insetGoods(@RequestParam HashMap<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("name"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("price"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("stock"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("img"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + map.get("note"));
		Goods goods = new Goods();
		goods.setImg(map.get("img"));
		goods.setName(map.get("name"));
		goods.setNote(map.get("note"));
		goods.setStock(Integer.parseInt(map.get("stock")));
		goods.setPrice(Integer.parseInt(map.get("price")));
		return map1;
	}

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public HashMap<String, Object> SelectGoods() {
		HashMap<String, Object> map1 = new HashMap<String, Object>();

		map1.put("data", goodsService.selectAll());
		map1.put("msg", 200);
		return map1;
	}
}
