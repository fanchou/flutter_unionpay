package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class RefundOrderGoodsInfo{

	@JSONField(name="goodsList")
	private List<GoodsListItem> goodsList;

	public void setGoodsList(List<GoodsListItem> goodsList){
		this.goodsList = goodsList;
	}

	public List<GoodsListItem> getGoodsList(){
		return goodsList;
	}
}
