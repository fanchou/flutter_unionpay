package cn.fanchou.flutter_unionpay.beans.summary;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class DamageGoodsListItem{

	@JSONField(name="catalogName")
	private String catalogName;

	@JSONField(name="catalogTotal")
	private double catalogTotal;

	@JSONField(name="goodSalesNum")
	private double goodSalesNum;

	@JSONField(name="percentage")
	private double percentage;

	@JSONField(name="goods")
	private List<GoodsItem> goods;

	public void setCatalogName(String catalogName){
		this.catalogName = catalogName;
	}

	public String getCatalogName(){
		return catalogName;
	}

	public void setCatalogTotal(double catalogTotal){
		this.catalogTotal = catalogTotal;
	}

	public double getCatalogTotal(){
		return catalogTotal;
	}

	public void setGoodSalesNum(double goodSalesNum){
		this.goodSalesNum = goodSalesNum;
	}

	public double getGoodSalesNum(){
		return goodSalesNum;
	}

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public double getPercentage(){
		return percentage;
	}

	public void setGoods(List<GoodsItem> goods){
		this.goods = goods;
	}

	public List<GoodsItem> getGoods(){
		return goods;
	}
}