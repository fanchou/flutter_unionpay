package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class OrderPayInfo{

	@JSONField(name="cashPayTotal")
	private double cashPayTotal;

  @JSONField(name="couponPayInfos")
  private List<CouponPayInfosItem> couponPayInfos;

	@JSONField(name="cashReceiveMoney")
	private double cashReceiveMoney;

	@JSONField(name="liShePayTotal")
	private double liShePayTotal;

	@JSONField(name="aliBarPayTotal")
	private double aliBarPayTotal;

	@JSONField(name="miniUserBarPayTotal")
	private double miniUserBarPayTotal;

	@JSONField(name="cashGiveBackMoney")
	private double cashGiveBackMoney;

	@JSONField(name="xfEntityCardPayTotal")
	private double xfEntityCardPayTotal;

	@JSONField(name="cardList")
	private List<CardListItem> cardList;

	@JSONField(name="wxFacePayTotal")
	private double wxFacePayTotal;

	@JSONField(name="miniweixinPayTotal")
	private double miniweixinPayTotal;

	@JSONField(name="payChannelList")
	private List<PayChannelListItem> payChannelList;

	@JSONField(name="weixinBarPayTotal")
	private double weixinBarPayTotal;

	@JSONField(name="couponPayTotal")
	private double couponPayTotal;

	@JSONField(name="memberPoints")
	private int memberPoints;

	@JSONField(name="xfElectronCardPayTotal")
	private double xfElectronCardPayTotal;

	@JSONField(name="czPayTotal")
	private double czPayTotal;

	public void setCashPayTotal(double cashPayTotal){
		this.cashPayTotal = cashPayTotal;
	}

	public double getCashPayTotal(){
		return cashPayTotal;
	}

	public void setCouponPayInfos(List<CouponPayInfosItem> couponPayInfos){
		this.couponPayInfos = couponPayInfos;
	}

	public List<CouponPayInfosItem> getCouponPayInfos(){
		return couponPayInfos;
	}

	public void setCashReceiveMoney(double cashReceiveMoney){
		this.cashReceiveMoney = cashReceiveMoney;
	}

	public double getCashReceiveMoney(){
		return cashReceiveMoney;
	}

	public void setLiShePayTotal(int liShePayTotal){
		this.liShePayTotal = liShePayTotal;
	}

	public double getLiShePayTotal(){
		return liShePayTotal;
	}

	public void setAliBarPayTotal(int aliBarPayTotal){
		this.aliBarPayTotal = aliBarPayTotal;
	}

	public double getAliBarPayTotal(){
		return aliBarPayTotal;
	}

	public void setMiniUserBarPayTotal(int miniUserBarPayTotal){
		this.miniUserBarPayTotal = miniUserBarPayTotal;
	}

	public double getMiniUserBarPayTotal(){
		return miniUserBarPayTotal;
	}

	public void setCashGiveBackMoney(double cashGiveBackMoney){
		this.cashGiveBackMoney = cashGiveBackMoney;
	}

	public double getCashGiveBackMoney(){
		return cashGiveBackMoney;
	}

	public void setXfEntityCardPayTotal(int xfEntityCardPayTotal){
		this.xfEntityCardPayTotal = xfEntityCardPayTotal;
	}

	public double getXfEntityCardPayTotal(){
		return xfEntityCardPayTotal;
	}

  public void setCardList(List<CardListItem> cardList){
    this.cardList = cardList;
  }

	public List<CardListItem> getCardList(){
		return cardList;
	}

	public void setWxFacePayTotal(int wxFacePayTotal){
		this.wxFacePayTotal = wxFacePayTotal;
	}

	public double getWxFacePayTotal(){
		return wxFacePayTotal;
	}

	public void setMiniweixinPayTotal(int miniweixinPayTotal){
		this.miniweixinPayTotal = miniweixinPayTotal;
	}

	public double getMiniweixinPayTotal(){
		return miniweixinPayTotal;
	}

	public void setPayChannelList(List<PayChannelListItem> payChannelList){
		this.payChannelList = payChannelList;
	}

	public List<PayChannelListItem> getPayChannelList(){
		return payChannelList;
	}

	public void setWeixinBarPayTotal(double weixinBarPayTotal){
		this.weixinBarPayTotal = weixinBarPayTotal;
	}

	public double getWeixinBarPayTotal(){
		return weixinBarPayTotal;
	}

	public void setCouponPayTotal(int couponPayTotal){
		this.couponPayTotal = couponPayTotal;
	}

	public double getCouponPayTotal(){
		return couponPayTotal;
	}

	public void setMemberPoints(int memberPoints){
		this.memberPoints = memberPoints;
	}

	public int getMemberPoints(){
		return memberPoints;
	}

	public void setXfElectronCardPayTotal(int xfElectronCardPayTotal){
		this.xfElectronCardPayTotal = xfElectronCardPayTotal;
	}

	public double getXfElectronCardPayTotal(){
		return xfElectronCardPayTotal;
	}

	public void setCzPayTotal(int czPayTotal){
		this.czPayTotal = czPayTotal;
	}

	public double getCzPayTotal(){
		return czPayTotal;
	}
}
