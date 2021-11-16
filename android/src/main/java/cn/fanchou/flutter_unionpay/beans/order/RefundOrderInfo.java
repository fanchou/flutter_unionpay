package cn.fanchou.flutter_unionpay.beans.order;

import com.alibaba.fastjson.annotation.JSONField;

public class RefundOrderInfo{

	@JSONField(name="refundType")
	private int refundType;

	@JSONField(name="refundOperatorId")
	private int refundOperatorId;

	@JSONField(name="refundOperatorFullName")
	private String refundOperatorFullName;

	@JSONField(name="originalOrderId")
	private String originalOrderId;

	@JSONField(name="refundTime")
	private String refundTime;

	@JSONField(name="refundOperatorAccount")
	private String refundOperatorAccount;

	@JSONField(name="refundOrderPayRefundInfo")
	private RefundOrderPayRefundInfo refundOrderPayRefundInfo;

	@JSONField(name="refundOrderGoodsInfo")
	private RefundOrderGoodsInfo refundOrderGoodsInfo;

	@JSONField(name="refundMoney")
	private double refundMoney;

	@JSONField(name="originalOrderMoney")
	private double originalOrderMoney;

	@JSONField(name="orderRefundId")
	private String orderRefundId;

	@JSONField(name="saleafterType")
	private int saleafterType;

	public void setRefundType(int refundType){
		this.refundType = refundType;
	}

	public int getRefundType(){
		return refundType;
	}

	public void setRefundOperatorId(int refundOperatorId){
		this.refundOperatorId = refundOperatorId;
	}

	public int getRefundOperatorId(){
		return refundOperatorId;
	}

	public void setRefundOperatorFullName(String refundOperatorFullName){
		this.refundOperatorFullName = refundOperatorFullName;
	}

	public String getRefundOperatorFullName(){
		return refundOperatorFullName;
	}

	public void setOriginalOrderId(String originalOrderId){
		this.originalOrderId = originalOrderId;
	}

	public String getOriginalOrderId(){
		return originalOrderId;
	}

	public void setRefundTime(String refundTime){
		this.refundTime = refundTime;
	}

	public String getRefundTime(){
		return refundTime;
	}

	public void setRefundOperatorAccount(String refundOperatorAccount){
		this.refundOperatorAccount = refundOperatorAccount;
	}

	public String getRefundOperatorAccount(){
		return refundOperatorAccount;
	}

	public void setRefundOrderPayRefundInfo(RefundOrderPayRefundInfo refundOrderPayRefundInfo){
		this.refundOrderPayRefundInfo = refundOrderPayRefundInfo;
	}

	public RefundOrderPayRefundInfo getRefundOrderPayRefundInfo(){
		return refundOrderPayRefundInfo;
	}

	public void setRefundOrderGoodsInfo(RefundOrderGoodsInfo refundOrderGoodsInfo){
		this.refundOrderGoodsInfo = refundOrderGoodsInfo;
	}

	public RefundOrderGoodsInfo getRefundOrderGoodsInfo(){
		return refundOrderGoodsInfo;
	}

	public void setRefundMoney(double refundMoney){
		this.refundMoney = refundMoney;
	}

	public double getRefundMoney(){
		return refundMoney;
	}

	public void setOriginalOrderMoney(double originalOrderMoney){
		this.originalOrderMoney = originalOrderMoney;
	}

	public double getOriginalOrderMoney(){
		return originalOrderMoney;
	}

	public void setOrderRefundId(String orderRefundId){
		this.orderRefundId = orderRefundId;
	}

	public String getOrderRefundId(){
		return orderRefundId;
	}

	public void setSaleafterType(int saleafterType){
		this.saleafterType = saleafterType;
	}

	public int getSaleafterType(){
		return saleafterType;
	}
}
