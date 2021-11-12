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
    super.initState();
  }

  // 打印
  Future<void> printTest() async {
    try {
      FlutterUnionpay.startPrint(4, {"aa":"baaa"});
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
                  printTest();
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
            ],
          ),

        ),
      ),
    );
  }
}
