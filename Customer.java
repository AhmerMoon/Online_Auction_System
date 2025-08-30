public class Customer {
    private String name;
    private double bidAmount;

    public Customer(String name, double bidAmount) {
        this.name = name;
        this.bidAmount = bidAmount;
    }

    public String getName() {
        return name;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
