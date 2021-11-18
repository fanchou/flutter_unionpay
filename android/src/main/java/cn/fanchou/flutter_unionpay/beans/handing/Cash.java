package cn.fanchou.flutter_unionpay.beans.handing;

import com.alibaba.fastjson.annotation.JSONField;

public class Cash{

	@JSONField(name="income")
	private double income;

	@JSONField(name="total")
	private double total;

	@JSONField(name="realCash")
	private double realCash;

	@JSONField(name="change")
	private double change;

	@JSONField(name="refund")
	private int refund;

	public void setIncome(double income){
		this.income = income;
	}

	public double getIncome(){
		return income;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public double getTotal(){
		return total;
	}

	public void setRealCash(double realCash){
		this.realCash = realCash;
	}

	public double getRealCash(){
		return realCash;
	}

	public void setChange(double change){
		this.change = change;
	}

	public double getChange(){
		return change;
	}

	public void setRefund(int refund){
		this.refund = refund;
	}

	public int getRefund(){
		return refund;
	}
}
