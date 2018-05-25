package logic.POJOS;

public class OrderForm {

    private String orderForm_ID = null;
    private String orderForm_ProductInformation = null;
    private Integer orderForm_ProductNum = null;
    private String orderForm_DeliveryAddress = null;
    private String orderForm_BuyerMessage = null;
    private Float orderForm_Total = null;

    @Override
    public String toString() {
        return "OrderForm{" +
                "orderForm_ID='" + orderForm_ID + '\'' +
                ", orderForm_ProductInformation='" + orderForm_ProductInformation + '\'' +
                ", orderForm_ProductNum='" + orderForm_ProductNum + '\'' +
                ", orderForm_DeliveryAddress='" + orderForm_DeliveryAddress + '\'' +
                ", orderForm_BuyerMessage='" + orderForm_BuyerMessage + '\'' +
                ", orderForm_Total='" + orderForm_Total + '\'' +
                '}';
    }

    public String getOrderForm_ID() {
        return orderForm_ID;
    }

    public void setOrderForm_ID(String orderForm_ID) {
        this.orderForm_ID = orderForm_ID;
    }

    public String getOrderForm_ProductInformation() {
        return orderForm_ProductInformation;
    }

    public void setOrderForm_ProductInformation(String orderForm_ProductInformation) {
        this.orderForm_ProductInformation = orderForm_ProductInformation;
    }

    public Integer getOrderForm_ProductNum() {
        return orderForm_ProductNum;
    }

    public void setOrderForm_ProductNum(Integer orderForm_ProductNum) {
        this.orderForm_ProductNum = orderForm_ProductNum;
    }

    public String getOrderForm_DeliveryAddress() {
        return orderForm_DeliveryAddress;
    }

    public void setOrderForm_DeliveryAddress(String orderForm_DeliveryAddress) {
        this.orderForm_DeliveryAddress = orderForm_DeliveryAddress;
    }

    public String getOrderForm_BuyerMessage() {
        return orderForm_BuyerMessage;
    }

    public void setOrderForm_BuyerMessage(String orderForm_BuyerMessage) {
        this.orderForm_BuyerMessage = orderForm_BuyerMessage;
    }

    public Float getOrderForm_Total() {
        return orderForm_Total;
    }

    public void setOrderForm_Total(Float orderForm_Total) {
        this.orderForm_Total = orderForm_Total;
    }
}