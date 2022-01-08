package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class MeituanOrderModel{

	@JSONField(name="original_price")
	private String originalPrice;

	@JSONField(name="is_pre_sale_order")
	private String isPreSaleOrder;

	@JSONField(name="orderEntranceType")
	private String orderEntranceType;

	@JSONField(name="channel")
	private String channel;

	@JSONField(name="delivery_time")
	private String deliveryTime;

	@JSONField(name="openUid")
	private String openUid;

	@JSONField(name="avg_send_time")
	private String avgSendTime;

	@JSONField(name="ctime")
	private String ctime;

	@JSONField(name="app_id")
	private String appId;

	@JSONField(name="longitude")
	private String longitude;

	@JSONField(name="package_bag_money")
	private String packageBagMoney;

	@JSONField(name="shipper_phone")
	private String shipperPhone;

	@JSONField(name="logistics_code")
	private String logisticsCode;

	@JSONField(name="package_bag_money_yuan")
	private String packageBagMoneyYuan;

	@JSONField(name="shipping_fee")
	private String shippingFee;

	@JSONField(name="wm_poi_id")
	private String wmPoiId;

	@JSONField(name="poi_receive_detail")
	private PoiReceiveDetail poiReceiveDetail;

	@JSONField(name="extras")
	private List<ExtrasItem> extras;

	@JSONField(name="incmp_modules")
	private String incmpModules;

	@JSONField(name="detail")
	private List<DetailItem> detail;

	@JSONField(name="recipient_name")
	private String recipientName;

	@JSONField(name="order_id")
	private String orderId;

	@JSONField(name="wm_poi_phone")
	private String wmPoiPhone;

	@JSONField(name="status")
	private String status;

	@JSONField(name="city_id")
	private String cityId;

	@JSONField(name="recipient_phone")
	private String recipientPhone;

	@JSONField(name="incmp_code")
	private String incmpCode;

	@JSONField(name="wm_poi_name")
	private String wmPoiName;

	@JSONField(name="backup_recipient_phone")
	private String backupRecipientPhone;

	@JSONField(name="pick_type")
	private String pickType;

	@JSONField(name="order_tag_list")
	private String orderTagList;

	@JSONField(name="invoice_title")
	private String invoiceTitle;

	@JSONField(name="latitude")
	private String latitude;

	@JSONField(name="total_weight")
	private String totalWeight;

	@JSONField(name="sig")
	private String sig;

	@JSONField(name="total")
	private String total;

	@JSONField(name="pay_type")
	private String payType;

	@JSONField(name="caution")
	private String caution;

	@JSONField(name="timestamp")
	private String timestamp;

	@JSONField(name="recipient_address_desensitization")
	private String recipientAddressDesensitization;

	@JSONField(name="estimate_arrival_time")
	private String estimateArrivalTime;

	@JSONField(name="utime")
	private String utime;

	@JSONField(name="is_third_shipping")
	private String isThirdShipping;

	@JSONField(name="recipient_address")
	private String recipientAddress;

	@JSONField(name="invMakeType")
	private String invMakeType;

	@JSONField(name="app_poi_code")
	private String appPoiCode;

	@JSONField(name="has_invoiced")
	private String hasInvoiced;

	@JSONField(name="day_seq")
	private String daySeq;

	@JSONField(name="taxpayer_id")
	private String taxpayerId;

	@JSONField(name="wm_poi_address")
	private String wmPoiAddress;

	@JSONField(name="wm_order_id_view")
	private String wmOrderIdView;

	public void setOriginalPrice(String originalPrice){
		this.originalPrice = originalPrice;
	}

	public String getOriginalPrice(){
		return originalPrice;
	}

	public void setIsPreSaleOrder(String isPreSaleOrder){
		this.isPreSaleOrder = isPreSaleOrder;
	}

	public String getIsPreSaleOrder(){
		return isPreSaleOrder;
	}

	public void setOrderEntranceType(String orderEntranceType){
		this.orderEntranceType = orderEntranceType;
	}

	public String getOrderEntranceType(){
		return orderEntranceType;
	}

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return channel;
	}

	public void setDeliveryTime(String deliveryTime){
		this.deliveryTime = deliveryTime;
	}

	public String getDeliveryTime(){
		return deliveryTime;
	}

	public void setOpenUid(String openUid){
		this.openUid = openUid;
	}

	public String getOpenUid(){
		return openUid;
	}

	public void setAvgSendTime(String avgSendTime){
		this.avgSendTime = avgSendTime;
	}

	public String getAvgSendTime(){
		return avgSendTime;
	}

	public void setCtime(String ctime){
		this.ctime = ctime;
	}

	public String getCtime(){
		return ctime;
	}

	public void setAppId(String appId){
		this.appId = appId;
	}

	public String getAppId(){
		return appId;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setPackageBagMoney(String packageBagMoney){
		this.packageBagMoney = packageBagMoney;
	}

	public String getPackageBagMoney(){
		return packageBagMoney;
	}

	public void setShipperPhone(String shipperPhone){
		this.shipperPhone = shipperPhone;
	}

	public String getShipperPhone(){
		return shipperPhone;
	}

	public void setLogisticsCode(String logisticsCode){
		this.logisticsCode = logisticsCode;
	}

	public String getLogisticsCode(){
		return logisticsCode;
	}

	public void setPackageBagMoneyYuan(String packageBagMoneyYuan){
		this.packageBagMoneyYuan = packageBagMoneyYuan;
	}

	public String getPackageBagMoneyYuan(){
		return packageBagMoneyYuan;
	}

	public void setShippingFee(String shippingFee){
		this.shippingFee = shippingFee;
	}

	public String getShippingFee(){
		return shippingFee;
	}

	public void setWmPoiId(String wmPoiId){
		this.wmPoiId = wmPoiId;
	}

	public String getWmPoiId(){
		return wmPoiId;
	}

	public void setPoiReceiveDetail(PoiReceiveDetail poiReceiveDetail){
		this.poiReceiveDetail = poiReceiveDetail;
	}

	public PoiReceiveDetail getPoiReceiveDetail(){
		return poiReceiveDetail;
	}


	public void setIncmpModules(String incmpModules){
		this.incmpModules = incmpModules;
	}

	public String getIncmpModules(){
		return incmpModules;
	}

	public void setDetail(List<DetailItem> detail){
		this.detail = detail;
	}

	public List<DetailItem> getDetail(){
		return detail;
	}

	public void setExtras(List<ExtrasItem> extras){
		this.extras = extras;
	}

	public List<ExtrasItem> getExtras(){
		return extras;
	}

	public void setRecipientName(String recipientName){
		this.recipientName = recipientName;
	}

	public String getRecipientName(){
		return recipientName;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setWmPoiPhone(String wmPoiPhone){
		this.wmPoiPhone = wmPoiPhone;
	}

	public String getWmPoiPhone(){
		return wmPoiPhone;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setCityId(String cityId){
		this.cityId = cityId;
	}

	public String getCityId(){
		return cityId;
	}

	public void setRecipientPhone(String recipientPhone){
		this.recipientPhone = recipientPhone;
	}

	public String getRecipientPhone(){
		return recipientPhone;
	}

	public void setIncmpCode(String incmpCode){
		this.incmpCode = incmpCode;
	}

	public String getIncmpCode(){
		return incmpCode;
	}

	public void setWmPoiName(String wmPoiName){
		this.wmPoiName = wmPoiName;
	}

	public String getWmPoiName(){
		return wmPoiName;
	}

	public void setBackupRecipientPhone(String backupRecipientPhone){
		this.backupRecipientPhone = backupRecipientPhone;
	}

	public String getBackupRecipientPhone(){
		return backupRecipientPhone;
	}

	public void setPickType(String pickType){
		this.pickType = pickType;
	}

	public String getPickType(){
		return pickType;
	}

	public void setOrderTagList(String orderTagList){
		this.orderTagList = orderTagList;
	}

	public String getOrderTagList(){
		return orderTagList;
	}

	public void setInvoiceTitle(String invoiceTitle){
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceTitle(){
		return invoiceTitle;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setTotalWeight(String totalWeight){
		this.totalWeight = totalWeight;
	}

	public String getTotalWeight(){
		return totalWeight;
	}

	public void setSig(String sig){
		this.sig = sig;
	}

	public String getSig(){
		return sig;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setPayType(String payType){
		this.payType = payType;
	}

	public String getPayType(){
		return payType;
	}

	public void setCaution(String caution){
		this.caution = caution;
	}

	public String getCaution(){
		return caution;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public void setRecipientAddressDesensitization(String recipientAddressDesensitization){
		this.recipientAddressDesensitization = recipientAddressDesensitization;
	}

	public String getRecipientAddressDesensitization(){
		return recipientAddressDesensitization;
	}

	public void setEstimateArrivalTime(String estimateArrivalTime){
		this.estimateArrivalTime = estimateArrivalTime;
	}

	public String getEstimateArrivalTime(){
		return estimateArrivalTime;
	}

	public void setUtime(String utime){
		this.utime = utime;
	}

	public String getUtime(){
		return utime;
	}

	public void setIsThirdShipping(String isThirdShipping){
		this.isThirdShipping = isThirdShipping;
	}

	public String getIsThirdShipping(){
		return isThirdShipping;
	}

	public void setRecipientAddress(String recipientAddress){
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientAddress(){
		return recipientAddress;
	}

	public void setInvMakeType(String invMakeType){
		this.invMakeType = invMakeType;
	}

	public String getInvMakeType(){
		return invMakeType;
	}

	public void setAppPoiCode(String appPoiCode){
		this.appPoiCode = appPoiCode;
	}

	public String getAppPoiCode(){
		return appPoiCode;
	}

	public void setHasInvoiced(String hasInvoiced){
		this.hasInvoiced = hasInvoiced;
	}

	public String getHasInvoiced(){
		return hasInvoiced;
	}

	public void setDaySeq(String daySeq){
		this.daySeq = daySeq;
	}

	public String getDaySeq(){
		return daySeq;
	}

	public void setTaxpayerId(String taxpayerId){
		this.taxpayerId = taxpayerId;
	}

	public String getTaxpayerId(){
		return taxpayerId;
	}

	public void setWmPoiAddress(String wmPoiAddress){
		this.wmPoiAddress = wmPoiAddress;
	}

	public String getWmPoiAddress(){
		return wmPoiAddress;
	}

	public void setWmOrderIdView(String wmOrderIdView){
		this.wmOrderIdView = wmOrderIdView;
	}

	public String getWmOrderIdView(){
		return wmOrderIdView;
	}
}
