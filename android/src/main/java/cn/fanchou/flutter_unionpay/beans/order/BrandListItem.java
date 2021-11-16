package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class BrandListItem{

	@JSONField(name="nearbyStoreBrand")
	private String nearbyStoreBrand;

	@JSONField(name="name")
	private String name;

	@JSONField(name="id")
	private int id;

	public void setNearbyStoreBrand(String nearbyStoreBrand){
		this.nearbyStoreBrand = nearbyStoreBrand;
	}

	public String getNearbyStoreBrand(){
		return nearbyStoreBrand;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}