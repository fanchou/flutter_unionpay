package cn.fanchou.flutter_unionpay.beans.store;

import com.alibaba.fastjson.annotation.JSONField;

public class BrandInfosItem{

	@JSONField(name="name")
	private String name;

	@JSONField(name="id")
	private int id;

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