package cn.fanchou.flutter_unionpay.utils;

import java.util.regex.Pattern;

public class PrintScriptUtil {
  private StringBuffer sBuffer = null;
  private Pattern pattern = null;

  public PrintScriptUtil() {
    this.sBuffer = new StringBuffer();
    this.pattern = Pattern.compile("[0-9]*");
  }

  public String getString() {
    return this.sBuffer.toString();
  }

  /**
   * 设置下一行或若干行的格式
   *
   * @param scaleCN 中文字体大小
   * @param scaleEN 西方字体大小
   **/
  public PrintScriptUtil setNextFormat(String scaleCN, String scaleEN) {
    this.sBuffer.append("!hz ").append(scaleCN).append("\n")
      .append("!asc ").append(scaleEN).append("\n");
    return this;
  }

  /**
   * 设置下一行或若干行的格式
   *
   * @param scaleCN 中文字体大小
   * @param scaleEN 西方字体大小
   * @param gray    灰度/浓度，区间[1，10]，文字粗细（对于只支持加粗的打印机进行如下操作：1~5为标准，6~10为加粗），默认5
   * @param yspace  行间距，区间[0, 60]，默认6
   **/
  public PrintScriptUtil setNextFormat(String scaleCN, String scaleEN, String gray, String yspace) {
    this.sBuffer.append("!hz ").append(scaleCN).append("\n")
      .append("!asc ").append(scaleEN).append("\n")
      .append("!gray ").append(gray).append("\n")
      .append("!yspace ").append(yspace).append("\n");
    return this;
  }


  /**
   * 设置二维码大小     *
   * @param size 二维码大小
   **/
  public PrintScriptUtil setQrqodeSize(int size) {
    this.sBuffer.append("!qrcode ").append(size + " 2").append("\n");
    return this;
  }

  /**
   * 插入一行文本
   *
   * @param layout 位置：居左、居中、居右或偏移量，偏移量区间为0~384如120
   * @param txt    文本
   **/
  public PrintScriptUtil addText(String layout, String txt) {
    return addContent("text", layout, txt);
  }

  /**
   * 插入一行带下划线的文本
   *
   * @param layout 位置：居左、居中、居右或偏移量，偏移量区间为0~384如120
   * @param txt    文本
   **/
  public PrintScriptUtil addUnderlineText(String layout, String txt) {
    return addContent("underline", layout, txt);
  }

  /**
   * 插入一个条形码（自动将字符串转化成条形码）
   *
   * @param layout 位置：居左、居中、居右或偏移量，偏移量区间为0~384如120
   * @param txt    希望转成条形码的字符串
   **/
  public PrintScriptUtil addBarcode(String layout, String txt) {
    return addContent("barcode", layout, txt);
  }

  /**
   * 插入一个二维码（自动将字符串转化成二维码）
   *
   * @param layout 位置：居左、居中、居右或偏移量，偏移量区间为0~384如120
   * @param txt    希望转成二维码的字符串
   **/
  public PrintScriptUtil addQrcode(String layout, String txt) {
    return addContent("qrcode", layout, txt);
  }

  /**
   * 插入一条分隔符
   **/
  public PrintScriptUtil addLine() {
    this.sBuffer.append("*line ").append("\n");
    return this;
  }

  /**
   * 插入一个图片
   *
   * @param layout 位置：居左、居中、居右或偏移量，偏移量区间为0~384如120
   * @param scale  图片尺寸，如284*81
   * @param img    图片数据(前缀为#logo:或data:或path:)
   *               #logo:寻找设备中标识为logo的图片数据
   *               data:基于bmp单色格式的图像数据，格式如下：data:数据编码;数据。其中：数据编码如下：base64示例如下：data:base64;iVBORw0KGgoAAAANSUhEUgAAAX8A...
   *               path:后面跟上所要打印png图片在安卓文件系统上的绝对地址，如：path：yz:95;/data/share/ys.png.如果有yz:域表示手动设置阈值，’yz:’后面为所需要设置的阈值，并以’;’结束，后面再跟上图片文件路径，没有’yz:’域则表示自动设置阈值。
   **/
  public PrintScriptUtil addImage(String layout, String scale, String img) {
    String layout_ = layout;
    if (pattern.matcher(layout_).matches()) {
      layout_ = "x:" + layout_;
    }
    this.sBuffer.append("*image").append(" ")
      .append(layout_).append(" ").append(scale).append(" ")
      .append(img).append("\n");
    return this;
  }

  /**
   * 进/退纸(按行数)正数为进纸，负数为退纸
   *
   * @param lines 行数
   **/
  public PrintScriptUtil addFeedline(int lines) {
    this.sBuffer.append("*feedline ").append(lines).append("\n");
    return this;
  }

  /**
   * 暂停指定的时间（适用场景：多联打印情况，先打商户联，再打用户联）
   *
   * @param seconds 秒数（单位秒）
   **/
  public PrintScriptUtil addpause(String seconds) {
    this.sBuffer.append("*pause ").append(seconds).append("\n");
    return this;
  }

  private PrintScriptUtil addContent(String type, String layout, String txt) {
    String layout_ = layout;
    if (pattern.matcher(layout_).matches()) {
      layout_ = "x:" + layout_;
    }
    this.sBuffer.append("*").append(type).append(" ")
      .append(layout_).append(" ")
      .append(txt).append("\n");
    return this;
  }

  public PrintScriptUtil addGray(String str) {
    this.sBuffer.append(" !gray ").append(str);
    return this;
  }

  public PrintScriptUtil addYspace(String str) {
    this.sBuffer.append(" !yspace ").append(str);
    return this;
  }

  public PrintScriptUtil addOther(String str) {
    this.sBuffer.append(str);
    return this;
  }
}
