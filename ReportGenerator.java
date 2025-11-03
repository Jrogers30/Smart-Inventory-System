package inventory;

import java.util.List;

public class ReportGenerator {
    public static void generateInventoryReport(List<Item> items) {
        System.out.println("Inventory Report:");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("Total items: " + items.size());
        System.out.println("Report generated (text output only).");
    }
}
