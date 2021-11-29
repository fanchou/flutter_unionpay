package cn.fanchou.flutter_unionpay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import com.ums.AppHelper;
import com.ums.anypay.service.IOnTransEndListener;
import com.ums.upos.sdk.exception.CallServiceException;
import com.ums.upos.sdk.exception.SdkException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMessageCodec;

/** FlutterUnionpayPlugin */
public class FlutterUnionpayPlugin implements FlutterPlugin, MethodCallHandler, BasicMessageChannel.MessageHandler, ActivityAware {

  private final static String unionPayChannel = "freshFans/pos/unionPay";
  private BasicMessageChannel<Object> mMessageChannel;
  private static final String APPID = "880ff13a339749dda54efa40cfef3887";
  //appid是交易时必传参数，appid与app包名一一对应，可在银商开发者平台申请。

  private Handler uiThreadHandler = new Handler(Looper.getMainLooper());
  private Activity activity;
  private MethodChannel.Result callResult;
  String transAppName;
  String transAppId;
  private JSONObject transData = new JSONObject();
  private MethodChannel channel;
  private UnionPayDevice unionPayDevice;


  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    mMessageChannel = new BasicMessageChannel<>(flutterPluginBinding.getBinaryMessenger(), "scanner_channel", new StandardMessageCodec());
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), unionPayChannel);
    mMessageChannel.setMessageHandler(this);
    channel.setMethodCallHandler(this);
    try {
      transData.put("appId", APPID); //appId
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    callResult = result;
    unionPayDevice.setResult(result);
    switch (call.method) {
      case "sign":
        transAppName = "公共资源";
        transAppId = "签到";
        startCallTrans(transData);
        break;
      case "relief":
        transAppName = "公共资源";
        transAppId = "换班";
        startCallTrans(transData);
        break;
      case "bankPay":
        transAppName = "银行卡收款";
        transAppId = "消费";
        bankPay(call);
        startCallTrans(transData);
        break;
      case "scanPay":
        transAppName = "POS 通";
        transAppId = "扫一扫";
        scanPay(call);
        startCallTrans(transData);
        break;
      case "revokePay":
        transAppName = "公共资源";
        transAppId = "撤销";
        revokePay(call);
        startCallTrans(transData);
        break;
      case "checkBalance":
        transAppName = "公共资源";
        transAppId = "余额查询";
        startCallTrans(transData);
        break;
      case "transactionDetails":
        transAppName = "公共资源";
        transAppId = "交易明细";
        transactionDetails(call);
        startCallTrans(transData);
        break;
      case "returnGoods":
        transAppName = "公共资源";
        transAppId = "退货";
        returnGoods(call);
        startCallTrans(transData);
        break;
      case "deviceServiceLogin":
        unionPayDevice.deviceServiceLogin(activity);
        break;
      case "deviceServiceLogout":
        unionPayDevice.deviceServiceLogout();
        break;
      case "startPrint":
        Log.d("print","打印数据");
        Map printInfo = (Map) call.argument("printInfo");
        int type = (int) call.argument("type");
        try {
          unionPayDevice.startPrint(type, printInfo);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        break;
      default:
        result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
    mMessageChannel.setMessageHandler(null);
  }

  @Override
  public void onMessage(@Nullable Object message, @NonNull BasicMessageChannel.Reply reply) {
    Log.d("recive", "这里是否收到了数据");
    Map<Object, Object> arguments = (Map<Object, Object>) message;
    String methodName = (String) arguments.get("methodName");
    if(methodName.equals("startScanner")){
      try {
        startScanner();
      } catch (SdkException e) {
        e.printStackTrace();
      } catch (CallServiceException e) {
        e.printStackTrace();
      }
    }else if(methodName.equals("stopScanner")){
      try {
        stopScanner();
      } catch (SdkException e) {
        e.printStackTrace();
      } catch (CallServiceException e) {
        e.printStackTrace();
      }
    }else{
      return;
    }
  }

  /**
   * 所有的支付应用都通过callTrans调起
   **/
  private void startCallTrans(JSONObject transData) {
    // 所有的支付应用都通过callTrans调起
    AppHelper.callTrans(activity, transAppName, transAppId, transData, listener);
  }

  /**
   * 支付接口调用结果监听
   **/
  IOnTransEndListener listener = new IOnTransEndListener() {
    @Override
    public void onEnd(String reslutmsg) {
      Map<String, Object> params = new HashMap<>();
      try {
        //提取返回结果相关字段
        JSONObject resultData = new JSONObject(reslutmsg);
        Object appNameStr= resultData.get(AppHelper.TRANS_APP_NAME);
        Object bizIdStr = resultData.get(AppHelper.TRANS_BIZ_ID);
        Object resultCodeStr = resultData.get(AppHelper.RESULT_CODE);
        Object resultMsgStr = resultData.get(AppHelper.RESULT_MSG);

        if(resultCodeStr.equals("0")){
          Log.d("pay","接口调用成功");
          JSONObject transDataStr = resultData.getJSONObject(AppHelper.TRANS_DATA);
          if((transAppName.equals("银行卡收款") && transAppId.equals("消费")) // 支付回调
            || (transAppName.equals("POS 通") && transAppId.equals("扫一扫"))
          ) {
            payCallBack(transDataStr);
          }else if(transAppName.equals("公共资源") && transAppId.equals("交易明细")){ // 交易明细
            transactionDetailsCallBack(transDataStr);
          }else if(transAppName.equals("公共资源") && transAppId.equals("换班")){
            reliefCallback(transDataStr);
          }else if(transAppName.equals("公共资源") && transAppId.equals("余额查询")){
            checkBalance(transDataStr);
          }else if(transAppName.equals("公共资源") && transAppId.equals("签到")){
            signCallback(transDataStr);
          }else if(transAppName.equals("公共资源") && transAppId.equals("退货")){
            returnGoodsCallback(transDataStr);
          }

        }else if(resultCodeStr.equals("-1")){
          params.put("code", "40001");
          params.put("message", "未找到appName对应的支付应用");
          Log.d("pay","未找到appName对应的支付应用！");
          uiThreadHandler.post(() -> callResult.success(params));
        }else if(resultCodeStr.equals("-2")){
          params.put("code", "40002");
          params.put("message", "未找transId对应的业务");
          Log.d("pay","未找transId对应的业务！");
          uiThreadHandler.post(() -> callResult.success(params));
        }else if(resultCodeStr.equals("-3")){
          // todo -3”和-3表示交易结果返回失败，需要调用交易明细/重打印接口，并把交易凭证号设置为000000，
          //  可查询当前平台最后一笔交易的交易流水，并将查询到的平台最后一笔交易的extOrderNo和终端当前交易的extOrderNo做对比，
          //  如果相等，则说明交易已成功，不相等则说明交易失败（查询交易可在当前线程Handler中post一个Runnable运行或直接在新线程中运行）。
        }else{
          params.put("code", "40009");
          params.put("message", "未知错误");
          Log.d("pay","未知错误！");
          uiThreadHandler.post(() -> callResult.success(params));
        }
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
  };

  /**
   *  签到返回结果处理
   **/
  private void signCallback(JSONObject transDataStr) {
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","签到成功！");
        params.put("code", "200");
        params.put("message", "签到成功！");
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }


  /**
   *  标准支付
   **/
  private void bankPay(MethodCall methodCall) {
    try {
      String extOrderNo = methodCall.argument("extOrderNo");
      int money = methodCall.argument("money");
      transData.put("isNeedPrintReceipt", false);
      transData.put("extOrderNo", extOrderNo);
      transData.put("amt", money);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   *  标准支付
   **/
  private void scanPay(MethodCall methodCall) {
    try {
      String extOrderNo = methodCall.argument("extOrderNo");
      int money = methodCall.argument("money");
      transData.put("isNeedPrintReceipt", false);
      transData.put("extOrderNo", extOrderNo);
      transData.put("amt", money);
      transData.put("extToUlink", true);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }


  /**
   *  处理支付回调
   **/
  private void payCallBack(JSONObject transDataStr) throws JSONException {
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","支付成功！");
        params.put("code", "200");
        params.put("message", "支付成功！");
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   *  撤销支付，适用于是当天的订单
   **/
  private void revokePay(MethodCall methodCall) {
    try {
      String extOrderNo = methodCall.argument("extOrderNo");
      String useScan = methodCall.argument("useScan");
      if(useScan.equals("false")){
        // "true"：扫码撤销,下列参数无需再传；
        // "false"：普通撤销，需传入下列参数;
        String orgTraceNo = methodCall.argument("orgTraceNo");
        transData.put("orgTraceNo", orgTraceNo);
      }
      transData.put("isNeedPrintReceipt", false);
      transData.put("extOrderNo", extOrderNo);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  // 换班回调
  private void  reliefCallback(JSONObject transDataStr){
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","换班成功！");
        params.put("code", "200");
        params.put("message", "换班成功！");
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }


  // 余额查询回调
  private void checkBalance(JSONObject transDataStr) {
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","换班成功！");
        params.put("code", "200");
        params.put("message", "换班成功！");
        params.put("data", transDataStr.toString());
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }


  // 交易明细查询/重打印
  private void transactionDetails(MethodCall methodCall) {
    try {
      String extOrderNo = methodCall.argument("extOrderNo");
      String traceNo = methodCall.argument("traceNo");
      // 原交易凭证号
      // 若为000000，则重打印最后一笔交易信息，且为联机查询
      // （若只传traceNo表示只按traceNo查询交易流水明细，若同时传入extOrderNo，则以这两个参数为查询条件进行联合查询）
      boolean isNeedPrintReceipt = methodCall.argument("isNeedPrintReceipt");
      boolean isShowDetailPage = methodCall.argument("isShowDetailPage");
      transData.put("traceNo", traceNo);
      transData.put("extOrderNo", extOrderNo);
      transData.put("isNeedPrintReceipt", isNeedPrintReceipt);
      transData.put("isShowDetailPage", isShowDetailPage);
      // true表示调起交易明细页面；
      // false或者不存在时表示为重打印;
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  // 交易明细查询回调
  private void transactionDetailsCallBack(JSONObject transDataStr) throws JSONException {
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","支付明细查询成功");
        params.put("code", "200");
        params.put("message", "支付明细查询成功");
        params.put("data", transDataStr.toString());
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }

  // 退货
  private void returnGoods(MethodCall methodCall) {
    try {
      String extOrderNo = methodCall.argument("extOrderNo"); // 商户流水号
      String refNo = methodCall.argument("refNo"); // 原交易参考号
      boolean isNeedPrintReceipt = methodCall.argument("isNeedPrintReceipt");
      int amt = methodCall.argument("amt"); // 退款金额，整数分
      String date = methodCall.argument("data");
      String tradeYear = methodCall.argument("tradeYear");

      transData.put("extOrderNo", extOrderNo);
      transData.put("refNo", refNo);
      transData.put("isNeedPrintReceipt", isNeedPrintReceipt);
      transData.put("amt", amt);
      transData.put("useScan", false);
      transData.put("date", date);
      transData.put("tradeYear", tradeYear);

    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  // 退款回调
  private void returnGoodsCallback(JSONObject transDataStr) throws JSONException{
    Map<String, Object> params = new HashMap<>();
    try {
      String resCode = (String) transDataStr.get("resCode");
      String resDesc = (String) transDataStr.get("resDesc");
      if(resCode.equals("00")) {
        Log.d("pay","退货成功！");
        params.put("code", "200");
        params.put("message", "退货成功！");
        params.put("data", transDataStr.toString());
      }else{
        Log.d("pay failed", resDesc);
        params.put("code", "40000");
        params.put("message", resDesc);
      }
      uiThreadHandler.post(() -> callResult.success(params));
    }catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   *  开启摄像头
   */
  private void startScanner() throws SdkException, CallServiceException {
    unionPayDevice.startScan();
  }

  /**
   *  关闭摄像头
   */
  private void stopScanner() throws SdkException, CallServiceException {
    unionPayDevice.stopScan();
  }


  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
    unionPayDevice = new UnionPayDevice();
    unionPayDevice.setScannerChannel(mMessageChannel);
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

  }

  @Override
  public void onDetachedFromActivity() {
    try {
      unionPayDevice.stopScan();
    } catch (SdkException | CallServiceException e) {
      e.printStackTrace();
    }
  }
}
