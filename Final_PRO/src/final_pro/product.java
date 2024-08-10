
package final_pro;


public class product {
    private int id;
    private String name;
    private double price;
    private int qty;
    private double amount;

    public product(int id ,String name, double price, int qty, double amount) {
        this.id= id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.amount = amount;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}

