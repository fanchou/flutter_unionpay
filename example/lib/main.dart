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

  String json = '{"orderId":"211116292662401429803008","orderMoney":40.0,"freightMoney":6.0,"isAddServiceFee":false,"serviceFeePercent":0.0,"serviceFee":0.0,"preferentialMoney":0.0,"packageMoney":0.0,"shouldPayMoney":46.0,"actualReceiveMoney":46.0,"remainReceiveMoney":0.0,"userId":522778,"userName":"15373351590","fullName":"","nickName":"wxz。","mobile":"153****1590","receiverMobileBackup":"15373351590","storeId":82,"storeName":"汇一城店","orderOperatorId":"","orderOperatorAccount":"小程序","orderOperatorFullName":"小程序","createTime":"2021-11-16 14:15:54","orderSourceType":2,"orderType":2,"tradeBillType":1,"orderRemark":"帮忙切片","buyerRemark":"帮忙切片","status":20,"brandList":[{"id":1,"name":"面包新语","nearbyStoreBrand":"BT"}],"storeAddress":"深圳市宝安中心区天虹购物中心一层L1003号铺","storePhoneNo":"0755-23712965","isSelfHelp":false,"orderGoodsInfo":{"goodsList":[{"id":6047039,"orderId":"211116292662401429803008","goodsId":131,"goodsName":"真多杂粮","skuId":129,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":9.2,"sellPrice":23.0,"weight":0.0,"skuImg":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761270298杂粮吐司.jpg","num":1,"totalMoney":23.0,"preferentialMoney":0.0,"actualPayMoney":23.0,"refundedNum":0,"picUrl":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761217312杂粮吐司.jpg","weighingWeight":0.0},{"id":6047040,"orderId":"211116292662401429803008","goodsId":137,"goodsName":"(加购)北海道牛奶手撕吐司","skuId":135,"typeValue":"","skuNames":"","additionPropertyNames":"","costPrice":8.0,"sellPrice":17.0,"weight":0.0,"skuImg":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761732486北海道.jpg","num":1,"totalMoney":17.0,"preferentialMoney":0.0,"actualPayMoney":17.0,"refundedNum":0,"picUrl":"https://freshfans001.oss-cn-shenzhen.aliyuncs.com/freshfans/1586761710803北海道.jpg","weighingWeight":0.0}],"goodsNum":2,"goodsTotal":40.0},"orderPayInfo":{"payChannelList":[{"subOrderId":"211116292662412389404672","channelType":"05","payMoney":"46.00","createTime":"2021-11-16 14:15:57","mobile":"153****1590","xfBalance":"0.00","xfEntityCardNo":"","xfEntityCardBalance":"","czBalance":""}],"miniUserBarPayTotal":0,"weixinBarPayTotal":0,"aliBarPayTotal":0,"xfEntityCardPayTotal":0,"xfElectronCardPayTotal":46.0,"cashPayTotal":0,"cashReceiveMoney":0,"cashGiveBackMoney":0,"miniweixinPayTotal":0,"liShePayTotal":0,"wxFacePayTotal":0,"czPayTotal":0,"couponPayTotal":0,"couponPayInfos":[],"cardList":[{"classifyType":"A","tradeMoney":46.0}],"memberPoints":0},"orderDeliveryInfo":{"receiverAddress":"九方广场","receiverDetailAddress":"2号楼1601","deliveryDate":"2021-11-16","deliveryTimeInterval":"16:00-16:59(今天)","isSpeed":true,"receiverName":"王","receiverMobile":"15373351590","receiverMobileBackup":"15373351590","remark":"帮忙切片","takeCode":"37091","fullAddress":"广东省深圳市宝安区九方广场2号楼1601","courierName":"丁东峰","courierPhone":"13723408325","deliveryLocationInfo":{"distance":0.0,"shopDistance":1068.6,"deliveryLefTime":0,"riderLocation":"","shopLocation":{"longitude":"113.862951","latitude":"22.575819"},"userLocation":{"longitude":"113.869315","latitude":"22.583410","imgUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epGj5UCD3mgF4wIAbiaLEl8nlrXgMnJQKy69C2bvINssHMVBSq5TxxHdEdokyP7iccVdTFj0H1Nry2Q/132"},"status":50,"xfStatus":"","sfStatus":"","errMsg":"","courierName":"丁东峰","courierPhone":"13723408325","orderDeliveryType":1}},"orderSelfTakeInfo":"","refundOrderInfo":"","refundOrderInfos":[],"takeCode":"37091","seatNumber":"","storeSequence":"","netSalesMoney":40.0,"giftMoney":0.0}';


  // 打印订单测试
  Future<void> printOrder() async {
    try {
      FlutterUnionpay.startPrint(4, {"againBool": false, "orderInfo": json, "storeId": 74});
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
