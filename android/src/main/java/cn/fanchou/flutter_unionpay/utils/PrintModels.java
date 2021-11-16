package cn.fanchou.flutter_unionpay.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fanchou.flutter_unionpay.beans.order.CardListItem;
import cn.fanchou.flutter_unionpay.beans.order.CouponPayInfosItem;
import cn.fanchou.flutter_unionpay.beans.order.GoodsListItem;
import cn.fanchou.flutter_unionpay.beans.order.OrderInfo;
import cn.fanchou.flutter_unionpay.beans.order.PayChannelListItem;
import cn.fanchou.flutter_unionpay.beans.order.RefundPayChannelListItem;

public class PrintModels {

  private static Map<String, String> channelType = new HashMap<>();
  static {
    channelType.put( "02", "微信支付(条码)");
    channelType.put("03", "支付宝支付(条码)");
    channelType.put("04", "鲜范实体卡");
    channelType.put("05", "鲜范电子卡");
    channelType.put("06", "现金或其他");
    channelType.put("07", "微信小程序支付");
    channelType.put("09", "储值支付");
    channelType.put("10", "微信人脸支付");
    channelType.put("11", "其他支付");
  }

  public static String format2(double value) {
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.toString();
  }


  /**
   * 订单打印
   **/
  public String orderInfo(Map printInfo) {
    PrintScriptUtil printer = new PrintScriptUtil();
    Map<String, String> logoImages = new HashMap<>();
    // todo 这里需要转成base64，固定图片可以直接先转了，免得浪费计算资源
    logoImages.put("BT", "assets/BT.jpg");
    logoImages.put("HY", "assets/BT.jpg");
    logoImages.put("MZCK", "assets/BT.jpg");
    logoImages.put("HZ", "assets/BT.jpg");
    boolean againBool = (boolean) printInfo.get("againBool");

    // 解析json
    String order = (String) printInfo.get("orderInfo");
    JSONObject json = JSON.parseObject(order);
    OrderInfo orderInfo = JSON.parseObject(json.toJSONString(), OrderInfo.class);

    // 是否是领展，用于特殊处理打印
    boolean isLinzhan = false;

    int storeId = (int) printInfo.get("storeId");

    isLinzhan = storeId == 74;

    // 是否是黑钻店
    boolean isHeizuan = false;

    // 如果有新加的门店，加到这个里面就可以了
    int[] heiZuanStore = {96};

    if (Arrays.asList(heiZuanStore).contains(storeId)) {
      isHeizuan = true;
    }

    String brandName;
    String imagePath;

    int orderType = orderInfo.getOrderType();

    if (isHeizuan) {
      brandName = orderInfo.getBrandList().get(0).getName();
      imagePath = logoImages.get("HZ");
    } else {
      if (orderInfo.getBrandList().size() > 1 || orderInfo.getBrandList().size() == 0) {
        brandName = "面包新语";
        imagePath = logoImages.get("BT");
      } else {
        brandName = orderInfo.getBrandList().get(0).getName();
        imagePath = logoImages.get(orderInfo.getBrandList().get(0).getNearbyStoreBrand());
      }
    }

    List<GoodsListItem> goodList;
    if (orderInfo.getTradeBillType() == 1) {
      goodList = orderInfo.getOrderGoodsInfo().getGoodsList();
    } else {
       goodList = orderInfo.getRefundOrderInfo().getRefundOrderGoodsInfo().getGoodsList();
    }

    String orderId = orderInfo.getOrderId();

    if (againBool) {
      printer.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE)
        .text(ScriptConstant.LEFT, "重新打印")
        .emptyLines(1);
    }

