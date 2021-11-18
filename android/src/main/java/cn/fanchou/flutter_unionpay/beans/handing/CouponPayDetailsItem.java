package cn.fanchou.flutter_unionpay.beans.handing;

import com.alibaba.fastjson.annotation.JSONField;

public class CouponPayDetailsItem{

	@JSONField(name="income")
	private double income;

	@JSONField(name="payChannelName")
	private String payChannelName;

	@JSONField(name="payChannelCode")
	private String payChannelCode;

	@JSONField(name="couponActiveId")
	private int couponActiveId;

	@JSONField(name="refund")
	private double refund;

	public void setIncome(double income){
		this.income = income;
	}

	public double getIncome(){
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

	public void setCouponActiveId(int couponActiveId){
		this.couponActiveId = couponActiveId;
	}

	public int getCouponActiveId(){
		return couponActiveId;
	}

	public void setRefund(double refund){
		this.refund = refund;
	}

	public double getRefund(){
		return refund;
	}
}
