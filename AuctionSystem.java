import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class AuctionSystem {
    private BiddingHistory biddingHistory;
    private boolean biddingActive;
    private FileHandler fileHandler;

    public AuctionSystem() {
        this.biddingHistory = new BiddingHistory();
        this.fileHandler = new FileHandler();
    }

    public double getStartingPrice(String itemName) {
        return fileHandler.getStartingPrice(itemName);
    }

    public BiddingHistory getBiddingHistory() {
        return biddingHistory;
    }

    public void selectItemToBid(FileHandler fileHandler) {
        List<String> items = fileHandler.readItemsFromFile();

        if (items.isEmpty()) {
            System.out.println("No items available for bidding.");
        } else {
            System.out.println("Available Items for Bidding:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the item number to start bidding: ");
            int itemNumber = 0;
            try {
                itemNumber = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input! Please enter a valid integer.");
            }

            biddingActive = true;

            if (itemNumber >= 1 && itemNumber <= items.size()) {
                startBidding(items.get(itemNumber - 1));
            } else {
                System.out.println("Invalid item number. Returning to the main menu.");
            }

            biddingActive = false;
        }
    }

    private void startBidding(String selectedItem) {
        System.out.println("Bidding started for: " + selectedItem);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                announceWinner(selectedItem); // Pass the selected item to announceWinner()
                timer.cancel();
            }
        }, 10000); // 10 seconds

        collectBids(timer); // Pass the timer to the collectBids() method
    }

    private void collectBids(Timer timer) {
        Scanner scanner = new Scanner(System.in);
        long biddingEndTime = System.currentTimeMillis() + 10000; // Store the bidding end time

        while (biddingActive && System.currentTimeMillis() < biddingEndTime) {
            System.out.print("Enter bidder name (type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                biddingActive = false;
                break;
            }

            System.out.print("Enter bid amount: ");
            double bid = 0;
            try {
                bid = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input! Please enter a valid price.");
            }

            if (System.currentTimeMillis() >= biddingEndTime) {
            System.out.println("Bidding time ended. Returning to the main menu.");
            biddingActive = false;
        }

            biddingHistory.addBid(name, bid);
        }

        
    }

    private void announceWinner(String selectedItem) {
        if (biddingHistory.isEmpty()) {
            System.out.println("No bids received for " + selectedItem + ". No winner.");
        } else {
            double maxBid = biddingHistory.getMaxBid();
            double startingPrice = fileHandler.getStartingPrice(selectedItem);

            if (maxBid >= startingPrice) {
                int winningIndex = biddingHistory.findWinningBidIndex();
                String winnerName = biddingHistory.getCustomerName(winningIndex);
                double winningBid = biddingHistory.getBidAmount(winningIndex);

                System.out.println("Auction closed for " + selectedItem + ". Winner: " + winnerName + " with a bid of $"
                        + winningBid);
            } else {
                System.out.println(
                        "Auction closed for " + selectedItem + ". No winner as no bids exceeded the starting price.");
            }
        }
    }

}
