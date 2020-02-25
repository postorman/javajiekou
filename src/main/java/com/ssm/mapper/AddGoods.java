package com.ssm.mapper;

import java.util.List;

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
	public void addGoods(Upload upload);

	List<Goods> selectAll();
}
