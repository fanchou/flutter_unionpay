package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class ExtrasItem{

	@JSONField(name="reduce_fee")
	private double reduceFee;

	@JSONField(name="poi_charge")
	private double poiCharge;

	@JSONField(name="remark")
	private String remark;

	@JSONField(name="type")
	private int type;

	@JSONField(name="mt_charge")
	private int mtCharge;

	public void setReduceFee(double reduceFee){
		this.reduceFee = reduceFee;
	}

	public double getReduceFee(){
		return reduceFee;
	}

	public void setPoiCharge(double poiCharge){
		this.poiCharge = poiCharge;
	}

	public double getPoiCharge(){
		return poiCharge;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return remark;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setMtCharge(int mtCharge){
		this.mtCharge = mtCharge;
	}

	public int getMtCharge(){
		return mtCharge;
	}
}