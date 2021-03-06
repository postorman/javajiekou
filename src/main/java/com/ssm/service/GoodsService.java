package com.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.Goods;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月24日 下午6:28:07
 * @ClassName GoodsService
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
public interface GoodsService {
	public int insert(Goods goods);

	public Goods selectById(Integer a);

	public List<Goods> selectAllUser(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
			@Param("userId") String userId);

	public List<Goods> selectAll(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

	public int upGoods(Integer id);

	public int downGoods(Integer id);

	public String stage(Integer id);

	public int delete(Integer id);

	public int updateByPrimaryKeySelective(Goods record);
}
