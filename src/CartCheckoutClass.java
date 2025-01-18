import PaymentStrategy.PaymentStrategyInterface;

public class CartCheckoutClass {
    PaymentStrategyInterface paymentStrategyInterface;

    public void setPaymentStrategyInterface(PaymentStrategyInterface paymentStrategyInterface) {
        this.paymentStrategyInterface = paymentStrategyInterface;
    }

    public void payment(int amount){
        paymentStrategyInterface.payment(amount);
    }
}
