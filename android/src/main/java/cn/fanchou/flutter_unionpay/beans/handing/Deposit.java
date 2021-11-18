package cn.fanchou.flutter_unionpay.beans.handing;

import com.alibaba.fastjson.annotation.JSONField;

public class Deposit{

	@JSONField(name="total")
	private int total;

	@JSONField(name="aliPay")
	private int aliPay;

	@JSONField(name="wxPay")
	private int wxPay;

	@JSONField(name="cash")
	private int cash;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setAliPay(int aliPay){
		this.aliPay = aliPay;
	}

	public int getAliPay(){
		return aliPay;
	}

	public void setWxPay(int wxPay){
		this.wxPay = wxPay;
	}

	public int getWxPay(){
		return wxPay;
	}

	public void setCash(int cash){
		this.cash = cash;
	}

	public int getCash(){
		return cash;
	}
}