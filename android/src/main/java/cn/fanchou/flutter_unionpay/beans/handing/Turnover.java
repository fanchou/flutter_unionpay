package cn.fanchou.flutter_unionpay.beans.handing;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class Turnover{

	@JSONField(name="total")
	private double total;

	@JSONField(name="sale")
	private double sale;

	@JSONField(name="payDetails")
	private List<PayDetailsItem> payDetails;

	@JSONField(name="couponPayDetails")
	private List<CouponPayDetailsItem> couponPayDetails;

	@JSONField(name="refound")
	private int refound;

	@JSONField(name="couponPayTotal")
	private double couponPayTotal;

	public void setTotal(double total){
		this.total = total;
	}

	public double getTotal(){
		return total;
	}

	public void setSale(double sale){
		this.sale = sale;
	}

	public double getSale(){
		return sale;
	}

	public void setPayDetails(List<PayDetailsItem> payDetails){
		this.payDetails = payDetails;
	}

	public List<PayDetailsItem> getPayDetails(){
		return payDetails;
	}

	public void setCouponPayDetails(List<CouponPayDetailsItem> couponPayDetails){
		this.couponPayDetails = couponPayDetails;
	}

	public List<CouponPayDetailsItem> getCouponPayDetails(){
		return couponPayDetails;
	}

	public void setRefound(int refound){
		this.refound = refound;
	}

	public int getRefound(){
		return refound;
	}

	public void setCouponPayTotal(double couponPayTotal){
		this.couponPayTotal = couponPayTotal;
	}

	public double getCouponPayTotal(){
		return couponPayTotal;
	}
}