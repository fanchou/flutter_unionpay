package cn.fanchou.flutter_unionpay.beans.store;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class StoreListItem{

	@JSONField(name="secondLevelStoreId")
	private Object secondLevelStoreId;

	@JSONField(name="storeLevelName")
	private String storeLevelName;

	@JSONField(name="storeType")
	private int storeType;

	@JSONField(name="address")
	private String address;

	@JSONField(name="latitude")
	private String latitude;

	@JSONField(name="cityId")
	private int cityId;

	@JSONField(name="brandIds")
	private List<Integer> brandIds;

	@JSONField(name="provinceId")
	private int provinceId;

	@JSONField(name="storeDetailType")
	private int storeDetailType;

	@JSONField(name="districtId")
	private int districtId;

	@JSONField(name="name")
	private String name;

	@JSONField(name="firstLevelStoreId")
	private Object firstLevelStoreId;

	@JSONField(name="checked")
	private Object checked;

	@JSONField(name="id")
	private int id;

	@JSONField(name="longitude")
	private String longitude;

	public void setSecondLevelStoreId(Object secondLevelStoreId){
		this.secondLevelStoreId = secondLevelStoreId;
	}

	public Object getSecondLevelStoreId(){
		return secondLevelStoreId;
	}

	public void setStoreLevelName(String storeLevelName){
		this.storeLevelName = storeLevelName;
	}

	public String getStoreLevelName(){
		return storeLevelName;
	}

	public void setStoreType(int storeType){
		this.storeType = storeType;
	}

	public int getStoreType(){
		return storeType;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setCityId(int cityId){
		this.cityId = cityId;
	}

	public int getCityId(){
		return cityId;
	}

	public void setBrandIds(List<Integer> brandIds){
		this.brandIds = brandIds;
	}

	public List<Integer> getBrandIds(){
		return brandIds;
	}

	public void setProvinceId(int provinceId){
		this.provinceId = provinceId;
	}

	public int getProvinceId(){
		return provinceId;
	}

	public void setStoreDetailType(int storeDetailType){
		this.storeDetailType = storeDetailType;
	}

	public int getStoreDetailType(){
		return storeDetailType;
	}

	public void setDistrictId(int districtId){
		this.districtId = districtId;
	}

	public int getDistrictId(){
		return districtId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFirstLevelStoreId(Object firstLevelStoreId){
		this.firstLevelStoreId = firstLevelStoreId;
	}

	public Object getFirstLevelStoreId(){
		return firstLevelStoreId;
	}

	public void setChecked(Object checked){
		this.checked = checked;
	}

	public Object getChecked(){
		return checked;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}
}