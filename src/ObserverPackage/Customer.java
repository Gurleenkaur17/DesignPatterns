package ObserverPackage;

public class Customer implements Observer{
    private String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName) {
        System.out.println("Notification sent to " + customerName + " for the product " + productName + " is back in stock");
    }
}
