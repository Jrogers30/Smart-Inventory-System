package inventory;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        DatabaseManager db = new DatabaseManager();
        db.createTable();
        manager.loadFromDatabase(db);
        
        int choice = 0;
        while (choice != 10) {
            displayMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    Item item = new Item(name, category, price, qty);
                    manager.addItem(item);
                    db.insertItem(item);
                    break;
                case 2:
                    manager.displayItems();
                    System.out.print("Enter item ID to remove: ");
                    int id = sc.nextInt();
                    db.deleteItem(id);
                    manager.removeItem(id);
                    break;
                case 3:
                    manager.displayItems();
                    break;
                case 4:
                    System.out.println("Total inventory value: $" + manager.calculateTotalValue());
                    break;
                case 5:
                    manager.displayLowStockItems();
                    break;
                case 6:
                    manager.sortByPrice();
                    break;
                case 7:
                    manager.sortByQuantity();
                    break;
                case 8:
                    System.out.println("Enter category to filter: ");
                    String cat = sc.nextLine();
                    manager.filterByCategory(cat);
                    break;
                case 9:
                    ReportGenerator.generateInventoryReport(manager.getItems());
                    break;
                case 10:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("==========================");
        System.out.println(" Smart Inventory System");
        System.out.println("==========================");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. View All Items");
        System.out.println("4. View Total Inventory Value");
        System.out.println("5. Display Low Stock Items");
        System.out.println("6. Sort by Price");
        System.out.println("7. Sort by Quantity");
        System.out.println("8. Filter by Category");
        System.out.println("9. Generate Inventory Report");
        System.out.println("10. Exit");
        System.out.println("==========================");
    }
}
