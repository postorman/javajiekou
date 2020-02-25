package com.ssm.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午2:50:03
 * @ClassName Upload
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
public class Upload {
	private Integer id;
	private String bookname;
	private Double price;
	private Integer stock;
	private String img;
	private MultipartFile file;

	public String getBookname() {
		return bookname;
	}

	public MultipartFile getFile() {
		return file;
	}

	public Integer getId() {
		return id;
	}

	public String getImg() {
		return img;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
