package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class OrderGoodsInfo{

	@JSONField(name="goodsTotal")
	private double goodsTotal;

	@JSONField(name="goodsList")
	private List<GoodsListItem> goodsList;

	@JSONField(name="goodsNum")
	private double goodsNum;

	public void setGoodsTotal(double goodsTotal){
		this.goodsTotal = goodsTotal;
	}

	public double getGoodsTotal(){
		return goodsTotal;
	}

	public void setGoodsList(List<GoodsListItem> goodsList){
		this.goodsList = goodsList;
	}

	public List<GoodsListItem> getGoodsList(){
		return goodsList;
	}

	public void setGoodsNum(double goodsNum){
		this.goodsNum = goodsNum;
	}

	public double getGoodsNum(){
		return goodsNum;
	}
}