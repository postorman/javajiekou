package com.ssm.pojo;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月24日 下午6:00:41
 * @ClassName Goods
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
public class Goods {
	private String name;
	private Integer price;
	private Integer stock;
	private String img;
	private String note;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public String getNote() {
		return note;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
