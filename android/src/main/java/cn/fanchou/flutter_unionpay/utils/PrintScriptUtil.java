package cn.fanchou.flutter_unionpay.utils;

import com.ums.upos.sdk.system.BaseSystemManager;
import com.ums.upos.sdk.system.ModuleEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import io.flutter.Log;

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
  public PrintScriptUtil text(String layout, String txt) {
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
    if(isX970()){
      text("l","--------------------------------");
    }else{
      this.sBuffer.append("*line ").append("\n");
    }
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
  public PrintScriptUtil emptyLines(int lines) {
    if(isX970()){
      text("l","");
    }else{
      this.sBuffer.append("*feedline ").append(lines).append("\n");
    }

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

  /**
   * 打印表格
   * @param columnWidths 列的宽度
   *  @param columnAligns  列的对齐方式
   * @param columnTexts  列的内容
   *
   * @return*/
  public PrintScriptUtil printTable(int[] columnWidths, String[] columnAligns, String[] columnTexts) {
    if(columnWidths.length != columnTexts.length || columnWidths.length != columnAligns.length ){
      Log.d("printError", "COLUMN_WIDTHS_ALIGNS_AND_TEXTS_NOT_MATCH");
      return null;
    }

    int totalLen = 0;
    for(int i=0; i<columnWidths.length; i++){
      totalLen += columnWidths[i];
    }

    int maxLen = 384; // 58mm
    if(totalLen > maxLen){
      Log.d("printError","COLUNM_WIDTHS_TOO_LARGE" + totalLen);
      return null;
    }

    List<List<String>> table = new ArrayList<List<String>>();

    /**splits the column text to few rows and applies the alignment **/
    int padding = 1;
    for(int i=0; i< columnWidths.length; i++){
      int width = columnWidths[i] - padding; //1 char padding
      String text = String.copyValueOf(columnTexts[i].toCharArray());
      List<ColumnSplitedString> splited = new ArrayList<ColumnSplitedString>();
      int shorter = 0;
      int counter = 0;
      StringBuilder temp = new StringBuilder();
      for(int c=0; c<text.length(); c++){
        char ch = text.charAt(c);
        int l = isChinese(ch) ? 2 : 1;
        if (l==2){
          shorter++;
        }
        temp.append(ch);

        if(counter+l < width){
          counter = counter + l;
        }else{
          splited.add(new ColumnSplitedString(shorter, temp.toString()));
          temp = new StringBuilder();
          counter=0;
          shorter=0;
        }
      }
      if(temp.length()>0) {
        splited.add(new ColumnSplitedString(shorter, temp.toString()));
      }
      String align = columnAligns[i];

      List<String> formated = new ArrayList<String>();
      for(ColumnSplitedString s: splited){
        StringBuilder empty = new StringBuilder();
        for(int w=0; w<(width+padding-s.getShorter()); w++){
          empty.append(" ");
        }
        int startIdx = 0;
        String ss = s.getStr();
        if(align.equals(ScriptConstant.CENTER) && ss.length()<(width-s.getShorter())){
          startIdx = (width-s.getShorter()-ss.length())/2;
          if(startIdx+ss.length()>width-s.getShorter()){
            startIdx--;
          }
          if(startIdx<0){
            startIdx=0;
          }
        }else if(align.equals(ScriptConstant.RIGHT) && ss.length()<(width-s.getShorter())){
          startIdx =width - s.getShorter()-ss.length();
        }
        Log.d("printError","empty.replace("+startIdx+","+(startIdx+ss.length())+","+ss+")");
        empty.replace(startIdx,startIdx+ss.length(),ss);
        formated.add(empty.toString());
      }
      table.add(formated);
    }


    /**  try to find the max row count of the table **/
    int maxRowCount = 0;
    for(int i=0;i<table.size()/*column count*/;i++){
      List<String> rows = table.get(i); // row data in current column
      if(rows.size()>maxRowCount){maxRowCount = rows.size();}// try to find the max row count;
    }

    /** loop table again to fill the rows **/
    StringBuilder[] rowsToPrint = new StringBuilder[maxRowCount];
    for(int column=0;column<table.size()/*column count*/;column++){
      List<String> rows = table.get(column); // row data in current column
      for(int row=0;row<maxRowCount;row++){
        if(rowsToPrint[row]==null){
          rowsToPrint[row] = new StringBuilder();
        }
        if(row<rows.size()){
          //got the row of this column
          rowsToPrint[row].append(rows.get(row));
        }else{
          int w =columnWidths[column];
          StringBuilder empty = new StringBuilder();
          for(int i=0;i<w;i++){
            empty.append(" ");
          }
          rowsToPrint[row].append(empty.toString());//Append spaces to ensure the format
        }
      }
    }

    /** loops the rows and print **/
    for(int i=0;i<rowsToPrint.length;i++){
      rowsToPrint[i].append("\n\r");//wrap line..
      try {
        String aligns;
        if(i > columnAligns.length){
          aligns = columnAligns[0];
        }else {
          aligns = columnAligns[i];
        }
        text(aligns, rowsToPrint[i].toString());
      }catch (Exception e){
        e.printStackTrace();
      }
    }

    return this;
  }

  private static class ColumnSplitedString{
    private int shorter;
    private String str;

    public ColumnSplitedString(int shorter, String str) {
      this.shorter = shorter;
      this.str = str;
    }

    public int getShorter() {
      return shorter;
    }

    public String getStr() {
      return str;
    }
  }

  // 根据Unicode编码完美的判断中文汉字和符号
  private static boolean isChinese(char c) {
    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
      || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
      || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
      || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
      || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
      || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
      || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
      return true;
    }
    return false;
  }

  // 判断特定的设备
  private boolean isX970(){
    boolean isX970Device = false;
    try {
      Map<String, String> deviceInfo = BaseSystemManager.getInstance().getDeviceInfo();
      Log.d("printer======>", deviceInfo.toString());
      if ((deviceInfo.get(ModuleEnum.VENDOR).equals("VERIFONE")
        || deviceInfo.get(ModuleEnum.MODEL).equals("X970")
        || deviceInfo.get(ModuleEnum.MODEL).equals("X990"))
        && deviceInfo.get(ModuleEnum.SERVICE_VER).compareTo("1.0.21") < 0
      ) {
        isX970Device = true;
      }
    }catch (Exception ignored){}

    return isX970Device;
  }

}
