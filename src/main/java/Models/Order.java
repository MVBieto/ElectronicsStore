package Models;

public class Order {
    private int customerId;
    private int salesManagerId;
    private int productId;
    private int finalPrice;
    private int amount;

    public Order(int customerId, int salesManagerId, int productId, int finalPrice, int amount) {
        this.customerId = customerId;
        this.salesManagerId = salesManagerId;
        this.productId = productId;
        this.finalPrice = finalPrice;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesManagerId() {
        return salesManagerId;
    }

    public void setSalesManagerId(int salesManagerId) {
        this.salesManagerId = salesManagerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
