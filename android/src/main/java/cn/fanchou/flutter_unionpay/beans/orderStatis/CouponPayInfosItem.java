package cn.fanchou.flutter_unionpay.beans.orderStatis;

import com.alibaba.fastjson.annotation.JSONField;

public class CouponPayInfosItem{

	@JSONField(name="giftMoney")
	private double giftMoney;

	@JSONField(name="money")
	private double money;

	@JSONField(name="percentage")
	private double percentage;

	@JSONField(name="name")
	private String name;

	@JSONField(name="id")
	private int id;

	public void setGiftMoney(double giftMoney){
		this.giftMoney = giftMoney;
	}

	public double getGiftMoney(){
		return giftMoney;
	}

	public void setMoney(int money){
		this.money = money;
	}

	public double getMoney(){
		return money;
	}

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public double getPercentage(){
		return percentage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
