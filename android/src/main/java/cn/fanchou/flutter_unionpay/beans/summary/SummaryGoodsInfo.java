package cn.fanchou.flutter_unionpay.beans.summary;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class SummaryGoodsInfo{

	@JSONField(name="SummaryGoodsInfo")
	private List<SummaryGoodsInfoItem> summaryGoodsInfo;

	public void setSummaryGoodsInfo(List<SummaryGoodsInfoItem> summaryGoodsInfo){
		this.summaryGoodsInfo = summaryGoodsInfo;
	}

	public List<SummaryGoodsInfoItem> getSummaryGoodsInfo(){
		return summaryGoodsInfo;
	}
}