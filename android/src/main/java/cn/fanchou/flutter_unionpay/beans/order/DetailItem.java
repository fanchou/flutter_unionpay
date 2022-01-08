package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class DetailItem{

	@JSONField(name="food_discount")
	private double foodDiscount;

	@JSONField(name="food_name")
	private String foodName;

	@JSONField(name="original_price")
	private double originalPrice;

	@JSONField(name="mt_spu_id")
	private long mtSpuId;

	@JSONField(name="quantity")
	private int quantity;

	@JSONField(name="actual_price")
	private double actualPrice;

	@JSONField(name="app_food_code")
	private String appFoodCode;

	@JSONField(name="box_num")
	private double boxNum;

	@JSONField(name="mt_sku_id")
	private long mtSkuId;

	@JSONField(name="box_price")
	private double boxPrice;

	@JSONField(name="weight")
	private int weight;

	@JSONField(name="sku_id")
	private String skuId;

	@JSONField(name="mt_tag_id")
	private long mtTagId;

	@JSONField(name="spec")
	private String spec;

	@JSONField(name="cart_id")
	private int cartId;

	@JSONField(name="unit")
	private String unit;

	@JSONField(name="price")
	private double price;

	public void setFoodDiscount(double foodDiscount){
		this.foodDiscount = foodDiscount;
	}

	public double getFoodDiscount(){
		return foodDiscount;
	}

	public void setFoodName(String foodName){
		this.foodName = foodName;
	}

	public String getFoodName(){
		return foodName;
	}

	public void setOriginalPrice(double originalPrice){
		this.originalPrice = originalPrice;
	}

	public double getOriginalPrice(){
		return originalPrice;
	}

	public void setMtSpuId(long mtSpuId){
		this.mtSpuId = mtSpuId;
	}

	public long getMtSpuId(){
		return mtSpuId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setActualPrice(double actualPrice){
		this.actualPrice = actualPrice;
	}

	public double getActualPrice(){
		return actualPrice;
	}

	public void setAppFoodCode(String appFoodCode){
		this.appFoodCode = appFoodCode;
	}

	public String getAppFoodCode(){
		return appFoodCode;
	}

	public void setBoxNum(double boxNum){
		this.boxNum = boxNum;
	}

	public double getBoxNum(){
		return boxNum;
	}

	public void setMtSkuId(long mtSkuId){
		this.mtSkuId = mtSkuId;
	}

	public long getMtSkuId(){
		return mtSkuId;
	}

	public void setBoxPrice(double boxPrice){
		this.boxPrice = boxPrice;
	}

	public double getBoxPrice(){
		return boxPrice;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setSkuId(String skuId){
		this.skuId = skuId;
	}

	public String getSkuId(){
		return skuId;
	}

	public void setMtTagId(long mtTagId){
		this.mtTagId = mtTagId;
	}

	public long getMtTagId(){
		return mtTagId;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}

	public String getSpec(){
		return spec;
	}

	public void setCartId(int cartId){
		this.cartId = cartId;
	}

	public int getCartId(){
		return cartId;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}
}
