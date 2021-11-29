package cn.fanchou.flutter_unionpay.beans.handing;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;


public class SumList {

  @JSONField(name="sumList")

  private List<PayInfo> sumList;

  public void setSumList(List<PayInfo> sumList){
    this.sumList = sumList;
  }

  public List<PayInfo> getSumList(){
    return sumList;
  }

}
