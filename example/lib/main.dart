import 'package:flutter/material.dart';
import 'dart:async';
import 'package:flutter_unionpay/flutter_unionpay.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState(){
    FlutterUnionpay.deviceServiceLogin();
    // FlutterUnionpay.sign();
    super.initState();
  }

  // 打印
  Future<void> printTest() async {
    try {
      FlutterUnionpay.startPrint(88, {"aa":"baaa"});
    } catch(e){
      print("捕获到错误" + e.toString());
    }
  }

  // 外卖单
  String json = '{"orderId":"211116292662401429803008","orderMoney":40.0,"freightMoney":6.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.0,"packageMoney":0.0,"shouldPayMoney":46.0,"actualReceiveMoney":46.0,"remainReceiveMoney":0.0,"userId":522778,"userName":"15373351590","fullName":"","nickName":"wxz。","mobile":"153****1590","receiverMobileBackup":"15373351590","storeId":82,"storeName":"汇一城店","orderOperatorId":"","orderOperatorAccount":"小程序","orderOperatorFullName":"小程序","createTime":"2021-11-16 14:15:54","orderSourceType":2,"orderType":2,"tradeBillType":1,"orderRemark":"帮忙切片","buyerRemark":"帮忙切片","status":20,"brandList":[{"id":1,"name":"面包新语","nearbyStoreBrand":"BT"}],"storeAddress":"深圳市宝安中心区天虹购物中心一层L1003号铺","storePhoneNo":"0755-23712965","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[{"id":6047039,"orderId":"211116292662401429803008","goodsId":131,"goodsName":"真多杂粮","skuId":129,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":9.2,"sellPrice":23.0,"weight":0.0,"skuImg":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761270298杂粮吐司.jpg","num":1,"totalMoney":23.0,"preferentialMoney":0.0,"actualPayMoney":23.0,"refundedNum":0,"picUrl":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761217312杂粮吐司.jpg","weighingWeight":0.0},{"id":6047040,"orderId":"211116292662401429803008","goodsId":137,"goodsName":"(加购)北海道牛奶手撕吐司","skuId":135,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":8.0,"sellPrice":17.0,"weight":0.0,"skuImg":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761732486北海道.jpg","num":1,"totalMoney":17.0,"preferentialMoney":0.0,"actualPayMoney":17.0,"refundedNum":0,"picUrl":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761710803北海道.jpg","weighingWeight":0.0}],"goodsNum":2,"goodsTotal":40.0},"orderPayInfo":{"payChannelList":[{"subOrderId":"211116292662412389404672","channelType":"05","payMoney":"46.00","createTime":"2021-11-16 14:15:57","mobile":"153****1590","xfBalance":"0.00","xfEntityCardNo":"","xfEntityCardBalance":"","czBalance":""}],"miniUserBarPayTotal":0,"weixinBarPayTotal":0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":46.0,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":0,"couponPayInfos":[],"cardList":[{"classifyType":"A","tradeMoney":46.0}],"memberPoints":0},"orderDeliveryInfo":{"receiverAddress":"九方广场","receiverDetailAddress":"2号楼1601","deliveryDate":"2021-11-16","deliveryTimeInterval":"16:00-16:59(今天)","isSpeed":true,"receiverName":"王","receiverMobile":"15373351590","receiverMobileBackup":"15373351590","remark":"帮忙切片","takeCode":"37091","fullAddress":"广东省深圳市宝安区九方广场2号楼1601","courierName":"丁东峰","courierPhone":"13723408325","deliveryLocationInfo":{"distance":0.0,"shopDistance":1068.6,"deliveryLefTime":0,"riderLocation":"","shopLocation":{"longitude":"113.862951","latitude":"22.575819"},"userLocation":{"longitude":"113.869315","latitude":"22.583410","imgUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epGj5UCD3mgF4wIAbiaLEl8nlrXgMnJQKy69C2bvINssHMVBSq5TxxHdEdokyP7iccVdTFj0H1Nry2Q/132"},"status":50,"xfStatus":"","sfStatus":"","errMsg":"","courierName":"丁东峰","courierPhone":"13723408325","orderDeliveryType":1}},"orderSelfTakeInfo":"","refundOrderInfo":"","refundOrderInfos":[],"takeCode":"37091","seatNumber":"","storeSequence":"","netSalesMoney":40.0,"giftMoney":0.0}';
  // 门店买单
  String json1 = '{"orderId":"211116292722392333307904","orderMoney":42.0,"freightMoney":0.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.0,"packageMoney":0.0,"shouldPayMoney":42.0,"actualReceiveMoney":42.0,"remainReceiveMoney":0.0,"userId":111666,"userName":"15814083207","fullName":"","nickName":"小二子ʚિ.🌝.ીɞ","mobile":"158****3207","receiverMobileBackup":"","storeId":27,"storeName":"金光华店","orderOperatorId":24,"orderOperatorAccount":"hyjgh","orderOperatorFullName":"金光华HY","createTime":"2021-11-16 18:14:17","orderSourceType":1,"orderType":1,"tradeBillType":1,"orderRemark":"","buyerRemark":"","status":20,"brandList":[{"id":2,"name":"喜乳酪","nearbyStoreBrand":"HY"}],"storeAddress":"深圳市罗湖区南湖路和嘉宾路交汇处金光华广场负二楼B2-015A商铺(HEYYO)","storePhoneNo":"075582611495","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[{"id":6052145,"orderId":"211116292722392333307904","goodsId":519,"goodsName":"宝藏千层(猫山王)","skuId":1180,"typeValue":"","skuNames":"无规格","additionPropertyNames":"","costPrice":21.0,"sellPrice":42.0,"weight":110.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20200821/16e8ad47-9120-4c73-b65c-b9a18d1636ab.jpg","num":1,"totalMoney":42.0,"preferentialMoney":0.0,"actualPayMoney":42.0,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20200821/338e7a88-c72a-4757-b273-f7f48dbbd2e6.jpg","weighingWeight":0.0}],"goodsNum":1,"goodsTotal":42.0},"orderPayInfo":{"payChannelList":[{"subOrderId":"211116292722393004789760","channelType":"02","payMoney":"42.00","createTime":"2021-11-16 18:14:19","mobile":"","xfBalance":"","xfEntityCardNo":"","xfEntityCardBalance":"","czBalance":""}],"miniUserBarPayTotal":0,"weixinBarPayTotal":42.0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":0,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":0,"couponPayInfos":[],"cardList":"","memberPoints":0},"orderDeliveryInfo":"","orderSelfTakeInfo":{"selfTakeCode":"6897","selfTakeDate":"2021-11-16","isSpeed":true,"selfTakeTimeInterval":"(今天)","customerName":"","customerMobile":"","receiverMobileBackup":"","remark":"","customerMobileBackup":""},"refundOrderInfo":"","refundOrderInfos":[],"takeCode":"6897","seatNumber":"","storeSequence":"","netSalesMoney":42.0,"giftMoney":0.0}';

  // 自提订单
  String json2 = '{"orderId":"211116292713026351927296","orderMoney":29.9,"freightMoney":0.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.0,"packageMoney":0.0,"shouldPayMoney":29.9,"actualReceiveMoney":29.9,"remainReceiveMoney":0.0,"userId":1044745,"userName":"15012813623","fullName":"","nickName":"Comedy","mobile":"150****3623","receiverMobileBackup":"15012813623","storeId":27,"storeName":"金光华店","orderOperatorId":"","orderOperatorAccount":"小程序","orderOperatorFullName":"小程序","createTime":"2021-11-16 17:37:04","orderSourceType":2,"orderType":3,"tradeBillType":1,"orderRemark":"","buyerRemark":"","status":20,"brandList":[{"id":2,"name":"喜乳酪","nearbyStoreBrand":"HY"}],"storeAddress":"深圳市罗湖区南湖路和嘉宾路交汇处金光华广场负二楼B2-015A商铺(HEYYO)","storePhoneNo":"075582611495","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[{"id":6051067,"orderId":"211116292713026351927296","goodsId":1207,"goodsName":"【HY】迷你切片三件套29.9","skuId":4042,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":12.0,"sellPrice":29.9,"weight":0.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210319/ba8a0fba-ad7a-4a23-8f29-274b4b809f74.jpg","num":1,"totalMoney":29.9,"preferentialMoney":0.0,"actualPayMoney":29.9,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20210204/054cf2b0-72bd-441e-971f-0d6dbaa67ea7.jpg","weighingWeight":0.0},{"id":6051068,"orderId":"211116292713026351927296","goodsId":1073,"goodsName":"(加购)【HY】双重芝士mini","skuId":3789,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":6.0,"sellPrice":0.0,"weight":0.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210204/d3065797-15fd-4a89-9eae-0ee8f133fdec.jpg","num":1,"totalMoney":0.0,"preferentialMoney":0.0,"actualPayMoney":0.0,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20210204/e426d54d-d5f7-4de1-9f13-c4a487f29233.jpg","weighingWeight":0.0},{"id":6051069,"orderId":"211116292713026351927296","goodsId":1076,"goodsName":"(加购)【HY】芒果慕斯mini","skuId":3792,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":6.0,"sellPrice":0.0,"weight":0.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210204/9002e251-373c-4c3d-ab83-0a98aa0e123c.jpg","num":1,"totalMoney":0.0,"preferentialMoney":0.0,"actualPayMoney":0.0,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20210204/b7f75be2-919f-48e4-8932-a6d578634d7a.jpg","weighingWeight":0.0},{"id":6051070,"orderId":"211116292713026351927296","goodsId":1075,"goodsName":"(加购)【HY】蓝莓芝士mini","skuId":3791,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":6.0,"sellPrice":0.0,"weight":0.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210204/aa22bf1c-ee71-4e15-88e2-e0ae03e7e8df.jpg","num":1,"totalMoney":0.0,"preferentialMoney":0.0,"actualPayMoney":0.0,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20210204/4c122562-416c-4ac4-ac45-73a8879d6005.jpg","weighingWeight":0.0}],"goodsNum":4,"goodsTotal":29.9},"orderPayInfo":{"payChannelList":[{"subOrderId":"211116292713038292996096","channelType":"05","payMoney":"29.90","createTime":"2021-11-16 17:37:07","mobile":"150****3623","xfBalance":"0.00","xfEntityCardNo":"","xfEntityCardBalance":"","czBalance":""}],"miniUserBarPayTotal":0,"weixinBarPayTotal":0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":29.9,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":0,"couponPayInfos":[],"cardList":[{"classifyType":"A","tradeMoney":29.9}],"memberPoints":0},"orderDeliveryInfo":"","orderSelfTakeInfo":{"selfTakeCode":"3489","selfTakeDate":"2021-11-16","isSpeed":true,"selfTakeTimeInterval":"17:37-18:37(今天)","customerName":"","customerMobile":"15012813623","receiverMobileBackup":"","remark":"","customerMobileBackup":"15012813623"},"refundOrderInfo":"","refundOrderInfos":[],"takeCode":"3489","seatNumber":"","storeSequence":"","netSalesMoney":29.9,"giftMoney":0.0}';

  // 退款单
  String json3 = '{"orderId":"211113291673668756590592","orderMoney":63.8,"freightMoney":0.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.0,"packageMoney":0.0,"shouldPayMoney":63.8,"actualReceiveMoney":63.8,"remainReceiveMoney":0.0,"userId":"","userName":"","fullName":"","nickName":"","mobile":"","receiverMobileBackup":"","storeId":27,"storeName":"金光华店","orderOperatorId":24,"orderOperatorAccount":"hyjgh","orderOperatorFullName":"金光华HY","createTime":"2021-11-13 20:47:02","orderSourceType":1,"orderType":1,"tradeBillType":2,"orderRemark":"","buyerRemark":"","status":40,"brandList":[{"id":2,"name":"喜乳酪","nearbyStoreBrand":"HY"}],"storeAddress":"深圳市罗湖区南湖路和嘉宾路交汇处金光华广场负二楼B2-015A商铺(HEYYO)","storePhoneNo":"075582611495","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[],"goodsNum":0,"goodsTotal":0},"orderPayInfo":{"payChannelList":[],"miniUserBarPayTotal":0,"weixinBarPayTotal":0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":0,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":0,"couponPayInfos":[],"cardList":"","memberPoints":0},"orderDeliveryInfo":"","orderSelfTakeInfo":"","refundOrderInfo":{"orderRefundId":"211113291673668756590592","refundOperatorId":24,"refundOperatorAccount":"hyjgh","refundOperatorFullName":"金光华HY","refundMoney":63.8,"refundTime":"2021-11-13 20:47:02","originalOrderId":"211113291673511847809024","originalOrderMoney":63.8,"refundType":1,"saleafterType":2,"refundOrderPayRefundInfo":{"refundPayChannelList":[{"payRefundId":"211113291673668915974144","channelType":"02","mobile":"","refundMoney":"63.80","refundTime":"2021-11-13 20:47:02","xfEntityCardNo":""}]},"refundOrderGoodsInfo":{"goodsList":[{"id":80325,"orderId":"211113291673511847809024","goodsId":1067,"goodsName":"膳食平衡面包(藜麦)","skuId":3783,"skuNames":"无规格","additionPropertyNames":"","costPrice":10.0,"sellPrice":25.0,"weight":200.0,"num":1,"totalMoney":25.0,"preferentialMoney":0.0,"actualPayMoney":25.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210203/ee93f833-7d86-472a-a648-ec01334c4579.png","picUrl":"https://cdn.freshfans.cn/freshfans/20210203/06af1be7-6490-40f3-8137-00f2b3ea3d15.jpg"},{"id":80326,"orderId":"211113291673511847809024","goodsId":1067,"goodsName":"膳食平衡面包(藜麦)","skuId":3783,"skuNames":"无规格","additionPropertyNames":"","costPrice":10.0,"sellPrice":25.0,"weight":200.0,"num":1,"totalMoney":25.0,"preferentialMoney":0.0,"actualPayMoney":25.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210203/ee93f833-7d86-472a-a648-ec01334c4579.png","picUrl":"https://cdn.freshfans.cn/freshfans/20210203/06af1be7-6490-40f3-8137-00f2b3ea3d15.jpg"},{"id":80327,"orderId":"211113291673511847809024","goodsId":263,"goodsName":"乳酪软包","skuId":384,"skuNames":"无规格","additionPropertyNames":"","costPrice":6.5,"sellPrice":13.8,"weight":1.0,"num":1,"totalMoney":13.8,"preferentialMoney":0.0,"actualPayMoney":13.8,"skuImg":"https://cdn.freshfans.cn/freshfans/20200820/85187184-ac8e-4033-b515-5513e78249b9.jpg","picUrl":"https://cdn.freshfans.cn/freshfans/20200820/cc0687f1-6202-4a31-a794-2868a236a0bb.jpg"}]}},"refundOrderInfos":[{"orderRefundId":"211113291673668756590592","refundOperatorId":24,"refundOperatorAccount":"hyjgh","refundOperatorFullName":"金光华HY","refundMoney":63.8,"refundTime":"2021-11-13 20:47:02","originalOrderId":"211113291673511847809024","originalOrderMoney":63.8,"refundType":1,"saleafterType":2,"refundOrderPayRefundInfo":{"refundPayChannelList":[{"payRefundId":"211113291673668915974144","channelType":"02","mobile":"","refundMoney":"63.80","refundTime":"2021-11-13 20:47:02","xfEntityCardNo":""}]},"refundOrderGoodsInfo":{"goodsList":[{"id":80325,"orderId":"211113291673511847809024","goodsId":1067,"goodsName":"膳食平衡面包(藜麦)","skuId":3783,"skuNames":"无规格","additionPropertyNames":"","costPrice":10.0,"sellPrice":25.0,"weight":200.0,"num":1,"totalMoney":25.0,"preferentialMoney":0.0,"actualPayMoney":25.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210203/ee93f833-7d86-472a-a648-ec01334c4579.png","picUrl":"https://cdn.freshfans.cn/freshfans/20210203/06af1be7-6490-40f3-8137-00f2b3ea3d15.jpg"},{"id":80326,"orderId":"211113291673511847809024","goodsId":1067,"goodsName":"膳食平衡面包(藜麦)","skuId":3783,"skuNames":"无规格","additionPropertyNames":"","costPrice":10.0,"sellPrice":25.0,"weight":200.0,"num":1,"totalMoney":25.0,"preferentialMoney":0.0,"actualPayMoney":25.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210203/ee93f833-7d86-472a-a648-ec01334c4579.png","picUrl":"https://cdn.freshfans.cn/freshfans/20210203/06af1be7-6490-40f3-8137-00f2b3ea3d15.jpg"},{"id":80327,"orderId":"211113291673511847809024","goodsId":263,"goodsName":"乳酪软包","skuId":384,"skuNames":"无规格","additionPropertyNames":"","costPrice":6.5,"sellPrice":13.8,"weight":1.0,"num":1,"totalMoney":13.8,"preferentialMoney":0.0,"actualPayMoney":13.8,"skuImg":"https://cdn.freshfans.cn/freshfans/20200820/85187184-ac8e-4033-b515-5513e78249b9.jpg","picUrl":"https://cdn.freshfans.cn/freshfans/20200820/cc0687f1-6202-4a31-a794-2868a236a0bb.jpg"}]}}],"takeCode":"","seatNumber":"","storeSequence":"","netSalesMoney":-63.8,"giftMoney":0.0}';

  // 券支付
  String json4 = '{"orderId":"211116292697444625698816","orderMoney":34.34,"freightMoney":0.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.04,"packageMoney":0.0,"shouldPayMoney":34.3,"actualReceiveMoney":34.3,"remainReceiveMoney":0.0,"userId":"","userName":"","fullName":"","nickName":"","mobile":"","receiverMobileBackup":"","storeId":27,"storeName":"金光华店","orderOperatorId":24,"orderOperatorAccount":"hyjgh","orderOperatorFullName":"金光华HY","createTime":"2021-11-16 16:35:09","orderSourceType":1,"orderType":1,"tradeBillType":1,"orderRemark":"","buyerRemark":"","status":20,"brandList":[{"id":2,"name":"喜乳酪","nearbyStoreBrand":"HY"}],"storeAddress":"深圳市罗湖区南湖路和嘉宾路交汇处金光华广场负二楼B2-015A商铺(HEYYO)","storePhoneNo":"075582611495","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[{"id":6049485,"orderId":"211116292697444625698816","goodsId":1108,"goodsName":"优格杯","skuId":3864,"typeValue":"","skuNames":"无规格","additionPropertyNames":"","costPrice":8.0,"sellPrice":0.0,"weight":1.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20210302/778726d4-bded-43f5-b950-233fd0d26acc.jpg","num":1,"totalMoney":0.0,"preferentialMoney":0.0,"actualPayMoney":0.0,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20210302/1ab62487-1363-4901-9293-275687ef1401.jpg","weighingWeight":0.0},{"id":6049486,"orderId":"211116292697444625698816","goodsId":834,"goodsName":"优格现场买单【仅限现场买单使用】","skuId":2733,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":8.0,"sellPrice":8.0,"weight":50.0,"skuImg":"https://cdn.freshfans.cn/freshfans/20200923/41d3a42d-92e5-4a99-8ec1-86e5f2433398.jpg","num":1,"totalMoney":34.34,"preferentialMoney":0.04,"actualPayMoney":34.3,"refundedNum":0,"picUrl":"https://cdn.freshfans.cn/freshfans/20200923/4d236e4b-3688-4a72-bd81-9d83505a4cbc.jpg","weighingWeight":214.65}],"goodsNum":2,"goodsTotal":34.34},"orderPayInfo":{"payChannelList":[{"subOrderId":"211116292697445284073472","channelType":"11","payMoney":"34.30","createTime":"2021-11-16 16:35:09","mobile":"","xfBalance":"","xfEntityCardNo":"","xfEntityCardBalance":"","czBalance":""}],"miniUserBarPayTotal":0,"weixinBarPayTotal":0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":0,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":34.3,"couponPayInfos":[{"name":"一招过","id":464,"money":34.3,"giftMoney":""}],"cardList":"","memberPoints":0},"orderDeliveryInfo":"","orderSelfTakeInfo":{"selfTakeCode":"5140","selfTakeDate":"2021-11-16","isSpeed":true,"selfTakeTimeInterval":"(今天)","customerName":"","customerMobile":"","receiverMobileBackup":"","remark":"","customerMobileBackup":""},"refundOrderInfo":"","refundOrderInfos":[],"takeCode":"5140","seatNumber":"","storeSequence":"","netSalesMoney":34.3,"giftMoney":0.0}';

  // 打印订单测试
  Future<void> printOrder() async {
    try {
      FlutterUnionpay.startPrint(4, {"againBool": false, "orderInfo": json, "storeId": 96});
    } catch(e){
      print("捕获到错误" + e.toString());
    }
  }



  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> sanner() async {
    try {
      FlutterUnionpay.startScan();
      FlutterUnionpay.receiveMessage((scanResult) async {
        if(scanResult['code'] == '200'){
          print("扫码返回的值：" + scanResult['data']);
        }
      });

    } catch(e){
      print("捕获到错误" + e.toString());
    }
  }

  // 银联支付
  Future<void> pay() async {
    try {
      FlutterUnionpay.bankPay("54643454323432", 1);

    } catch(e){
      print("捕获到错误" + e.toString());
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: (){
                  printOrder();
                },
                child: const Text("打印测试"),
              ),
              const SizedBox(
                width: 20,
              ),
              ElevatedButton(
                onPressed: (){
                  sanner();
                },
                child: const Text("扫码测试"),
              ),
              const SizedBox(
                width: 20,
              ),
              ElevatedButton(
                onPressed: (){
                  pay();
                },
                child: const Text("扫码测试"),
              ),
            ],
          ),

        ),
      ),
    );
  }
}
