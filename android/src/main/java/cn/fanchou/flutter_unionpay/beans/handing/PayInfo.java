package cn.fanchou.flutter_unionpay.beans.handing;
import com.alibaba.fastjson.annotation.JSONField;

public class PayInfo {
  @JSONField(name="payName")
  private String payName;

  @JSONField(name="money")
  private double money;

  @JSONField(name="ratio")
  private String ratio;


  public void setPayName(String payName){
    this.payName = payName;
  }

  public String getPayName(){
    return payName;
  }

  public void setMoney(double money){
    this.money = money;
  }

  public double getMoney(){
    return money;
  }

  public void setRatio(String ratio){this.ratio = ratio;}

  public String getRatio(){
    return ratio;
  }

}
