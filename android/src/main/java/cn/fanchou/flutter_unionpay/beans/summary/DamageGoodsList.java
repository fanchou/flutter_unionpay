package cn.fanchou.flutter_unionpay.beans.summary;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class DamageGoodsList{

	@JSONField(name="DamageGoodsList")
	private List<DamageGoodsListItem> damageGoodsList;

	public void setDamageGoodsList(List<DamageGoodsListItem> damageGoodsList){
		this.damageGoodsList = damageGoodsList;
	}

	public List<DamageGoodsListItem> getDamageGoodsList(){
		return damageGoodsList;
	}
}