package cn.fanchou.flutter_unionpay.beans.summary;

import com.alibaba.fastjson.annotation.JSONField;

public class GoodsItem{

	@JSONField(name="specificationId")
	private int specificationId;

	@JSONField(name="goodsShortName")
	private String goodsShortName;

	@JSONField(name="goodsId")
	private int goodsId;

	@JSONField(name="num")
	private double num;

	@JSONField(name="weight")
	private double weight;

	@JSONField(name="skuNames")
	private String skuNames;

	@JSONField(name="damageReason")
	private String damageReason;

	@JSONField(name="damageRecordId")
	private String damageRecordId;

	@JSONField(name="imgUrl")
	private String imgUrl;

	@JSONField(name="totalAmount")
	private double totalAmount;

	@JSONField(name="sellingPrice")
	private double sellingPrice;

	@JSONField(name="unit")
	private String unit;

	@JSONField(name="percentage")
	private double percentage;

	@JSONField(name="id")
	private String id;

	@JSONField(name="goodsName")
	private String goodsName;

	@JSONField(name="productType")
	private int productType;

	public void setSpecificationId(int specificationId){
		this.specificationId = specificationId;
	}

	public int getSpecificationId(){
		return specificationId;
	}

	public void setGoodsShortName(String goodsShortName){
		this.goodsShortName = goodsShortName;
	}

	public String getGoodsShortName(){
		return goodsShortName;
	}

	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}

	public int getGoodsId(){
		return goodsId;
	}

	public void setNum(double num){
		this.num = num;
	}

	public double getNum(){
		return num;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setSkuNames(String skuNames){
		this.skuNames = skuNames;
	}

	public String getSkuNames(){
		return skuNames;
	}

	public void setDamageReason(String damageReason){
		this.damageReason = damageReason;
	}

	public String getDamageReason(){
		return damageReason;
	}

	public void setDamageRecordId(String damageRecordId){
		this.damageRecordId = damageRecordId;
	}

	public String getDamageRecordId(){
		return damageRecordId;
	}

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return imgUrl;
	}

	public void setTotalAmount(double totalAmount){
		this.totalAmount = totalAmount;
	}

	public double getTotalAmount(){
		return totalAmount;
	}

	public void setSellingPrice(double sellingPrice){
		this.sellingPrice = sellingPrice;
	}

	public double getSellingPrice(){
		return sellingPrice;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public double getPercentage(){
		return percentage;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}

	public String getGoodsName(){
		return goodsName;
	}

	public void setProductType(int productType){
		this.productType = productType;
	}

	public int getProductType(){
		return productType;
	}
}