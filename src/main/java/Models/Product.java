package Models;

import Enums.Type;

public class Product {

    private int idProduct;
    private Type type;
    private int price;
    private String name;
    private int amount;

    public Product(int id, Type type, int price, String name, int amount) {
        this.idProduct = id;
        this.type = type;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }

    public Product() {
    }

    public int getId() {
        return idProduct;
    }

    public void setId(int id) {
        this.idProduct = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
