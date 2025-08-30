import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame {
    public MenuFrame(OnlineAuctionSystem auctionSystem) {
        setTitle("Online Auction System Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 5, 5));

        JButton addItemButton = new JButton("Add Item to File");
        JButton deleteItemButton = new JButton("Delete Item from File");
        JButton updateItemButton = new JButton("Update Item in File");
        JButton selectItemButton = new JButton("Select Item to Bid");
        JButton displayItemListButton = new JButton("Display Item List");
        JButton viewBiddingHistoryButton = new JButton("View Bidding History");
        JButton exitButton = new JButton("Exit System");

        panel.add(addItemButton);
        panel.add(deleteItemButton);
        panel.add(updateItemButton);
        panel.add(selectItemButton);
        panel.add(displayItemListButton);
        panel.add(viewBiddingHistoryButton);
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);

        addItemButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String itemName = "";
        double startingPrice = 0;

        while (true) {
            JTextField itemNameField = new JTextField();
            JTextField itemPriceField = new JTextField();

            JPanel inputPanel = new JPanel(new GridLayout(0, 1));
            inputPanel.add(new JLabel("Enter item name:"));
            inputPanel.add(itemNameField);
            inputPanel.add(new JLabel("Enter starting price:"));
            inputPanel.add(itemPriceField);

            int result = JOptionPane.showConfirmDialog(null, inputPanel,
                    "Add New Item", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                itemName = itemNameField.getText();
                try {
                    startingPrice = Double.parseDouble(itemPriceField.getText());
                    break; // Break the loop if valid input is provided
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid price format! Please enter a valid number.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // If cancel or close button is clicked, exit the loop
                break;
            }
        }

        if (!itemName.isEmpty()) {
            auctionSystem.addItemToFile(itemName, startingPrice);
            JOptionPane.showMessageDialog(null, "Item added successfully: " + itemName);
        }
    }
});

        
        
deleteItemButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField itemNameField = new JTextField();

        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        inputPanel.add(new JLabel("Enter item name to delete:"));
        inputPanel.add(itemNameField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Delete Item", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String itemNameToDelete = itemNameField.getText();
            auctionSystem.deleteItemFromFile(itemNameToDelete);
            JOptionPane.showMessageDialog(null, "Item deleted successfully: " + itemNameToDelete);
        }
    }
});

        updateItemButton.addActionListener(e -> auctionSystem.updateItemInFile());
        selectItemButton.addActionListener(e -> auctionSystem.selectItemToBid());
        displayItemListButton.addActionListener(e -> auctionSystem.displayItemList());
        viewBiddingHistoryButton.addActionListener(e -> auctionSystem.viewBiddingHistory());
        exitButton.addActionListener(e -> System.exit(0));
    }
}
