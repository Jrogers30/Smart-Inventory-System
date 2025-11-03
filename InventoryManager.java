package inventory;

import java.util.*;

public class InventoryManager {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    public void removeItem(int id) {
        items.removeIf(i -> i.getId() == id);
        System.out.println("Item removed.");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        items.forEach(System.out::println);
    }

    public void displayLowStockItems() {
        System.out.println("Low Stock Items (<=5):");
        items.stream().filter(i -> i.getQuantity() <= 5).forEach(System.out::println);
    }

    public double calculateTotalValue() {
        return items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
    }

    public void sortByPrice() {
        items.sort(Comparator.comparingDouble(Item::getPrice));
        System.out.println("Items sorted by price.");
    }

    public void sortByQuantity() {
        items.sort(Comparator.comparingInt(Item::getQuantity));
        System.out.println("Items sorted by quantity.");
    }

    public void filterByCategory(String category) {
        items.stream().filter(i -> i.getCategory().equalsIgnoreCase(category))
             .forEach(System.out::println);
    }

    public void loadFromDatabase(DatabaseManager db) {
        items = db.loadItems();
    }

    public List<Item> getItems() {
        return items;
    }
}
