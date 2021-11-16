package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class UserLocation{

	@JSONField(name="imgUrl")
	private String imgUrl;

	@JSONField(name="latitude")
	private String latitude;

	@JSONField(name="longitude")
	private String longitude;

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return imgUrl;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}
}
