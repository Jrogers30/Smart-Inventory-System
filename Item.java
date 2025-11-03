package inventory;

public class Item {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Item(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String name, String category, double price, int quantity) {
        this(-1, name, category, price, quantity);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | $%.2f | Qty: %d", id, name, category, price, quantity);
    }
}
