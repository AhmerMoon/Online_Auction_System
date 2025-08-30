import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {
    private static final String FILE_NAME = "Items.txt";

    public void addItemToFile(String itemName, double price) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(itemName + "," + price);
            System.out.println("Item added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding item to file: " + e.getMessage());
        }
    }

    public void deleteItemFromFile(String itemName) {
        List<String> items = readItemsFromFile();
        boolean itemDeleted = false;
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String item : items) {
                String[] parts = item.split(",");
                if (!parts[0].trim().equalsIgnoreCase(itemName.trim())) {
                    writer.println(item);
                } else {
                    System.out.println("Debug: Item " + itemName + " found and deleted.");
                    itemDeleted = true;
                }
            }
    
            if (itemDeleted) {
                System.out.println("Item deleted successfully.");
            } else {
                System.out.println("Item does not exist in the file. Deletion failed.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting item from file: " + e.getMessage());
        }
    }

    public void updateItemInFile(String itemName, double newPrice) {
    List<String> items = readItemsFromFile();
    boolean itemUpdated = false;

    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
        for (String item : items) {
            String[] parts = item.split(",");
            if (parts[0].equalsIgnoreCase(itemName)) {  // Changed to equalsIgnoreCase
                writer.println(parts[0] + "," + newPrice);
                itemUpdated = true;
            } else {
                writer.println(item);
            }
        }
    
            if (itemUpdated) {
                System.out.println("Item updated successfully.");
            } else {
                System.out.println("Item does not exist in the file. Update failed.");
            }
        } catch (IOException e) {
            System.out.println("Error updating item in file: " + e.getMessage());
        }
    }

    public List<String> readItemsFromFile() {
        List<String> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading items from file: " + e.getMessage());
        }

        return items;
    }

    public double getStartingPrice(String itemName) {
        List<String> items = readItemsFromFile();
    
        for (String item : items) {
            String[] parts = item.split(",");
            if (parts[0].equals(itemName)) {
                return Double.parseDouble(parts[1]); // Return the starting price of the specified item
            }
        }
    
        return 0; // Return 0 if the item is not found (consider error handling here)
    }
    
    
    

    
}
