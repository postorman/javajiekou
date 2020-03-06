package com.ssm.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.AddGoods;
import com.ssm.pojo.Goods;
import com.ssm.service.GoodsService;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月24日 下午6:29:32
 * @ClassName GoodsServiceImpl
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private AddGoods adGoods;

	@Override
	public List<Goods> selectAllUser(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
			@Param("userId") String userId) {
		// TODO Auto-generated method stub
		return adGoods.selectAllUser(page, pageSize, userId);
	}

	@Override
	public int insert(Goods goods) {
		return adGoods.addGood(goods);
	}

	@Override
	public int upGoods(Integer id) {
		// TODO Auto-generated method stub

		return adGoods.upGoods(id);
	}

	@Override
	public int downGoods(Integer id) {
		// TODO Auto-generated method stub
		return adGoods.downGoods(id);
	}

	@Override
	public Goods selectById(Integer a) {
		// TODO Auto-generated method stub
		return adGoods.selectByPrimaryKey(a);
	}

	@Override
	public String stage(Integer id) {
		// TODO Auto-generated method stub
		return adGoods.stage(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return adGoods.deleteByKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return adGoods.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Goods> selectAll(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return adGoods.selectAll(page, pageSize);
	}
}
