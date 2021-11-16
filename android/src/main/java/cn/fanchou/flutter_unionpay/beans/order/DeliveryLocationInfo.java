package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class DeliveryLocationInfo{

	@JSONField(name="orderDeliveryType")
	private int orderDeliveryType;

	@JSONField(name="shopDistance")
	private double shopDistance;

	@JSONField(name="shopLocation")
	private ShopLocation shopLocation;

	@JSONField(name="distance")
	private double distance;

	@JSONField(name="riderLocation")
	private String riderLocation;

	@JSONField(name="errMsg")
	private String errMsg;

	@JSONField(name="userLocation")
	private UserLocation userLocation;

	@JSONField(name="sfStatus")
	private String sfStatus;

	@JSONField(name="courierName")
	private String courierName;

	@JSONField(name="courierPhone")
	private String courierPhone;

	@JSONField(name="deliveryLefTime")
	private int deliveryLefTime;

	@JSONField(name="xfStatus")
	private String xfStatus;

	@JSONField(name="status")
	private int status;

	public void setOrderDeliveryType(int orderDeliveryType){
		this.orderDeliveryType = orderDeliveryType;
	}

	public int getOrderDeliveryType(){
		return orderDeliveryType;
	}

	public void setShopDistance(double shopDistance){
		this.shopDistance = shopDistance;
	}

	public double getShopDistance(){
		return shopDistance;
	}

	public void setShopLocation(ShopLocation shopLocation){
		this.shopLocation = shopLocation;
	}

	public ShopLocation getShopLocation(){
		return shopLocation;
	}

	public void setDistance(double distance){
		this.distance = distance;
	}

	public double getDistance(){
		return distance;
	}

	public void setRiderLocation(String riderLocation){
		this.riderLocation = riderLocation;
	}

	public String getRiderLocation(){
		return riderLocation;
	}

	public void setErrMsg(String errMsg){
		this.errMsg = errMsg;
	}

	public String getErrMsg(){
		return errMsg;
	}

	public void setUserLocation(UserLocation userLocation){
		this.userLocation = userLocation;
	}

	public UserLocation getUserLocation(){
		return userLocation;
	}

	public void setSfStatus(String sfStatus){
		this.sfStatus = sfStatus;
	}

	public String getSfStatus(){
		return sfStatus;
	}

	public void setCourierName(String courierName){
		this.courierName = courierName;
	}

	public String getCourierName(){
		return courierName;
	}

	public void setCourierPhone(String courierPhone){
		this.courierPhone = courierPhone;
	}

	public String getCourierPhone(){
		return courierPhone;
	}

	public void setDeliveryLefTime(int deliveryLefTime){
		this.deliveryLefTime = deliveryLefTime;
	}

	public int getDeliveryLefTime(){
		return deliveryLefTime;
	}

	public void setXfStatus(String xfStatus){
		this.xfStatus = xfStatus;
	}

	public String getXfStatus(){
		return xfStatus;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}
