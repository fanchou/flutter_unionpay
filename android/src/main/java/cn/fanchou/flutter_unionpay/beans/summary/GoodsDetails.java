package cn.fanchou.flutter_unionpay.beans.summary;

import com.alibaba.fastjson.annotation.JSONField;

public class GoodsDetails{

	@JSONField(name="imgUrl")
	private String imgUrl;

	@JSONField(name="total")
	private double total;

	@JSONField(name="goodsShortName")
	private String goodsShortName;

	@JSONField(name="goodsId")
	private int goodsId;

	@JSONField(name="num")
	private int num;

	@JSONField(name="percentage")
	private double percentage;

	@JSONField(name="skuNames")
	private String skuNames;

	@JSONField(name="goodsName")
	private String goodsName;

	@JSONField(name="skuId")
	private int skuId;

	@JSONField(name="productType")
	private String productType;

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return imgUrl;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public double getTotal(){
		return total;
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

	public void setNum(int num){
		this.num = num;
	}

	public int getNum(){
		return num;
	}

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public double getPercentage(){
		return percentage;
	}

	public void setSkuNames(String skuNames){
		this.skuNames = skuNames;
	}

	public String getSkuNames(){
		return skuNames;
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

	public void setProductType(String productType){
		this.productType = productType;
	}

	public String getProductType(){
		return productType;
	}
}
