package cn.fanchou.flutter_unionpay.utils;

import java.util.HashMap;
import java.util.Map;

public class MeituanStatus {
    static final Map<Integer, String> extrasStatus = new HashMap<>();
    static {
        extrasStatus.put(1,"新用户立减");
        extrasStatus.put(2,"满减");
        extrasStatus.put(3,"抵价券");
        extrasStatus.put(4,"套餐赠送");
        extrasStatus.put(5,"满赠");
        extrasStatus.put(6,"超时赔付");
        extrasStatus.put(7,"特价菜");
        extrasStatus.put(8,"首单返优惠券");
        extrasStatus.put(9,"使用红包");
        extrasStatus.put(11,"提前下单减");
        extrasStatus.put(12,"满返优惠券");
        extrasStatus.put(16,"满免配送费");
        extrasStatus.put(17,"折扣商品");
        extrasStatus.put(18,"美团专送再减");
        extrasStatus.put(19,"点评券");
        extrasStatus.put(20,"第二份半价");
        extrasStatus.put(21,"会员免配送费");
        extrasStatus.put(22,"门店新客立减");
        extrasStatus.put(23,"买赠");
        extrasStatus.put(24,"平台新用户立减");
        extrasStatus.put(25,"满减配送费");
        extrasStatus.put(27,"指定商品满减");
        extrasStatus.put(28,"新客满减");
        extrasStatus.put(30,"阶梯满减配送费");
        extrasStatus.put(36,"平台新客减配送费");
        extrasStatus.put(40,"加价购");
        extrasStatus.put(41,"新客折扣菜");
        extrasStatus.put(45,"外卖拼团");
        extrasStatus.put(46,"外卖加价购");
        extrasStatus.put(48,"拼团减配送费");
        extrasStatus.put(53,"新客专享减包装费");
        extrasStatus.put(54,"新客专享减配送费");
        extrasStatus.put(61,"品牌会员专享价");
        extrasStatus.put(65,"会员日折扣菜");
        extrasStatus.put(100,"满返商家代金券");
        extrasStatus.put(101,"使用商家代金券");
        extrasStatus.put(103,"进店领券");
        extrasStatus.put(117,"商品券");
        extrasStatus.put(118,"商品折扣券");
        extrasStatus.put(305,"津贴联盟");
        extrasStatus.put(306,"立减金");
        extrasStatus.put(307,"套餐推荐津贴");
        extrasStatus.put(73,"立减活动");
        extrasStatus.put(76,"品质秒杀");
        extrasStatus.put(64,"老客爆品");
    }
}
