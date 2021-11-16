package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderDeliveryInfo{

	@JSONField(name="deliveryLocationInfo")
	private DeliveryLocationInfo deliveryLocationInfo;

	@JSONField(name="receiverName")
	private String receiverName;

	@JSONField(name="receiverMobile")
	private String receiverMobile;

	@JSONField(name="remark")
	private String remark;

	@JSONField(name="receiverDetailAddress")
	private String receiverDetailAddress;

	@JSONField(name="isSpeed")
	private boolean isSpeed;

	@JSONField(name="receiverAddress")
	private String receiverAddress;

	@JSONField(name="courierName")
	private String courierName;

	@JSONField(name="fullAddress")
	private String fullAddress;

	@JSONField(name="receiverMobileBackup")
	private String receiverMobileBackup;

	@JSONField(name="courierPhone")
	private String courierPhone;

	@JSONField(name="deliveryTimeInterval")
	private String deliveryTimeInterval;

	@JSONField(name="deliveryDate")
	private String deliveryDate;

	@JSONField(name="takeCode")
	private String takeCode;

	public void setDeliveryLocationInfo(DeliveryLocationInfo deliveryLocationInfo){
		this.deliveryLocationInfo = deliveryLocationInfo;
	}

	public DeliveryLocationInfo getDeliveryLocationInfo(){
		return deliveryLocationInfo;
	}

	public void setReceiverName(String receiverName){
		this.receiverName = receiverName;
	}

	public String getReceiverName(){
		return receiverName;
	}

	public void setReceiverMobile(String receiverMobile){
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverMobile(){
		return receiverMobile;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return remark;
	}

	public void setReceiverDetailAddress(String receiverDetailAddress){
		this.receiverDetailAddress = receiverDetailAddress;
	}

	public String getReceiverDetailAddress(){
		return receiverDetailAddress;
	}

	public void setIsSpeed(boolean isSpeed){
		this.isSpeed = isSpeed;
	}

	public boolean isIsSpeed(){
		return isSpeed;
	}

	public void setReceiverAddress(String receiverAddress){
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverAddress(){
		return receiverAddress;
	}

	public void setCourierName(String courierName){
		this.courierName = courierName;
	}

	public String getCourierName(){
		return courierName;
	}

	public void setFullAddress(String fullAddress){
		this.fullAddress = fullAddress;
	}

	public String getFullAddress(){
		return fullAddress;
	}

	public void setReceiverMobileBackup(String receiverMobileBackup){
		this.receiverMobileBackup = receiverMobileBackup;
	}

	public String getReceiverMobileBackup(){
		return receiverMobileBackup;
	}

	public void setCourierPhone(String courierPhone){
		this.courierPhone = courierPhone;
	}

	public String getCourierPhone(){
		return courierPhone;
	}

	public void setDeliveryTimeInterval(String deliveryTimeInterval){
		this.deliveryTimeInterval = deliveryTimeInterval;
	}

	public String getDeliveryTimeInterval(){
		return deliveryTimeInterval;
	}

	public void setDeliveryDate(String deliveryDate){
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryDate(){
		return deliveryDate;
	}

	public void setTakeCode(String takeCode){
		this.takeCode = takeCode;
	}

	public String getTakeCode(){
		return takeCode;
	}
}
