package cn.fanchou.flutter_unionpay;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.ums.upos.sdk.exception.CallServiceException;
import com.ums.upos.sdk.exception.SdkException;
import com.ums.upos.sdk.printer.OnPrintResultListener;
import com.ums.upos.sdk.printer.PrinterManager;
import com.ums.upos.sdk.scanner.OnScanListener;
import com.ums.upos.sdk.scanner.ScannerConfig;
import com.ums.upos.sdk.system.BaseSystemManager;
import com.ums.upos.uapi.ServiceResult;
import com.ums.upos.sdk.scanner.ScannerManager;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import cn.fanchou.flutter_unionpay.utils.PrintModels;
import cn.fanchou.flutter_unionpay.utils.PrintScriptUtil;
import cn.fanchou.flutter_unionpay.utils.ScriptConstant;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodChannel;

public class UnionPayDevice {

  private ScannerManager scannerManager;
  private MethodChannel.Result result;
  private BasicMessageChannel<Object> scannerChannel;
  private Handler uiThreadHandler = new Handler(Looper.getMainLooper());
  Map<String, Object> params = new HashMap<>();
  private Activity activity;

  /**
   * 设备硬件登录
   * */
  public void deviceServiceLogin(Activity a) {
    try {
      activity = a;
      BaseSystemManager.getInstance().deviceServiceLogin(
        activity, null, "99999999",//设备ID，填写任意8位数字
        resCode -> {//arg0具体可参考常量类ServiceResult
          if (ServiceResult.Success == resCode || ServiceResult.LOGIN_SUCCESS_NOT_EMV_FILE == resCode || ServiceResult.LOGIN_SUCCESS == resCode) {
            Log.d("deviceLogin","设备注册成功");
//            try {
//              initScanner();
//            } catch (SdkException e) {
//              e.printStackTrace();
//            } catch (CallServiceException e) {
//              e.printStackTrace();
//            }
            params.put("code", "200");
            params.put("message", "设备注册成功！");
            uiThreadHandler.post(() -> result.success(params));
          }
        });
    } catch (SdkException e) {
      e.printStackTrace();
    }
  }

  /**
   * 设备硬件登出
   * */
  public void deviceServiceLogout() {
    try {
      BaseSystemManager.getInstance().deviceServiceLogout();
    } catch (SdkException e) {
      e.printStackTrace();
    }
  }

  /**
   * 初始化摄像头
   **/
  private void initScanner() throws SdkException, CallServiceException {
    scannerManager = new ScannerManager();
    Bundle bundle = new Bundle();
    bundle.putInt(ScannerConfig.COMM_SCANNER_TYPE, 1);
    bundle.putBoolean(ScannerConfig.COMM_ISCONTINUOUS_SCAN, false);
    scannerManager.initScanner(bundle);
  }

  /**
   * 开启摄像头
   */
  public void startScan() throws SdkException, CallServiceException {
    Log.d("start","开启摄像头来自flutter的消息");
    scannerManager.startScan(30000, listener);
  }


  public void setScannerChannel(BasicMessageChannel<Object> scanner){
    this.scannerChannel = scanner;
  }

  public void setResult(MethodChannel.Result result) {
    this.result = result;
  }

  /**
   * 关闭摄像头
   */
  public void stopScan() throws SdkException, CallServiceException {
    try {
      if (scannerManager != null){
        scannerManager.stopScan();
      }
    }catch (SdkException | CallServiceException e) {
      e.printStackTrace();
    }
  }

  /**
   * 监听摄像头
   */
  private OnScanListener listener = new OnScanListener() {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onScanResult(int i, byte[] bytes) {

      // todo 处理摄像头返回结果
      if (bytes != null && !bytes.equals("")) {
        params.put("code", "200");
        params.put("message", "扫码成功");
        params.put("data", new String(bytes, StandardCharsets.UTF_8));
        // 这里可能会调用多次，会导致问题，此处采用BasicMessageChannel,支持双向多次通讯
        uiThreadHandler.post(() -> scannerChannel.send(params));
      }
    }
  };

