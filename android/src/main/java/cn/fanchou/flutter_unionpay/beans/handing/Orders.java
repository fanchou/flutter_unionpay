package cn.fanchou.flutter_unionpay.beans.handing;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class Orders{

	@JSONField(name="normal")
	private int normal;

	@JSONField(name="total")
	private int total;

	@JSONField(name="payDetails")
	private List<PayDetailsItem> payDetails;

	@JSONField(name="refound")
	private int refound;

	public void setNormal(int normal){
		this.normal = normal;
	}

	public int getNormal(){
		return normal;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setPayDetails(List<PayDetailsItem> payDetails){
		this.payDetails = payDetails;
	}

	public List<PayDetailsItem> getPayDetails(){
		return payDetails;
	}

	public void setRefound(int refound){
		this.refound = refound;
	}

	public int getRefound(){
		return refound;
	}
}