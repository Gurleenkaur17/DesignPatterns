package PaymentStrategy;

public class UPIPayment implements PaymentStrategyInterface{
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void payment(int amount) {
        System.out.println("Payment of " + amount + " is successful using UPI ID " + upiId);
    }
}
