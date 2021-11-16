package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class RefundPayChannelListItem{

	@JSONField(name="refundTime")
	private String refundTime;

	@JSONField(name="xfEntityCardNo")
	private String xfEntityCardNo;

	@JSONField(name="mobile")
	private String mobile;

	@JSONField(name="payRefundId")
	private String payRefundId;

	@JSONField(name="channelType")
	private String channelType;

	@JSONField(name="refundMoney")
	private String refundMoney;

	public void setRefundTime(String refundTime){
		this.refundTime = refundTime;
	}

	public String getRefundTime(){
		return refundTime;
	}

	public void setXfEntityCardNo(String xfEntityCardNo){
		this.xfEntityCardNo = xfEntityCardNo;
	}

	public String getXfEntityCardNo(){
		return xfEntityCardNo;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setPayRefundId(String payRefundId){
		this.payRefundId = payRefundId;
	}

	public String getPayRefundId(){
		return payRefundId;
	}

	public void setChannelType(String channelType){
		this.channelType = channelType;
	}

	public String getChannelType(){
		return channelType;
	}

	public void setRefundMoney(String refundMoney){
		this.refundMoney = refundMoney;
	}

	public String getRefundMoney(){
		return refundMoney;
	}
}
