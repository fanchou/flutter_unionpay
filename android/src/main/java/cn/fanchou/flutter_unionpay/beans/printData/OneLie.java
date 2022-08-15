package cn.fanchou.flutter_unionpay.beans.printData;

import java.util.List;

public class OneLie {
    /**
     * type : 1
     * txtArr : []
     * table : {"txt":[],"width":[],"align":[]}
     */

    private String type;
    private TableBean table;
    private List<?> txtArr;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TableBean getTable() {
        return table;
    }

    public void setTable(TableBean table) {
        this.table = table;
    }

    public List<?> getTxtArr() {
        return txtArr;
    }

    public void setTxtArr(List<?> txtArr) {
        this.txtArr = txtArr;
    }

    public static class TableBean {
        private List<?> txt;
        private List<?> width;
        private List<?> align;

        public List<?> getTxt() {
            return txt;
        }

        public void setTxt(List<?> txt) {
            this.txt = txt;
        }

        public List<?> getWidth() {
            return width;
        }

        public void setWidth(List<?> width) {
            this.width = width;
        }

        public List<?> getAlign() {
            return align;
        }

        public void setAlign(List<?> align) {
            this.align = align;
        }
    }
}
