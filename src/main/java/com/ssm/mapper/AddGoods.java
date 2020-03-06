package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.pojo.Goods;
import com.ssm.pojo.Upload;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午5:13:21
 * @ClassName AddGoods
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
public interface AddGoods {
	void addGoods(Upload upload);

	// 添加商品
	int addGood(Goods goods);

	// 根据主键查商品
	Goods selectByPrimaryKey(Integer name);

	// 分页查询所有
	List<Goods> selectAllUser(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
			@Param("userId") String userId);

	// 分页查询所有
	List<Goods> selectAll(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

	// 上下架商品
	int upGoods(Integer id);

	int downGoods(Integer id);

	// 获取他的stage字段
	String stage(Integer id);

	// 更新商品
	int updateByPrimaryKeySelective(Goods record);

	// 删除
	int deleteByKey(Integer id);

}
