package cn.fanchou.flutter_unionpay.beans.summary;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class SummaryGoodsInfoItem{

	@JSONField(name="catalogName")
	private String catalogName;

	@JSONField(name="catalogTotal")
	private double catalogTotal;

	@JSONField(name="goodSalesNum")
	private int goodSalesNum;

	@JSONField(name="goodsDetails")
	private List<GoodsDetails> goodsDetails;

	@JSONField(name="percentage")
	private double percentage;

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

	public void setGoodSalesNum(int goodSalesNum){
		this.goodSalesNum = goodSalesNum;
	}

	public int getGoodSalesNum(){
		return goodSalesNum;
	}

	public void setGoodsDetails(List<GoodsDetails> goodsDetails){
		this.goodsDetails = goodsDetails;
	}

	public List<GoodsDetails> getGoodsDetails(){
		return goodsDetails;
	}

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public double getPercentage(){
		return percentage;
	}
}
