import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OnlineAuctionSystem {
    private MenuFrame menuFrame;
    private FileHandler fileHandler;
    private AuctionSystem auctionSystem;

    public OnlineAuctionSystem() {
        new AdminLogin(this);
        this.menuFrame = new MenuFrame(this);
        this.fileHandler = new FileHandler();
        this.auctionSystem = new AuctionSystem();
    }

    public void showMenu() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuFrame.setVisible(true);
            }
        });
    }

    public void addItemToFile(String itemName, double startingPrice) {
        fileHandler.addItemToFile(itemName, startingPrice);
    }
    

    public void deleteItemFromFile(String itemToDelete) {
        fileHandler.deleteItemFromFile(itemToDelete);
    }

public void updateItemInFile() {
    JTextField itemNameField = new JTextField();
    JTextField newPriceField = new JTextField();

    JPanel inputPanel = new JPanel(new GridLayout(0, 1));
    inputPanel.add(new JLabel("Enter item name to update:"));
    inputPanel.add(itemNameField);
    inputPanel.add(new JLabel("Enter new starting price:"));
    inputPanel.add(newPriceField);

    int result = JOptionPane.showConfirmDialog(null, inputPanel,
            "Update Item", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        try {
            String itemToUpdate = itemNameField.getText();
            double newPrice = Double.parseDouble(newPriceField.getText());
            fileHandler.updateItemInFile(itemToUpdate, newPrice);
            JOptionPane.showMessageDialog(null, "Item updated successfully: " + itemToUpdate);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price format! Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}    public void selectItemToBid() {
        auctionSystem.selectItemToBid(fileHandler);
    }

    public void displayItemList() {
        List<String> itemList = fileHandler.readItemsFromFile();

        StringBuilder itemListText = new StringBuilder("Items available for bidding:\n");
        for (String item : itemList) {
            itemListText.append(item).append("\n");
        }

        JTextArea textArea = new JTextArea(itemListText.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Item List", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewBiddingHistory() {
        // Implement the functionality to view bidding history
        auctionSystem.getBiddingHistory().displayHistory();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineAuctionSystem();
            }
        });
    }
}
