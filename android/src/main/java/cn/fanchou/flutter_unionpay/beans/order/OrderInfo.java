package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class OrderInfo{

	@JSONField(name="orderType")
	private int orderType;

	@JSONField(name="storeSequence")
	private String storeSequence;

	@JSONField(name="orderOperatorAccount")
	private String orderOperatorAccount;

	@JSONField(name="orderMoney")
	private double orderMoney;

	@JSONField(name="orderId")
	private String orderId;

	@JSONField(name="preferentialMoney")
	private double preferentialMoney;

	@JSONField(name="packageMoney")
	private double packageMoney;

	@JSONField(name="orderRemark")
	private String orderRemark;

	@JSONField(name="isSelfHelp")
	private boolean isSelfHelp;

	@JSONField(name="brandList")
	private List<BrandListItem> brandList;

	@JSONField(name="orderSelfTakeInfo")
	private OrderSelfTakeInfo orderSelfTakeInfo;

	@JSONField(name="seatNumber")
	private String seatNumber;

	@JSONField(name="orderPayInfo")
	private OrderPayInfo orderPayInfo;

	@JSONField(name="buyerRemark")
	private String buyerRemark;

	@JSONField(name="freightMoney")
	private double freightMoney;

	@JSONField(name="orderGoodsInfo")
	private OrderGoodsInfo orderGoodsInfo;

	@JSONField(name="netSalesMoney")
	private double netSalesMoney;

	@JSONField(name="tradeBillType")
	private int tradeBillType;

	@JSONField(name="serviceFeePercent")
	private double serviceFeePercent;

	@JSONField(name="receiverMobileBackup")
	private String receiverMobileBackup;

	@JSONField(name="storeName")
	private String storeName;

	@JSONField(name="orderOperatorId")
	private int orderOperatorId;

	@JSONField(name="orderOperatorFullName")
	private String orderOperatorFullName;

	@JSONField(name="takeCode")
	private String takeCode;

	@JSONField(name="serviceFee")
	private double serviceFee;

	@JSONField(name="remainReceiveMoney")
	private double remainReceiveMoney;

  @JSONField(name="refundOrderInfo")
  private RefundOrderInfo refundOrderInfo;

	@JSONField(name="nickName")
	private String nickName;

	@JSONField(name="orderDeliveryInfo")
	private OrderDeliveryInfo orderDeliveryInfo;

	@JSONField(name="mobile")
	private String mobile;

	@JSONField(name="fullName")
	private String fullName;

	@JSONField(name="isAddServiceFee")
	private boolean isAddServiceFee;

	@JSONField(name="userName")
	private String userName;

	@JSONField(name="storeId")
	private int storeId;

	@JSONField(name="userId")
	private String userId;

	@JSONField(name="shouldPayMoney")
	private double shouldPayMoney;

	@JSONField(name="refundOrderInfos")
	private List<Object> refundOrderInfos;

	@JSONField(name="giftMoney")
	private double giftMoney;

	@JSONField(name="createTime")
	private String createTime;

	@JSONField(name="storeAddress")
	private String storeAddress;

	@JSONField(name="orderSourceType")
	private int orderSourceType;

	@JSONField(name="actualReceiveMoney")
	private double actualReceiveMoney;

	@JSONField(name="storePhoneNo")
	private String storePhoneNo;

	@JSONField(name="status")
	private int status;

	public void setOrderType(int orderType){
		this.orderType = orderType;
	}

	public int getOrderType(){
		return orderType;
	}

	public void setStoreSequence(String storeSequence){
		this.storeSequence = storeSequence;
	}

	public String getStoreSequence(){
		return storeSequence;
	}

	public void setOrderOperatorAccount(String orderOperatorAccount){
		this.orderOperatorAccount = orderOperatorAccount;
	}

	public String getOrderOperatorAccount(){
		return orderOperatorAccount;
	}

	public void setOrderMoney(double orderMoney){
		this.orderMoney = orderMoney;
	}

	public double getOrderMoney(){
		return orderMoney;
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

	public void setPackageMoney(double packageMoney){
		this.packageMoney = packageMoney;
	}

	public double getPackageMoney(){
		return packageMoney;
	}

	public void setOrderRemark(String orderRemark){
		this.orderRemark = orderRemark;
	}

	public String getOrderRemark(){
		return orderRemark;
	}

	public void setIsSelfHelp(boolean isSelfHelp){
		this.isSelfHelp = isSelfHelp;
	}

	public boolean isIsSelfHelp(){
		return isSelfHelp;
	}

	public void setBrandList(List<BrandListItem> brandList){
		this.brandList = brandList;
	}

	public List<BrandListItem> getBrandList(){
		return brandList;
	}

	public void setOrderSelfTakeInfo(OrderSelfTakeInfo orderSelfTakeInfo){
		this.orderSelfTakeInfo = orderSelfTakeInfo;
	}

	public OrderSelfTakeInfo getOrderSelfTakeInfo(){
		return orderSelfTakeInfo;
	}

	public void setSeatNumber(String seatNumber){
		this.seatNumber = seatNumber;
	}

	public String getSeatNumber(){
		return seatNumber;
	}

	public void setOrderPayInfo(OrderPayInfo orderPayInfo){
		this.orderPayInfo = orderPayInfo;
	}

	public OrderPayInfo getOrderPayInfo(){
		return orderPayInfo;
	}

	public void setBuyerRemark(String buyerRemark){
		this.buyerRemark = buyerRemark;
	}

	public String getBuyerRemark(){
		return buyerRemark;
	}

	public void setFreightMoney(double freightMoney){
		this.freightMoney = freightMoney;
	}

	public double getFreightMoney(){
		return freightMoney;
	}

	public void setOrderGoodsInfo(OrderGoodsInfo orderGoodsInfo){
		this.orderGoodsInfo = orderGoodsInfo;
	}

	public OrderGoodsInfo getOrderGoodsInfo(){
		return orderGoodsInfo;
	}

	public void setNetSalesMoney(double netSalesMoney){
		this.netSalesMoney = netSalesMoney;
	}

	public double getNetSalesMoney(){
		return netSalesMoney;
	}

	public void setTradeBillType(int tradeBillType){
		this.tradeBillType = tradeBillType;
	}

	public int getTradeBillType(){
		return tradeBillType;
	}

	public void setServiceFeePercent(double serviceFeePercent){
		this.serviceFeePercent = serviceFeePercent;
	}

	public double getServiceFeePercent(){
		return serviceFeePercent;
	}

	public void setReceiverMobileBackup(String receiverMobileBackup){
		this.receiverMobileBackup = receiverMobileBackup;
	}

	public String getReceiverMobileBackup(){
		return receiverMobileBackup;
	}

	public void setStoreName(String storeName){
		this.storeName = storeName;
	}

	public String getStoreName(){
		return storeName;
	}

	public void setOrderOperatorId(int orderOperatorId){
		this.orderOperatorId = orderOperatorId;
	}

	public int getOrderOperatorId(){
		return orderOperatorId;
	}

	public void setOrderOperatorFullName(String orderOperatorFullName){
		this.orderOperatorFullName = orderOperatorFullName;
	}

	public String getOrderOperatorFullName(){
		return orderOperatorFullName;
	}

	public void setTakeCode(String takeCode){
		this.takeCode = takeCode;
	}

	public String getTakeCode(){
		return takeCode;
	}

	public void setServiceFee(double serviceFee){
		this.serviceFee = serviceFee;
	}

	public double getServiceFee(){
		return serviceFee;
	}

	public void setRemainReceiveMoney(double remainReceiveMoney){
		this.remainReceiveMoney = remainReceiveMoney;
	}

	public double getRemainReceiveMoney(){
		return remainReceiveMoney;
	}

	public void setRefundOrderInfo(RefundOrderInfo refundOrderInfo){
		this.refundOrderInfo = refundOrderInfo;
	}

	public RefundOrderInfo getRefundOrderInfo(){
		return refundOrderInfo;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return nickName;
	}

	public void setOrderDeliveryInfo(OrderDeliveryInfo orderDeliveryInfo){
		this.orderDeliveryInfo = orderDeliveryInfo;
	}

	public OrderDeliveryInfo getOrderDeliveryInfo(){
		return orderDeliveryInfo;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setIsAddServiceFee(boolean isAddServiceFee){
		this.isAddServiceFee = isAddServiceFee;
	}

	public boolean isIsAddServiceFee(){
		return isAddServiceFee;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setStoreId(int storeId){
		this.storeId = storeId;
	}

	public int getStoreId(){
		return storeId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setShouldPayMoney(double shouldPayMoney){
		this.shouldPayMoney = shouldPayMoney;
	}

	public double getShouldPayMoney(){
		return shouldPayMoney;
	}

	public void setRefundOrderInfos(List<Object> refundOrderInfos){
		this.refundOrderInfos = refundOrderInfos;
	}

	public List<Object> getRefundOrderInfos(){
		return refundOrderInfos;
	}

	public void setGiftMoney(double giftMoney){
		this.giftMoney = giftMoney;
	}

	public double getGiftMoney(){
		return giftMoney;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setStoreAddress(String storeAddress){
		this.storeAddress = storeAddress;
	}

	public String getStoreAddress(){
		return storeAddress;
	}

	public void setOrderSourceType(int orderSourceType){
		this.orderSourceType = orderSourceType;
	}

	public int getOrderSourceType(){
		return orderSourceType;
	}

	public void setActualReceiveMoney(double actualReceiveMoney){
		this.actualReceiveMoney = actualReceiveMoney;
	}

	public double getActualReceiveMoney(){
		return actualReceiveMoney;
	}

	public void setStorePhoneNo(String storePhoneNo){
		this.storePhoneNo = storePhoneNo;
	}

	public String getStorePhoneNo(){
		return storePhoneNo;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}
