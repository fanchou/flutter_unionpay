package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class CouponPayInfosItem{

	@JSONField(name="giftMoney")
	private String giftMoney;

	@JSONField(name="money")
	private double money;

	@JSONField(name="name")
	private String name;

	@JSONField(name="id")
	private int id;

	public String getGiftMoney(){
		return giftMoney;
	}

	public double getMoney(){
		return money;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}
