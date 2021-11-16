package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class CardListItem{

	@JSONField(name="tradeMoney")
	private double tradeMoney;

	@JSONField(name="classifyType")
	private String classifyType;

	public void setTradeMoney(double tradeMoney){
		this.tradeMoney = tradeMoney;
	}

	public double getTradeMoney(){
		return tradeMoney;
	}

	public void setClassifyType(String classifyType){
		this.classifyType = classifyType;
	}

	public String getClassifyType(){
		return classifyType;
	}
}
