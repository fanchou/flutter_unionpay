package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class PoiReceiveDetail{

	@JSONField(name="wmPoiReceiveCent")
	private int wmPoiReceiveCent;

	@JSONField(name="onlinePayment")
	private int onlinePayment;

	@JSONField(name="actOrderChargeByPoi")
	private List<ActOrderChargeByMtItem> actOrderChargeByPoi;

	@JSONField(name="actOrderChargeByMt")
	private List<ActOrderChargeByMtItem> actOrderChargeByMt;

	@JSONField(name="logisticsFee")
	private int logisticsFee;

	@JSONField(name="foodShareFeeChargeByPoi")
	private double foodShareFeeChargeByPoi;

	public void setWmPoiReceiveCent(int wmPoiReceiveCent){
		this.wmPoiReceiveCent = wmPoiReceiveCent;
	}

	public int getWmPoiReceiveCent(){
		return wmPoiReceiveCent;
	}

	public void setOnlinePayment(int onlinePayment){
		this.onlinePayment = onlinePayment;
	}

	public int getOnlinePayment(){
		return onlinePayment;
	}

	public void setActOrderChargeByPoi(List<ActOrderChargeByMtItem> actOrderChargeByPoi){
		this.actOrderChargeByPoi = actOrderChargeByPoi;
	}

	public List<ActOrderChargeByMtItem> getActOrderChargeByPoi(){
		return actOrderChargeByPoi;
	}

	public void setActOrderChargeByMt(List<ActOrderChargeByMtItem> actOrderChargeByMt){
		this.actOrderChargeByMt = actOrderChargeByMt;
	}

	public List<ActOrderChargeByMtItem> getActOrderChargeByMt(){
		return actOrderChargeByMt;
	}

	public void setLogisticsFee(int logisticsFee){
		this.logisticsFee = logisticsFee;
	}

	public int getLogisticsFee(){
		return logisticsFee;
	}

	public void setFoodShareFeeChargeByPoi(double foodShareFeeChargeByPoi){
		this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
	}

	public double getFoodShareFeeChargeByPoi(){
		return foodShareFeeChargeByPoi;
	}
}
