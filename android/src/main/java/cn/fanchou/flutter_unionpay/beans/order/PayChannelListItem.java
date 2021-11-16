package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class PayChannelListItem{

	@JSONField(name="xfBalance")
	private String xfBalance;

	@JSONField(name="czBalance")
	private String czBalance;

	@JSONField(name="payMoney")
	private String payMoney;

	@JSONField(name="subOrderId")
	private String subOrderId;

	@JSONField(name="createTime")
	private String createTime;

	@JSONField(name="xfEntityCardNo")
	private String xfEntityCardNo;

	@JSONField(name="xfEntityCardBalance")
	private String xfEntityCardBalance;

	@JSONField(name="mobile")
	private String mobile;

	@JSONField(name="channelType")
	private String channelType;

	public void setXfBalance(String xfBalance){
		this.xfBalance = xfBalance;
	}

	public String getXfBalance(){
		return xfBalance;
	}

	public void setCzBalance(String czBalance){
		this.czBalance = czBalance;
	}

	public String getCzBalance(){
		return czBalance;
	}

	public void setPayMoney(String payMoney){
		this.payMoney = payMoney;
	}

	public String getPayMoney(){
		return payMoney;
	}

	public void setSubOrderId(String subOrderId){
		this.subOrderId = subOrderId;
	}

	public String getSubOrderId(){
		return subOrderId;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setXfEntityCardNo(String xfEntityCardNo){
		this.xfEntityCardNo = xfEntityCardNo;
	}

	public String getXfEntityCardNo(){
		return xfEntityCardNo;
	}

	public void setXfEntityCardBalance(String xfEntityCardBalance){
		this.xfEntityCardBalance = xfEntityCardBalance;
	}

	public String getXfEntityCardBalance(){
		return xfEntityCardBalance;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setChannelType(String channelType){
		this.channelType = channelType;
	}

	public String getChannelType(){
		return channelType;
	}
}