    // 打印logo
    printer.setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
//      .addImage(ScriptConstant.CENTER, "180*105", imagePath)
      .setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE,"8","6")
      .text(ScriptConstant.CENTER, orderInfo.getTradeBillType() == 1 ? brandName + "-" + orderInfo.getStoreName() : "(退)" + brandName + "-" + orderInfo.getStoreName())
      .emptyLines(1)
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "收银员：" + orderInfo.getOrderOperatorFullName());

    if (orderInfo.getTradeBillType() == 1) {
      printer.text(ScriptConstant.LEFT, "买单时间：" + orderInfo.getCreateTime());
    } else {
      printer.text(ScriptConstant.LEFT, "售后时间：" + orderInfo.getRefundOrderInfo().getRefundTime())
        .text(ScriptConstant.LEFT, "原单号：" + orderInfo.getRefundOrderInfo().getOriginalOrderId());
    }

    printer.text(ScriptConstant.LEFT, "单号：" + orderId);

    // 配送时间
    if (orderInfo.getOrderSourceType() == 2 && orderInfo.getTradeBillType() == 1) {
      if (againBool ? orderType == 4 : orderType == 3) {
        printer.text(
          ScriptConstant.LEFT,
          "自提时间：" + orderInfo.getOrderSelfTakeInfo().getSelfTakeDate() + " " + orderInfo.getOrderSelfTakeInfo().getSelfTakeTimeInterval()
        );
      } else if (againBool ? orderType == 1 : orderType == 2) {
        printer.text(ScriptConstant.LEFT, "配送时间：" + orderInfo.getOrderDeliveryInfo().getDeliveryDate() + " " + orderInfo.getOrderDeliveryInfo().getDeliveryTimeInterval());
      }
    }

    printer.emptyLines(1);

    if (orderInfo.getOrderSourceType() == 2 && orderInfo.getTradeBillType() == 1) {
      if (againBool ? orderType == 4 : orderType == 3) {
        printer.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "10","6");
        printer.text(
          ScriptConstant.CENTER,
          "自提码：" + (orderInfo.getSeatNumber().equals("") ? orderInfo.getOrderSelfTakeInfo().getSelfTakeCode() : orderInfo.getSeatNumber())
        );
        if (!orderInfo.getOrderSelfTakeInfo().getRemark().equals("")) {
          printer.emptyLines(1);
          printer.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE);
          printer.text(ScriptConstant.LEFT, "备注：" + orderInfo.getOrderSelfTakeInfo().getRemark());
        }
      } else if (againBool ? orderType == 1 : orderType == 2) {
        printer.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE,"10","6");
        printer.text(ScriptConstant.CENTER, "取货码：" + orderInfo.getOrderDeliveryInfo().getTakeCode());
        printer.emptyLines(1);
        printer.text(ScriptConstant.LARGE, orderInfo.getOrderDeliveryInfo().getFullAddress());
        printer.emptyLines(1);
        printer.text(ScriptConstant.LARGE, orderInfo.getOrderDeliveryInfo().getReceiverName() + " " + orderInfo.getOrderDeliveryInfo().getReceiverMobile().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        if (!orderInfo.getOrderDeliveryInfo().getRemark().equals("")) {
          printer.emptyLines(1);
          printer.text(ScriptConstant.LEFT, "备注：" + orderInfo.getOrderDeliveryInfo().getRemark());
        }

      }
    } else {
      if (orderInfo.getOrderSelfTakeInfo() != null) {
        printer.text(
          ScriptConstant.CENTER,
          "牌号：" + (orderInfo.getSeatNumber().equals("") ? orderInfo.getOrderSelfTakeInfo().getSelfTakeDate() : orderInfo.getSeatNumber())
        );
        printer.emptyLines(1);
      }
    }

    printer.addLine();

    printer.setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL);

    // 打印商品列表表格
    printer.printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"名称","数量","金额"});

    // 循环打印商品
    for (Object goodItem: goodList){
      GoodsListItem item = (GoodsListItem) goodItem;
      String goodsName;
      if (item.getSkuNames().equals("")) {
        goodsName = item.getGoodsName();
      } else {
        goodsName = item.getGoodsName() + "(" + item.getSkuNames() + ")";
      }

      printer.printTable(
        new int[]{16,8,8},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT},
        new String[]{
          goodsName,
          String.valueOf((item.getWeighingWeight() > 0.00) ? (orderInfo.getTradeBillType() == 1 ? item.getWeighingWeight() : '-' + item.getWeighingWeight()) : (orderInfo.getTradeBillType() == 1 ? item.getNum() : item.getNum() * -1)),
          (item.getWeighingWeight() > 0.00) ? (orderInfo.getTradeBillType() == 1 ? format2(item.getSellPrice() * (item.getWeighingWeight() / item.getWeight()) - item.getPreferentialMoney()) : format2(item.getSellPrice() * (item.getWeighingWeight() * -1 / item.getWeight()))) : (orderInfo.getTradeBillType() == 1 ? format2(item.getSellPrice() * item.getNum() - item.getPreferentialMoney()) : format2(item.getSellPrice() * item.getNum() * -1))
        }
      );
    }

    printer.addLine();

    printer.printTable(
      new int[]{16,16},
      new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
      new String[]{
        "原总计：",
        String.valueOf(orderInfo.getTradeBillType() == 1 ? orderInfo.getOrderMoney() : orderInfo.getOrderMoney() * -1)
      }
    );

    printer.addLine();

    String endString = "";
    if(isHeizuan){
      endString = orderInfo.getTradeBillType() == 1 ? "应付金额" : "应退金额";
    }else{
      endString = orderInfo.getTradeBillType() == 1 ? "实付金额" : "实退金额";
    }

    printer.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "10","6");
    printer.printTable(
      new int[]{12,12},
      new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
      new String[]{
        endString,
        String.valueOf(orderInfo.getTradeBillType() == 1 ? orderInfo.getOrderMoney() : orderInfo.getOrderMoney() * -1)
      }
    );

    printer.setNextFormat(ScriptConstant.NORMAL,ScriptConstant.NORMAL);

    printer.addLine();

    printer.text(ScriptConstant.LEFT, orderInfo.getTradeBillType() == 1 ? "支付信息：" : "退款方式：");

    if (orderInfo.getTradeBillType() == 1) {
      printer.printTable(
        new int[]{16, 16},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
        new String[]{
          "总计：" + orderInfo.getOrderMoney(),
          "包装费：" + orderInfo.getPackageMoney()
        }
      );

      printer.printTable(
        new int[]{16, 16},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
        new String[]{
          "服务费：" + orderInfo.getServiceFee(),
          "总优惠：" + orderInfo.getPreferentialMoney()
        }
      );

      printer.printTable(
        new int[]{16, 16},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
        new String[]{
          "应付：" + orderInfo.getShouldPayMoney(),
          "实付：" + orderInfo.getActualReceiveMoney()
        }
      );

      printer.printTable(
        new int[]{16, 16},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
        new String[]{
          "微信：" + orderInfo.getOrderPayInfo().getWeixinBarPayTotal() + orderInfo.getOrderPayInfo().getWxFacePayTotal() + orderInfo.getOrderPayInfo().getMiniweixinPayTotal(),
          "支付宝：" + orderInfo.getOrderPayInfo().getAliBarPayTotal()
        }
      );

      printer.printTable(
        new int[]{18, 14},
        new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT},
        new String[]{
          "现金:" + orderInfo.getOrderPayInfo().getCashReceiveMoney() + " 找零:" + orderInfo.getOrderPayInfo().getCashGiveBackMoney(),
          "储值：" + orderInfo.getOrderPayInfo().getCzPayTotal()
        }
      );

      // 鲜范卡
      List<CardListItem> cardListItems = orderInfo.getOrderPayInfo().getCardList();
      if (cardListItems.size() > 0) {
        for (CardListItem card : cardListItems) {
          printer.text(ScriptConstant.LEFT, "鲜范" + card.getClassifyType() + "卡：" + card.getTradeMoney());
        }
      }

      // 其他卡支付
      List<CouponPayInfosItem> couponPayInfosItems = orderInfo.getOrderPayInfo().getCouponPayInfos();
      if (couponPayInfosItems.size() > 0) {
        for (CouponPayInfosItem element : couponPayInfosItems) {
          printer.text(ScriptConstant.LEFT, element.getName() + ": " + element.getMoney());
        }
      }

      // 卡余额
      List<PayChannelListItem> payChannelListItems = orderInfo.getOrderPayInfo().getPayChannelList();
      if (payChannelListItems.size() > 0) {
        List<Map> cardBalancedList = new ArrayList<>();
        List<Double> xfBalance = new ArrayList<>();
        List<Double> czBalance = new ArrayList<>();

        for (PayChannelListItem channel : payChannelListItems) {
          Map<String, java.io.Serializable> cardInfo = new HashMap<>();
          if (channel.getChannelType().equals("04")) {
            Double balance = Double.parseDouble(channel.getXfEntityCardBalance());
            cardInfo.put("xfEntityCardBalance", balance);
            cardInfo.put("xfEntityCardNo", channel.getXfEntityCardNo());
            cardBalancedList.add(cardInfo);

            // 返回等于当前卡号的列表
            List<Map> snycBalances = new ArrayList<>();
            for (Map item : cardBalancedList) {
              if (item.containsValue(channel.getXfEntityCardNo())) {
                snycBalances.add(item);
              }
            }

            if (snycBalances.size() > 1) {
              for (Map item : cardBalancedList) {
                if (item.containsValue(channel.getXfEntityCardNo())) {
                  cardBalancedList.remove(item);
                }
              }

              // 按从大到小排序
              Collections.sort(snycBalances, (p1, p2) -> p1.get("xfEntityCardBalance") == p2.get("xfEntityCardBalance") ? 0 : ((Double) p1.get("xfEntityCardBalance") < (Double) p2.get("xfEntityCardBalance") ? 1 : -1));
              cardBalancedList.add(snycBalances.get(0));
            }

          }

          if (channel.getChannelType().equals("05")) {
            xfBalance.add(Double.parseDouble(channel.getXfBalance()));
          }
          if (channel.getChannelType().equals("09")) {
            czBalance.add(Double.parseDouble(channel.getCzBalance()));
          }
        }

        if (!cardBalancedList.isEmpty()) {
          for (Map item : cardBalancedList) {
            printer.text(ScriptConstant.LEFT, "卡号：" + item.get("xfEntityCardNo") + ", 余额：" + item.get("xfEntityCardBalance"));
          }
        }

        if (xfBalance.size() > 0) {
          printer.text(ScriptConstant.LEFT, "鲜范电子卡余额：" + Collections.min(xfBalance));
        }

        if (czBalance.size() > 0) {
          printer.text(ScriptConstant.LEFT, "储值余额：" + Collections.min(czBalance));
        }
      }
    }else{
      // 这里是打印退款信息
      // todo 这里需要进行空判断
      List<RefundPayChannelListItem> refundPayChannelListItems = orderInfo.getRefundOrderInfo().getRefundOrderPayRefundInfo().getRefundPayChannelList();
      for (RefundPayChannelListItem element: refundPayChannelListItems){
        printer.text(ScriptConstant.LEFT,channelType.get(element.getChannelType()) + ": -" +element.getRefundMoney());
      }
    }


    printer.emptyLines(1);

    printer.text(ScriptConstant.LEFT,"感谢光临,关注鲜范在线下单，送货上门");

    // 打印二维码
    printer.setQrqodeSize(4);
    printer.addQrcode(ScriptConstant.CENTER,"https://mp.weixin.qq.com/a/~~ijlvQrlK1O4~MQpoT5D1CIah18uDnFwvhQ~~");
    printer.emptyLines(1);
    if(orderInfo.getStatus() == 20 || orderInfo.getStatus() == 40) {
      if(isLinzhan){
        printer.text(ScriptConstant.CENTER, "账单编号：" + orderInfo.getStoreSequence());
        printer.emptyLines(1);
        printer.printTable(
          new int[]{16,16},
          new String[]{ScriptConstant.LEFT, ScriptConstant.LEFT},
          new String[]{
            "实付金额：" + orderInfo.getNetSalesMoney(),
            "赠券：" + orderInfo.getGiftMoney()
          }
        );
        printer.emptyLines(1);
      }
    }

    printer.text(ScriptConstant.LEFT, "门店电话：" + orderInfo.getStorePhoneNo());
    printer.text(ScriptConstant.LEFT, "门店地址：" + orderInfo.getStoreAddress());
    printer.emptyLines(1);

    String barcode = orderId.substring(orderId.length() - 12);

    printer.addBarcode(ScriptConstant.CENTER, barcode);
    printer.emptyLines(1);
    printer.emptyLines(1);

    return printer.getString();
  }



  /**
   * 鲜范卡支付打印
   **/
  public String eCardPay(Map printInfo) {
    String imageData = "data:base64;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4AAAAAAAAAAAAEJsICBkb3ViQG/gAAAAAAAAAAAAQnJkVFVudEYjUmx0AAAAAAAAAAAAAAAAQmxkIFVudEYjUmx0AAAAAAAAAAAAAAAAUnNsdFVudEYjUHhsQFIAAAAAAAAAAAAKdmVjdG9yRGF0YWJvb2wBAAAAAFBnUHNlbnVtAAAAAFBnUHMAAAAAUGdQQwAAAABMZWZ0VW50RiNSbHQAAAAAAAAAAAAAAABUb3AgVW50RiNSbHQAAAAAAAAAAAAAAABTY2wgVW50RiNQcmNAWQAAAAAAAAAAABBjcm9wV2hlblByaW50aW5nYm9vbAAAAAAOY3JvcFJlY3RCb3R0b21sb25nAAAAAAAAAAxjcm9wUmVjdExlZnRsb25nAAAAAAAAAA1jcm9wUmVjdFJpZ2h0bG9uZwAAAAAAAAALY3JvcFJlY3RUb3Bsb25nAAAAAAA4QklNA+0AAAAAABAASAAAAAEAAgBIAAAAAQACOEJJTQQmAAAAAAAOAAAAAAAAAAAAAD+AAAA4QklNBA0AAAAAAAQAAAAeOEJJTQQZAAAAAAAEAAAAHjhCSU0D8wAAAAAACQAAAAAAAAAAAQA4QklNJxAAAAAAAAoAAQAAAAAAAAACOEJJTQP1AAAAAABIAC9mZgABAGxmZgAGAAAAAAABAC9mZgABAKGZmgAGAAAAAAABADIAAAABAFoAAAAGAAAAAAABADUAAAABAC0AAAAGAAAAAAABOEJJTQP4AAAAAABwAAD/////////////////////////////A+gAAAAA/////////////////////////////wPoAAAAAP////////////////////////////8D6AAAAAD/////////////////////////////A+gAADhCSU0EAAAAAAAAAgABOEJJTQQCAAAAAAAEAAAAADhCSU0EMAAAAAAAAgEBOEJJTQQtAAAAAAAGAAEAAAACOEJJTQQIAAAAAAAQAAAAAQAAAkAAAAJAAAAAADhCSU0EHgAAAAAABAAAAAA4QklNBBoAAAAAA0cAAAAGAAAAAAAAAAAAAABpAAAAtAAAAAkAZgByAGUAcwBoAGYAYQBuAHMAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAAAAAAAAAAAALQAAABpAAAAAAAAAAAAAAAAAAAAAAEAAAAA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TQQhAAAAAABXAAAAAQEAAAAPAEEAZABvAGIAZQAgAFAAaABvAHQAbwBzAGgAbwBwAAAAFABBAGQAbwBiAGUAIABQAGgAbwB0AG8AcwBoAG8AcAAgADIAMAAyADAAAAABADhCSU0EBgAAAAAABwAIAAAAAQEA/+EOVGh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8APD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDggNzkuMTY0MDM2LCAyMDE5LzA4LzEzLTAxOjA2OjU3ICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgMjEuMCAoTWFjaW50b3NoKSIgeG1wOkNyZWF0ZURhdGU9IjIwMjEtMDUtMDdUMTE6MjI6NTErMDg6MDAiIHhtcDpNb2RpZnlEYXRlPSIyMDIxLTEwLTIyVDExOjQ3OjMyKzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDIxLTEwLTIyVDExOjQ3OjMyKzA4OjAwIiBkYzpmb3JtYXQ9ImltYWdlL2pwZWciIHBob3Rvc2hvcDpDb2xvck1vZGU9IjMiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDoxNzk0ZWExMC0yYjRiLTQyNmMtYTcyOS1mMzJkZThlZjg1ODciIHhtcE1NOkRvY3VtZW50SUQ9ImFkb2JlOmRvY2lkOnBob3Rvc2hvcDphYTRmMTg4MS0wNTEzLTlkNDMtOGUwMS1mY2ZkZmVmMjI5YzMiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpmYjYzMjAyNC1kNDc4LTRlOTAtYTc3Zi04Njc0MWM0YzlkYzEiPiA8eG1wTU06SGlzdG9yeT4gPHJkZjpTZXE+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJjcmVhdGVkIiBzdEV2dDppbnN0YW5jZUlEPSJ4bXAuaWlkOmZiNjMyMDI0LWQ0NzgtNGU5MC1hNzdmLTg2NzQxYzRjOWRjMSIgc3RFdnQ6d2hlbj0iMjAyMS0wNS0wN1QxMToyMjo1MSswODowMCIgc3RFdnQ6c29mdHdhcmVBZ2VudD0iQWRvYmUgUGhvdG9zaG9wIDIxLjAgKE1hY2ludG9zaCkiLz4gPHJkZjpsaSBzdEV2dDphY3Rpb249ImNvbnZlcnRlZCIgc3RFdnQ6cGFyYW1ldGVycz0iZnJvbSBpbWFnZS9wbmcgdG8gaW1hZ2UvanBlZyIvPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6MTc5NGVhMTAtMmI0Yi00MjZjLWE3MjktZjMyZGU4ZWY4NTg3IiBzdEV2dDp3aGVuPSIyMDIxLTEwLTIyVDExOjQ3OjMyKzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgMjEuMCAoTWFjaW50b3NoKSIgc3RFdnQ6Y2hhbmdlZD0iLyIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg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r/8A2O+/de69/wAPO/zRP+8ze1//AF1//sd9+6917/h53+aJ/wB5m9r/APrr/wD2O+/de62M/wC7n82T/hmz/Z0v9nB73/2ZTz/7MF/czTtr7f8A2V/7D7b+E/wn+7Gv+8f93P8Af7/eeW/8L/yLwef1e/de6//Q39DFEZVnMcZmSN4kmKKZVikZHkjWS2tY3eJSQDYlQT9B7917rJ7917r3v3Xuve/de697917r3v3Xuo1XRUeQgelr6SmraWQqXpquCKpgcowdC8MyPGxR1BFxwRf37r3TSNqbWVlZdtYAMjK6MMNjgyujBkdSKa6sjAEEcgj37r3T/wC/de697917r3v3Xuve/de697917pK1GxNkVdRPV1Wzdq1NVVTS1NTU1G3sRNUVFRPI0s8880lG0k000rlndiWZiSTc+/de6esZiMThaY0eGxmOxNIZWmNLjKKmoKYzOFV5TBSxRRGV1QAta5AH9PfuvdOHv3XuknLsHYs8sk8+y9pzTTSPLNNLtzDySyyyMXkkkkejLvI7kkkkkk3Pv3Xusf8Ao82B/wA8Ps//ANBnC/8A1F7917r3+jzYH/PD7P8A/QZwv/1F7917r3+jzYH/ADw+z/8A0GcL/wDUXv3Xuvf6PNgf88Ps/wD9BnC//UXv3Xuvf6PNgf8APD7P/wDQZwv/ANRe/de6Vnhh8P2/ij8Hj8Pg0L4fDp0eLx20ePRxpta3Hv3Xuv/R3+Pfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691/9Lf49+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3X/09/j37r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvdf/U3+Pfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691737r3Xvfuvde9+691/9k=";
    PrintScriptUtil psu = new PrintScriptUtil();
    psu.setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .addImage(ScriptConstant.CENTER, "180*105",imageData)
      .text(ScriptConstant.LEFT,"消费结果: " + (printInfo.get("status").toString().equals("1") ? "支付成功" : "退款成功"))
      .setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE)
      .text(ScriptConstant.LEFT,  (printInfo.get("status").toString().equals("1") ? "实付总额" : "退款总额") +": " +  printInfo.get("money").toString());

    if(printInfo.get("aCard") != null){
        psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "8", "6");
        psu.text("50", "A卡:" + printInfo.get("aCard").toString());
    }

    if(printInfo.get("bCard") != null){
      psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "8", "6");
      psu.text("50", "B卡:" + printInfo.get("bCard").toString());
    }

    if(printInfo.get("cCard") != null){
      psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "8", "6");
      psu.text("50", "C卡:" + printInfo.get("cCard").toString());
    }

    if(printInfo.get("oCard") != null){
      psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "8", "6");
      psu.text("50", printInfo.get("classifyName").toString() + ":" + printInfo.get("oCard").toString());
    }


    psu.setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "交易流水:" + printInfo.get("orderId"))
      .text(ScriptConstant.LEFT, "用户: " + printInfo.get("userName"))
      .text(ScriptConstant.LEFT, "消费时间：" + printInfo.get("orderTime"))
      .text(ScriptConstant.LEFT, "交易类型: " + printInfo.get("orderType"))
      .text(ScriptConstant.LEFT, "消费门店：" + printInfo.get("shopName"))
      .text(ScriptConstant.LEFT, "消费门店：" + printInfo.get("storeName"))
      .emptyLines(3);
    return psu.getString();
  }

  /**
   * 鲜范卡交易流水
   **/
  public String eCardPayList(Map printInfo) {
    List<Map> orderList = (List) printInfo.get("orderList");
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(currentTime);

    PrintScriptUtil psu = new PrintScriptUtil();
    psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.NORMAL)
      .text(ScriptConstant.CENTER,"交易记录清单")
      .emptyLines(1)
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "查询时间: " +  dateString)
      .text(ScriptConstant.LEFT, "统计时间: " +  printInfo.get("startTime") + "至" + printInfo.get("endTime"))
      .text(ScriptConstant.LEFT, "商家: " +  printInfo.get("shopName"))
      .text(ScriptConstant.LEFT, "门店: " +  printInfo.get("storeName"))
      .text(ScriptConstant.LEFT, "终端号: " + "4565434543")
      .text(ScriptConstant.LEFT, "交易笔数: " + printInfo.get("totalElements"))
      .text(ScriptConstant.LEFT, "交易总额: " +  printInfo.get("totalMoney"))
      .setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL);

    // 这里循环打印交易列表
    for(int i=0; i< orderList.size(); i++){
      psu.text(ScriptConstant.LEFT, "消费时间：" + orderList.get(i).get("orderTime"))
        .text(ScriptConstant.LEFT, "交易状态: " + orderList.get(i).get("status"))
        .text(ScriptConstant.LEFT, "交易金额：" + orderList.get(i).get("orderMoney"))
        .text(ScriptConstant.LEFT, "交易单号:" + orderList.get(i).get("orderId"));
    }

    psu.emptyLines(3);
    return psu.getString();
  }

  /**
   * 鲜范卡交易汇总
   **/
  public String eCardPayCount(Map printInfo) {
    List<Map> cardList = (List) printInfo.get("cardList");

    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(currentTime);

    PrintScriptUtil psu = new PrintScriptUtil();
    psu.setNextFormat(ScriptConstant.LARGE, ScriptConstant.NORMAL)
      .text(ScriptConstant.CENTER,"交易记录汇总")
      .emptyLines(1)
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "查询时间: " +  dateString)
      .text(ScriptConstant.LEFT, "统计时间: " +  printInfo.get("startTime") + "至" + printInfo.get("endTime"))
      .text(ScriptConstant.LEFT, "商家: " +  printInfo.get("shopName"))
      .text(ScriptConstant.LEFT, "门店: " +  printInfo.get("storeName"))
      .text(ScriptConstant.LEFT, "终端号: " + "4565434543")
      .setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "交易成功: " + printInfo.get("successOrderTotalNums") + "笔")
      .text(ScriptConstant.LEFT, "交易总额: " +  printInfo.get("successOrderTotalMoney") + "元");

    // 这里循环打印交易列表
    for(int i=0; i< cardList.size(); i++){
      psu.text(ScriptConstant.LEFT, cardList.get(i).get("name").toString() + ": " + cardList.get(i).get("totalMoney"));
    }

    psu.setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "退款笔数: " + printInfo.get("backOrderTotalNums") + "笔")
      .text(ScriptConstant.LEFT, "退款金额: " + printInfo.get("backOrderTotalMoney") + "元");

    psu.emptyLines(3);
    return psu.getString();
  }

}
