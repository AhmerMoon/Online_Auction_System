import java.util.ArrayList;
import java.util.List;

public class BiddingHistory {
    private List<String> customerNames;
    private List<Double> bidAmounts;

    public BiddingHistory() {
        this.customerNames = new ArrayList<>();
        this.bidAmounts = new ArrayList<>();
    }

    public void addBid(String customerName, double bidAmount) {
        customerNames.add(customerName);
        bidAmounts.add(bidAmount);
    }

    public void displayHistory() {
        if (customerNames.isEmpty()) {
            System.out.println("No bidding history available.");
        } else {
            System.out.println("Bidding History:");
            for (int i = 0; i < customerNames.size(); i++) {
                System.out.println("Bidder: " + customerNames.get(i) + ", Bid Amount: $" + bidAmounts.get(i));
            }
        }
    }

    public boolean isEmpty() {
        return customerNames.isEmpty();
    }

    public int findWinningBidIndex() {
        if (isEmpty()) {
            throw new IllegalStateException("No bids received. Cannot determine a winner.");
        }

        double maxBid = bidAmounts.get(0);
        int winningIndex = 0;

        for (int i = 1; i < bidAmounts.size(); i++) {
            if (bidAmounts.get(i) > maxBid) {
                maxBid = bidAmounts.get(i);
                winningIndex = i;
            }
        }

        return winningIndex;
    }

    public String getCustomerName(int index) {
        return customerNames.get(index);
    }

    public double getBidAmount(int index) {
        return bidAmounts.get(index);
    }

    public void clearHistory() {
        customerNames.clear();
        bidAmounts.clear();
    }

    public double getMaxBid() {
        if (isEmpty()) {
            return 0; // If no bids, return 0 as the maximum bid
        }
    
        double maxBid = bidAmounts.get(0);
    
        for (double bid : bidAmounts) {
            if (bid > maxBid) {
                maxBid = bid;
            }
        }
    
        return maxBid;
    }    
    
}
