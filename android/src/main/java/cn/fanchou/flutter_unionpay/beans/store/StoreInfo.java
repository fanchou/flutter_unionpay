package cn.fanchou.flutter_unionpay.beans.store;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class StoreInfo{

	@JSONField(name="secondLevelStoreId")
	private int secondLevelStoreId;

	@JSONField(name="storeLevelName")
	private String storeLevelName;

	@JSONField(name="storeType")
	private int storeType;

	@JSONField(name="firstLevelStoreName")
	private String firstLevelStoreName;

	@JSONField(name="address")
	private String address;

	@JSONField(name="districtName")
	private String districtName;

	@JSONField(name="storeTypeName")
	private String storeTypeName;

	@JSONField(name="latitude")
	private String latitude;

	@JSONField(name="cityId")
	private int cityId;

	@JSONField(name="provinceId")
	private int provinceId;

	@JSONField(name="brandIds")
	private List<Integer> brandIds;

	@JSONField(name="brandInfos")
	private List<BrandInfosItem> brandInfos;

	@JSONField(name="storeDetailType")
	private int storeDetailType;

	@JSONField(name="districtId")
	private int districtId;

	@JSONField(name="cityName")
	private String cityName;

	@JSONField(name="secondLevelStoreName")
	private String secondLevelStoreName;

	@JSONField(name="name")
	private String name;

	@JSONField(name="firstLevelStoreId")
	private int firstLevelStoreId;

	@JSONField(name="id")
	private int id;

	@JSONField(name="provinceName")
	private String provinceName;

	@JSONField(name="longitude")
	private String longitude;

	public void setSecondLevelStoreId(int secondLevelStoreId){
		this.secondLevelStoreId = secondLevelStoreId;
	}

	public int getSecondLevelStoreId(){
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

	public void setFirstLevelStoreName(String firstLevelStoreName){
		this.firstLevelStoreName = firstLevelStoreName;
	}

	public String getFirstLevelStoreName(){
		return firstLevelStoreName;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}

	public String getDistrictName(){
		return districtName;
	}

	public void setStoreTypeName(String storeTypeName){
		this.storeTypeName = storeTypeName;
	}

	public String getStoreTypeName(){
		return storeTypeName;
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

	public void setProvinceId(int provinceId){
		this.provinceId = provinceId;
	}

	public int getProvinceId(){
		return provinceId;
	}

	public void setBrandIds(List<Integer> brandIds){
		this.brandIds = brandIds;
	}

	public List<Integer> getBrandIds(){
		return brandIds;
	}

	public void setBrandInfos(List<BrandInfosItem> brandInfos){
		this.brandInfos = brandInfos;
	}

	public List<BrandInfosItem> getBrandInfos(){
		return brandInfos;
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

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setSecondLevelStoreName(String secondLevelStoreName){
		this.secondLevelStoreName = secondLevelStoreName;
	}

	public String getSecondLevelStoreName(){
		return secondLevelStoreName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFirstLevelStoreId(int firstLevelStoreId){
		this.firstLevelStoreId = firstLevelStoreId;
	}

	public int getFirstLevelStoreId(){
		return firstLevelStoreId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}

	public String getProvinceName(){
		return provinceName;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}
}