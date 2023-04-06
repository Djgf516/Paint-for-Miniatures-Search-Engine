package models;


public class InfoPaint {


    //------------------------------------------------------------
    // Holds Brand Name and models.Paint Information
    //------------------------------------------------------------


    private String paintName;
    private String brandName;
    private String hexColorCode;
    private String matchValue;

    public InfoPaint(String paintName) {
        this.paintName = paintName;
    }

    public InfoPaint(String paintName, String brandName) {
        this.paintName = paintName;
        this.brandName = brandName;
    }

    public InfoPaint(String paintName, String brandName, String hexColorCode) {
        this.paintName = paintName;
        this.brandName = brandName;
        this.hexColorCode = hexColorCode;
    }

    public InfoPaint(String paintName, String brandName, String hexColorCode, String matchValue) {
        this.paintName = paintName;
        this.brandName = brandName;
        this.hexColorCode = hexColorCode;
        this.matchValue = matchValue;
    }

    public String getPaintName() {
        return paintName;
    }

    public void setPaintName(String paintName) {
        this.paintName = paintName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    public String getHexColorCode() {
        return hexColorCode;
    }

    public void setHexColorCode(String hexColorCode) {
        this.hexColorCode = hexColorCode;
    }


    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    @Override
    public String toString() {
        return  paintName + ", " + brandName + ", " +
                ", hexColorCode: " + hexColorCode +
                ", matchValue: " + matchValue;
    }
}
