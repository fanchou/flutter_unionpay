
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterUnionpay {
  static const _unionPayChannel = MethodChannel("freshFans/pos/unionPay");
  static const scannerChannel = BasicMessageChannel('scanner_channel', StandardMessageCodec());

  /// 签到
  static Future<Map<String, dynamic>?> sign() async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('sign');
    return result;
  }

  /// 换班
  static Future<Map<String, dynamic>?> relief() async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('relief');
    return result;
  }

  /// 银行卡支付
  /// 金额的单位是整数，分
  static Future<Map<String, dynamic>?> bankPay(String extOrderNo, int money) async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('bankPay', {
      "extOrderNo": extOrderNo,
      "money":  money
    });
    return result;
  }

  /// 扫码支付
  /// 金额的单位是整数，分
  static Future<Map<String, dynamic>?> scanPay(String extOrderNo, int money) async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('scanPay', {
      "extOrderNo": extOrderNo,
      "money":  money
    });
    return result;
  }

  /// 撤销
  /// 仅限于今日的订单
  static Future<Map<String, dynamic>?> revokePay(String extOrderNo, String orgTraceNo) async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('revokePay', {
      "extOrderNo": extOrderNo,
      "useScan":  false,
      "orgTraceNo": orgTraceNo
    });
    return result;
  }

  /// 余额查询
  static Future<Map<String, dynamic>?> checkBalance() async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('checkBalance');
    return result;
  }

  /// 交易明细
  static Future<Map<String, dynamic>?> transactionDetails(String extOrderNo, String traceNo, bool isNeedPrintReceipt, bool isShowDetailPage) async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('transactionDetails', {
      "extOrderNo": extOrderNo,
      "traceNo":  traceNo,
      "isNeedPrintReceipt": isNeedPrintReceipt,
      "isShowDetailPage": isShowDetailPage
    });
    return result;
  }

  /// 退货
  static Future<Map<String, dynamic>?> returnGoods(String extOrderNo, String refNo, bool isNeedPrintReceipt, int amt, String date, String tradeYear) async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('returnGoods', {
      "extOrderNo": extOrderNo,
      "refNo":  refNo,
      "isNeedPrintReceipt": isNeedPrintReceipt,
      "amt": amt,
      "date": date,
      "tradeYear": tradeYear
    });
    return result;
  }

  /// 设备登陆
  static Future<Map<String, dynamic>?> deviceServiceLogin() async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('deviceServiceLogin');
    return result;
  }

  /// 设备登出
  static Future<Map<String, dynamic>?> deviceServiceLogout() async {
    final Map<String, dynamic>? result = await _unionPayChannel.invokeMapMethod('deviceServiceLogout');
    return result;
  }


  /// 启动摄像头
  static Future startScan() async {
    // todo 这里需要注册设备，返回结果后需要注销设备
    Map<String, dynamic>? result = await deviceServiceLogin();
    if(result!['code'] == "200"){
      return await scannerChannel.send({'methodName': 'startScanner'});
    }
  }

  /// 监听扫码返回结果
  static Future receiveMessage(Function callBack) async{
    scannerChannel.setMessageHandler((result) async {
      callBack(result);
      deviceServiceLogout();
      return result;
    });
  }

  /// 关闭摄像头
  static Future<Map<String, dynamic>?> stopScan() async {
    final Map<String, dynamic>? result = (await scannerChannel.send({"methodName": "stopScanner"})) as Map<String, dynamic>?;
    return result;
  }

  /// 开始打印
  /// todo 异常情况的处理，不然会导致打印机不响应的问题
  /// todo 考虑是否需要提前初始化设备
  static void startPrint(int type, Map printInfo) async {
    // Map<String, dynamic>? result = await deviceServiceLogin();
    // if(result!['code'] == "200"){
    //   print("设备注册成功");
    //   Map<String, dynamic>? printResult = await _unionPayChannel.invokeMapMethod('startPrint',{
    //     "printInfo": printInfo,
    //     "type": type
    //   });
    //   if(printResult!['code'] == '200'){
    //     await deviceServiceLogout();
    //   }
    // }
    Map<String, dynamic>? printResult = await _unionPayChannel.invokeMapMethod('startPrint',{
      "printInfo": printInfo,
      "type": type
    });
  }
}
