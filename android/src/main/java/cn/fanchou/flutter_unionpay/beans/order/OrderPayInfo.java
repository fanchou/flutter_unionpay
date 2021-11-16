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
	private int liShePayTotal;

	@JSONField(name="aliBarPayTotal")
	private int aliBarPayTotal;

	@JSONField(name="miniUserBarPayTotal")
	private int miniUserBarPayTotal;

	@JSONField(name="cashGiveBackMoney")
	private double cashGiveBackMoney;

	@JSONField(name="xfEntityCardPayTotal")
	private int xfEntityCardPayTotal;

	@JSONField(name="cardList")
	private List<CardListItem> cardList;

	@JSONField(name="wxFacePayTotal")
	private int wxFacePayTotal;

	@JSONField(name="miniweixinPayTotal")
	private int miniweixinPayTotal;

	@JSONField(name="payChannelList")
	private List<PayChannelListItem> payChannelList;

	@JSONField(name="weixinBarPayTotal")
	private int weixinBarPayTotal;

	@JSONField(name="couponPayTotal")
	private int couponPayTotal;

	@JSONField(name="memberPoints")
	private int memberPoints;

	@JSONField(name="xfElectronCardPayTotal")
	private int xfElectronCardPayTotal;

	@JSONField(name="czPayTotal")
	private int czPayTotal;

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

	public int getLiShePayTotal(){
		return liShePayTotal;
	}

	public void setAliBarPayTotal(int aliBarPayTotal){
		this.aliBarPayTotal = aliBarPayTotal;
	}

	public int getAliBarPayTotal(){
		return aliBarPayTotal;
	}

	public void setMiniUserBarPayTotal(int miniUserBarPayTotal){
		this.miniUserBarPayTotal = miniUserBarPayTotal;
	}

	public int getMiniUserBarPayTotal(){
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

	public int getXfEntityCardPayTotal(){
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

	public int getWxFacePayTotal(){
		return wxFacePayTotal;
	}

	public void setMiniweixinPayTotal(int miniweixinPayTotal){
		this.miniweixinPayTotal = miniweixinPayTotal;
	}

	public int getMiniweixinPayTotal(){
		return miniweixinPayTotal;
	}

	public void setPayChannelList(List<PayChannelListItem> payChannelList){
		this.payChannelList = payChannelList;
	}

	public List<PayChannelListItem> getPayChannelList(){
		return payChannelList;
	}

	public void setWeixinBarPayTotal(int weixinBarPayTotal){
		this.weixinBarPayTotal = weixinBarPayTotal;
	}

	public int getWeixinBarPayTotal(){
		return weixinBarPayTotal;
	}

	public void setCouponPayTotal(int couponPayTotal){
		this.couponPayTotal = couponPayTotal;
	}

	public int getCouponPayTotal(){
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

	public int getXfElectronCardPayTotal(){
		return xfElectronCardPayTotal;
	}

	public void setCzPayTotal(int czPayTotal){
		this.czPayTotal = czPayTotal;
	}

	public int getCzPayTotal(){
		return czPayTotal;
	}
}
