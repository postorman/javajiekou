package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.AddGoods;
import com.ssm.pojo.Upload;
import com.ssm.service.UploadService;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午5:16:16
 * @ClassName UploadServiceImpl
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private AddGoods adGoods;

	@Override
	public void addGoods(Upload upload) {
		// TODO Auto-generated method stub
		adGoods.addGoods(upload);
	}

}
