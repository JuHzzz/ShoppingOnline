package logic.POJOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product {

    private String productType;
    private String productID;
    private String productSize;
    private String productColor;
    private String productNum;
    private String productUnitPrice;
    private Map<String,String> map = null;


    public Map<String,String> getMap(){
        map = new HashMap<String, String>();
        map.put("productType",productType);
        map.put("productSize",productSize);
        map.put("productColor",productColor);
        map.put("productPrice",productUnitPrice);
        map.put("productNum",productNum);
        return map;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType='" + productType + '\'' +
                ", productID='" + productID + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productUnitPrice='" + productUnitPrice + '\'' +
                '}';
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }
}
