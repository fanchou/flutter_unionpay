package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class CouponPayInfosItem{

	@JSONField(name="giftMoney")
	private double giftMoney;

	@JSONField(name="money")
	private double money;

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

  public void setMoney(double money){
    this.money = money;
  }

	public double getMoney(){
		return money;
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
