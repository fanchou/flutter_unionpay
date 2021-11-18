package cn.fanchou.flutter_unionpay.beans.handing;

import com.alibaba.fastjson.annotation.JSONField;

public class HandingInfo{

	@JSONField(name="handoverStartTime")
	private String handoverStartTime;

	@JSONField(name="handoverEndTime")
	private String handoverEndTime;

	@JSONField(name="deposit")
	private Deposit deposit;

	@JSONField(name="orders")
	private Orders orders;

	@JSONField(name="couponPreferential")
	private String couponPreferential;

	@JSONField(name="operatorId")
	private int operatorId;

	@JSONField(name="operatorName")
	private String operatorName;

	@JSONField(name="turnover")
	private Turnover turnover;

	@JSONField(name="cash")
	private Cash cash;

	public void setHandoverStartTime(String handoverStartTime){
		this.handoverStartTime = handoverStartTime;
	}

	public String getHandoverStartTime(){
		return handoverStartTime;
	}

	public void setHandoverEndTime(String handoverEndTime){
		this.handoverEndTime = handoverEndTime;
	}

	public String getHandoverEndTime(){
		return handoverEndTime;
	}

	public void setDeposit(Deposit deposit){
		this.deposit = deposit;
	}

	public Deposit getDeposit(){
		return deposit;
	}

	public void setOrders(Orders orders){
		this.orders = orders;
	}

	public Orders getOrders(){
		return orders;
	}

	public void setCouponPreferential(String couponPreferential){
		this.couponPreferential = couponPreferential;
	}

	public String getCouponPreferential(){
		return couponPreferential;
	}

	public void setOperatorId(int operatorId){
		this.operatorId = operatorId;
	}

	public int getOperatorId(){
		return operatorId;
	}

	public void setOperatorName(String operatorName){
		this.operatorName = operatorName;
	}

	public String getOperatorName(){
		return operatorName;
	}

	public void setTurnover(Turnover turnover){
		this.turnover = turnover;
	}

	public Turnover getTurnover(){
		return turnover;
	}

	public void setCash(Cash cash){
		this.cash = cash;
	}

	public Cash getCash(){
		return cash;
	}
}