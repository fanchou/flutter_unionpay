package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderSelfTakeInfo{

	@JSONField(name="selfTakeTimeInterval")
	private String selfTakeTimeInterval;

	@JSONField(name="receiverMobileBackup")
	private String receiverMobileBackup;

	@JSONField(name="customerMobileBackup")
	private String customerMobileBackup;

	@JSONField(name="remark")
	private String remark;

	@JSONField(name="selfTakeCode")
	private String selfTakeCode;

	@JSONField(name="selfTakeDate")
	private String selfTakeDate;

	@JSONField(name="isSpeed")
	private boolean isSpeed;

	@JSONField(name="customerMobile")
	private String customerMobile;

	@JSONField(name="customerName")
	private String customerName;

	public void setSelfTakeTimeInterval(String selfTakeTimeInterval){
		this.selfTakeTimeInterval = selfTakeTimeInterval;
	}

	public String getSelfTakeTimeInterval(){
		return selfTakeTimeInterval;
	}

	public void setReceiverMobileBackup(String receiverMobileBackup){
		this.receiverMobileBackup = receiverMobileBackup;
	}

	public String getReceiverMobileBackup(){
		return receiverMobileBackup;
	}

	public void setCustomerMobileBackup(String customerMobileBackup){
		this.customerMobileBackup = customerMobileBackup;
	}

	public String getCustomerMobileBackup(){
		return customerMobileBackup;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return remark;
	}

	public void setSelfTakeCode(String selfTakeCode){
		this.selfTakeCode = selfTakeCode;
	}

	public String getSelfTakeCode(){
		return selfTakeCode;
	}

	public void setSelfTakeDate(String selfTakeDate){
		this.selfTakeDate = selfTakeDate;
	}

	public String getSelfTakeDate(){
		return selfTakeDate;
	}

	public void setIsSpeed(boolean isSpeed){
		this.isSpeed = isSpeed;
	}

	public boolean isIsSpeed(){
		return isSpeed;
	}

	public void setCustomerMobile(String customerMobile){
		this.customerMobile = customerMobile;
	}

	public String getCustomerMobile(){
		return customerMobile;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}
}