  /**
   * 打印测试
   * todo 通过json传递打印数据，解析后在Android这边集体打印
   * */
  private String buildText() {
    //插入图片方式一：提前将图片转换成固定base64串，节省图片转base64时间，提高打印速度
    String imageData = "data:base64;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";
    //插入图片方式二：运行时再转换成base64
    //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ums);
    //String imageData = "data:base64;"+Base64Util.bitmapToBase64(bitmap);
    PrintScriptUtil psu = new PrintScriptUtil();
    psu.setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .addImage(ScriptConstant.CENTER, "284*81",imageData)
      .text(ScriptConstant.LEFT,"商户名称:银行卡商户")
      .text(ScriptConstant.LEFT, "商户编号:898330160120021")
      .text(ScriptConstant.LEFT, "终端编号:05315830")
      .text(ScriptConstant.LEFT, "班次号:201705070001 操作员号:001")
      .text(ScriptConstant.LEFT, "发卡行:浦发银行  收单行:银联商务")
      .text(ScriptConstant.LEFT, "有效期:30/11")
      .text(ScriptConstant.LEFT, "卡号:(借)")
      .setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE)
      .text(ScriptConstant.LEFT, "6225 2101 1521 2491/S")
      .text(ScriptConstant.LEFT, "交易类型:预授权")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "批次号:001281")
      .text(ScriptConstant.LEFT, "凭证号:002135  授权码:118525")
      .text(ScriptConstant.LEFT, "参考号:203009363026")
      .text(ScriptConstant.LEFT, "交易日期:2017/05/07 20:30:09")
      .text(ScriptConstant.LEFT, "金额:")
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"商品","数量","金额"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","3","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","4","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","5","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .printTable(new int[]{16,8,8}, new String[]{ScriptConstant.LEFT, ScriptConstant.RIGHT, ScriptConstant.RIGHT}, new String[]{"定制开发我是比较长的位置你稍微看看是不是这样?","32000","32000"})
      .setNextFormat(ScriptConstant.LARGE, ScriptConstant.LARGE, "8", "6")
      .text("50", "RMB:10.00")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.LARGE)
      .text(ScriptConstant.LEFT, "备 注: 重打印 ")
      .setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.NORMAL, ScriptConstant.NORMAL)
      .text(ScriptConstant.LEFT, "持卡人签名: ")
      .text(ScriptConstant.LEFT, " ")
      .text(ScriptConstant.LEFT, " ")
      .setNextFormat(ScriptConstant.SMALL_NORMAL, ScriptConstant.SMALL_NORMAL)
      .text(ScriptConstant.CENTER, "...............................................")
      .setNextFormat(ScriptConstant.SMALL, ScriptConstant.SMALL)
      .text(ScriptConstant.LEFT, "本人确认以上交易，同意将其计入本卡账户")
      .text(ScriptConstant.LEFT, "I ACKNOWLEDGE SATISFACTORY RECEIPT OF RELATIVE GOODS/SERVICES")
      .addQrcode(ScriptConstant.CENTER, "测试二维码").setQrqodeSize(100);
    return psu.getString();
  }

  /**
   * 开始打印
   **/
  public void startPrint(int type, Map printInfo) throws ParseException {
    PrinterManager manage = new PrinterManager();
    PrintModels model = new PrintModels();
    String text;
    // 这里传递不同的打印类型，然后打印不同的模板
    switch (type) {
      case 1:
        text = model.eCardPay(printInfo);
        break;
      case 2:
        text = model.eCardPayList(printInfo);
        break;
      case 3:
        text = model.eCardPayCount(printInfo);
        break;
      case 4:
        text = model.orderInfo(printInfo);
        break;
      case 5:
        text = model.handingInfo(printInfo);
        break;
      case 6:
        text = model.operateSumPrint(printInfo);
        break;
      case 7:
        text = model.goodsStatisPrint(printInfo);
        break;
      case 8:
        text = model.goodsDamagePrint(printInfo);
        break;
      case 9:
        text = model.mtOrderInfo(printInfo);
        break;
      case 10:
        text = model.printDateCashierInfo(printInfo);
        break;
      case 11:
        text = model.orderGoodsSummary(printInfo);
        break;
      default:
        text = buildText();
    }

    try {
      manage.initPrinter();
      manage.setPrnScript(text, "384");
      manage.startPrint(new OnPrintResultListener() {
        @Override
        public void onPrintResult(int resCode) {//arg0具体可参考常量类ServiceResult
          //打印完成主动登出，避免持续占用设备硬件
//          params.put("code", "200");
//          params.put("message", "打印完成！");
//          uiThreadHandler.post(() -> result.success(params));

          // todo 换成BasicMessageChannel的形式

          if(resCode < 0) {
            deviceServiceLogout();
            deviceServiceLogin(activity);
          }

          Log.d("printInfo", "==============" + resCode);
        }

      });
    } catch (CallServiceException e) {
      e.printStackTrace();
      deviceServiceLogout();
      deviceServiceLogin(activity);
    } catch (SdkException e) {
      deviceServiceLogout();
      deviceServiceLogin(activity);
      e.printStackTrace();
    }
  }

}
