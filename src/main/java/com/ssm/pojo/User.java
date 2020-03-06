package com.ssm.pojo;

/**
 *
 * @版权 : Copyright (c) 2017-2018 个人
 * @author: xujunhao(一般是写姓名的拼音)
 * @E-mail: 982488409@qq.com
 * @版本: 1.0
 * @创建日期: 2020年2月21日 下午12:55:00
 * @ClassName User
 * @类描述-Description: TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */
public class User {
	private String userId;

	private String userName;

	private String nickName;

	private String password;

	private String img;

	private String address;

	private double money;

	private String phone;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public double getMoney() {
		return money;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

}
