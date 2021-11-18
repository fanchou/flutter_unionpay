package cn.fanchou.flutter_unionpay.beans.handing;

import com.alibaba.fastjson.annotation.JSONField;

public class PayDetailsItem{

	@JSONField(name="income")
	private int income;

	@JSONField(name="payChannelName")
	private String payChannelName;

	@JSONField(name="payChannelCode")
	private String payChannelCode;

	@JSONField(name="refund")
	private int refund;

	@JSONField(name="couponActiveId")
	private String couponActiveId;

	public void setIncome(int income){
		this.income = income;
	}

	public int getIncome(){
		return income;
	}

	public void setPayChannelName(String payChannelName){
		this.payChannelName = payChannelName;
	}

	public String getPayChannelName(){
		return payChannelName;
	}

	public void setPayChannelCode(String payChannelCode){
		this.payChannelCode = payChannelCode;
	}

	public String getPayChannelCode(){
		return payChannelCode;
	}

	public void setRefund(int refund){
		this.refund = refund;
	}

	public int getRefund(){
		return refund;
	}

	public void setCouponActiveId(String couponActiveId){
		this.couponActiveId = couponActiveId;
	}

	public String getCouponActiveId(){
		return couponActiveId;
	}
}