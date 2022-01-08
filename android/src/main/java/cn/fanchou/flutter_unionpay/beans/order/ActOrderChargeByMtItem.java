package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class ActOrderChargeByMtItem{

	@JSONField(name="comment")
	private String comment;

	@JSONField(name="feeTypeDesc")
	private String feeTypeDesc;

	@JSONField(name="moneyCent")
	private int moneyCent;

	@JSONField(name="feeTypeId")
	private int feeTypeId;

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setFeeTypeDesc(String feeTypeDesc){
		this.feeTypeDesc = feeTypeDesc;
	}

	public String getFeeTypeDesc(){
		return feeTypeDesc;
	}

	public void setMoneyCent(int moneyCent){
		this.moneyCent = moneyCent;
	}

	public int getMoneyCent(){
		return moneyCent;
	}

	public void setFeeTypeId(int feeTypeId){
		this.feeTypeId = feeTypeId;
	}

	public int getFeeTypeId(){
		return feeTypeId;
	}
}
