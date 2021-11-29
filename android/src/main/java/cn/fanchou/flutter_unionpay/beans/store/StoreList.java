package cn.fanchou.flutter_unionpay.beans.store;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class StoreList {

  @JSONField(name="storeList")
  private List<StoreInfo> storeList;

  public void setStoreList(List<StoreInfo> storeList){
    this.storeList = storeList;
  }

  public List<StoreInfo> getStoreList(){
    return storeList;
  }

}
