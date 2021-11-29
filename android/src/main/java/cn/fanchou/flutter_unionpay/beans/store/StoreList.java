package cn.fanchou.flutter_unionpay.beans.store;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class StoreList{

	@JSONField(name="StoreList")
	private List<StoreListItem> storeList;

	public void setStoreList(List<StoreListItem> storeList){
		this.storeList = storeList;
	}

	public List<StoreListItem> getStoreList(){
		return storeList;
	}
}