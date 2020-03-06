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
	public HashMap<String, Object> insetGoods(@RequestParam HashMap<String, String> map, HttpServletRequest req,
			HttpServletResponse response) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		// 商品上传
		Goods goods = new Goods();
		goods.setImg(map.get("img"));
		goods.setName(map.get("name"));
		goods.setNote(map.get("note"));
		goods.setStock(Integer.parseInt(map.get("stock")));
		goods.setPrice(Double.parseDouble(map.get("price")));
		goods.setUserId(map.get("userId"));
		goods.setType(map.get("type"));
		if (goodsService.insert(goods) == 1) {
			map1.put("msg", "上传成功");
			map1.put("code", 1);
		} else {
			map1.put("msg", "上传失败");
			map1.put("code", 0);
		}

		return map1;
	}

//分页查询所有
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.POST)
	public HashMap<String, Object> SelectGoods(@RequestParam HashMap<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println(map.get("page"));
		System.out.println(map.get("pageSize"));
		map1.put("data",
				goodsService.selectAll(Integer.parseInt(map.get("page")) - 1, Integer.parseInt(map.get("pageSize"))));
		map1.put("msg", 200);
		return map1;
	}

	// 分页查询用户的所有商品
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/selectAllUser", method = RequestMethod.POST)
	public HashMap<String, Object> SelectGoodsUser(@RequestParam HashMap<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println(map.get("page"));
		System.out.println(map.get("pageSize"));
		System.out.println(map.get("userId"));
		map1.put("data", goodsService.selectAllUser(Integer.parseInt(map.get("page")) - 1,
				Integer.parseInt(map.get("pageSize")), map.get("userId")));
		map1.put("msg", 200);
		return map1;
	}

	// 上下架商品
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/upDown", method = RequestMethod.POST)
	public HashMap<String, Object> UpAndDown(@RequestParam HashMap<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println(map.get("id"));
		Integer a = Integer.parseInt(map.get("id"));
		System.out.println("!!!" + goodsService.stage(a) + "!!!!");
		if (goodsService.stage(a).equals("1")) {
//			Integer.parseInt(goodsService.stage(a)) == 1 int类型可以直接用==比较 字符串 数值用 equals
			System.out.println(2);
			if (goodsService.downGoods(Integer.parseInt(map.get("id"))) == 1) {
				map1.put("msg", "商品下架成功!");
				map1.put("code", 1);
			} else {
				map1.put("msg", "商品下架失败!");
				map1.put("code", 0);
			}

		} else {
			System.out.println(3);
			if (goodsService.upGoods(Integer.parseInt(map.get("id"))) == 1) {
				map1.put("msg", "商品上架成功!");
				map1.put("code", 1);
			} else {
				map1.put("msg", "商品上架失败!");
				map1.put("code", 0);
			}
		}
		return map1;
	}

	// 删除商品
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
	public HashMap<String, Object> delete(@RequestParam HashMap<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println(map.get("id"));
		if (goodsService.delete(Integer.parseInt(map.get("id"))) == 1) {
			map1.put("msg", "删除成功!");
			map1.put("code", 1);
		} else {
			map1.put("msg", "删除失败!");
			map1.put("code", 0);
		}
		return map1;
	}

	// 修改商品
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/upGoods", method = RequestMethod.POST)
	public HashMap<String, Object> updataGoods(@RequestParam HashMap<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		System.out.println(map.get("id"));
		System.out.println(map.get("name"));
		System.out.println(map.get("price"));
		System.out.println(map.get("stock"));
		System.out.println(map.get("img"));
		System.out.println(map.get("note"));
		System.out.println(map.get("type"));
		Goods goods = new Goods();
		goods.setImg(map.get("img"));
		goods.setName(map.get("name"));
		goods.setNote(map.get("note"));
		goods.setStock(Integer.parseInt(map.get("stock")));
		goods.setPrice(Double.parseDouble(map.get("price")));
		goods.setType(map.get("type"));

		if (goodsService.updateByPrimaryKeySelective(goods) == 1) {
			map1.put("msg", "更新成功!");
			map1.put("code", 1);
		} else {
			map1.put("msg", "更新失败!");
			map1.put("code", 0);
		}
		return map1;
	}
}
