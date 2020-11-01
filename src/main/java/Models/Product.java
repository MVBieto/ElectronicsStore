package Models;

public class Product {

    private int id;
    private String type;
    private int price;
    private String name;
    private int amount;

    public Product(int id, String type, int price, String name, int amount) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
