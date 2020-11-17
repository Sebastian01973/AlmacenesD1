package models;

public class Product {

    private String code;
    private String name;
    private int amount;
    private double price;

    public Product(String code, String name, int amount, double price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalProduct(){
        return amount*price;
    }

    public boolean isValidateCode(String code){
        return this.code.equals(code);
    }

    public void deleteAmount(int amount){
        if (this.amount >= amount){
            this.amount = this.amount-amount;
        }
    }

    public Object[] toObjectVector(){
        return new Object[]{
          name,code,amount,price,
        };
    }
}
