package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class GoodsListItem{

	@JSONField(name="refundedNum")
	private double refundedNum;

	@JSONField(name="orderId")
	private String orderId;

	@JSONField(name="preferentialMoney")
	private double preferentialMoney;

	@JSONField(name="goodsId")
	private int goodsId;

	@JSONField(name="additionPropertyNames")
	private String additionPropertyNames;

	@JSONField(name="num")
	private double num;

	@JSONField(name="costPrice")
	private double costPrice;

	@JSONField(name="totalMoney")
	private double totalMoney;

	@JSONField(name="weight")
	private double weight;

	@JSONField(name="skuNames")
	private String skuNames;

	@JSONField(name="sellPrice")
	private double sellPrice;

	@JSONField(name="skuImg")
	private String skuImg;

	@JSONField(name="picUrl")
	private String picUrl;

	@JSONField(name="actualPayMoney")
	private double actualPayMoney;

	@JSONField(name="weighingWeight")
	private double weighingWeight;

	@JSONField(name="typeValue")
	private String typeValue;

	@JSONField(name="id")
	private int id;

	@JSONField(name="goodsName")
	private String goodsName;

	@JSONField(name="skuId")
	private int skuId;

	public void setRefundedNum(double refundedNum){
		this.refundedNum = refundedNum;
	}

	public double getRefundedNum(){
		return refundedNum;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setPreferentialMoney(double preferentialMoney){
		this.preferentialMoney = preferentialMoney;
	}

	public double getPreferentialMoney(){
		return preferentialMoney;
	}

	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}

	public int getGoodsId(){
		return goodsId;
	}

	public void setAdditionPropertyNames(String additionPropertyNames){
		this.additionPropertyNames = additionPropertyNames;
	}

	public String getAdditionPropertyNames(){
		return additionPropertyNames;
	}

	public void setNum(double num){
		this.num = num;
	}

	public double getNum(){
		return num;
	}

	public void setCostPrice(double costPrice){
		this.costPrice = costPrice;
	}

	public double getCostPrice(){
		return costPrice;
	}

	public void setTotalMoney(double totalMoney){
		this.totalMoney = totalMoney;
	}

	public double getTotalMoney(){
		return totalMoney;
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

	public void setSellPrice(double sellPrice){
		this.sellPrice = sellPrice;
	}

	public double getSellPrice(){
		return sellPrice;
	}

	public void setSkuImg(String skuImg){
		this.skuImg = skuImg;
	}

	public String getSkuImg(){
		return skuImg;
	}

	public void setPicUrl(String picUrl){
		this.picUrl = picUrl;
	}

	public String getPicUrl(){
		return picUrl;
	}

	public void setActualPayMoney(double actualPayMoney){
		this.actualPayMoney = actualPayMoney;
	}

	public double getActualPayMoney(){
		return actualPayMoney;
	}

	public void setWeighingWeight(double weighingWeight){
		this.weighingWeight = weighingWeight;
	}

	public double getWeighingWeight(){
		return weighingWeight;
	}

	public void setTypeValue(String typeValue){
		this.typeValue = typeValue;
	}

	public String getTypeValue(){
		return typeValue;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}

	public String getGoodsName(){
		return goodsName;
	}

	public void setSkuId(int skuId){
		this.skuId = skuId;
	}

	public int getSkuId(){
		return skuId;
	}
}
