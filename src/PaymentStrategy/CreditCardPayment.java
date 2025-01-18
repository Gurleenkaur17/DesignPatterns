package PaymentStrategy;

public class CreditCardPayment implements PaymentStrategyInterface{
    private String creditCardNumber;
    private String creditCardName;

    public CreditCardPayment(String creditCardNumber, String creditCardName) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
    }

    @Override
    public void payment(int amount) {
        System.out.println("Payment of " + amount + " is successful using the Credit Card " + creditCardNumber);
    }
}
