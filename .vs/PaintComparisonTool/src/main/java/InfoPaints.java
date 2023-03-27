




public class InfoPaints {



    //------------------------------------------------------------
    // Holds Brand Name and Paint Information
    //------------------------------------------------------------


    private String paintName;
    private String brandName;
    private String hexColorCode;

    public InfoPaints(String paintName, String brandName) {
        this.paintName = paintName;
        this.brandName = brandName;
    }

    public InfoPaints (String paintName, String brandName, String hexColorCode) {
        this.paintName = paintName;
        this.brandName = brandName;
        this.hexColorCode = hexColorCode;
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

}
