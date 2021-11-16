package cn.fanchou.flutter_unionpay.beans.order;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;

public class RefundOrderPayRefundInfo{

	@JSONField(name="refundPayChannelList")
	private List<RefundPayChannelListItem> refundPayChannelList;

	public void setRefundPayChannelList(List<RefundPayChannelListItem> refundPayChannelList){
		this.refundPayChannelList = refundPayChannelList;
	}

	public List<RefundPayChannelListItem> getRefundPayChannelList(){
		return refundPayChannelList;
	}
}
