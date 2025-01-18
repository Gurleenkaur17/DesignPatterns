import PaymentStrategy.CreditCardPayment;
import PaymentStrategy.UPIPayment;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartCheckoutClass checkout = new CartCheckoutClass();

        int totalAmount = 1500;

        System.out.println("Your total amount: ₹" + totalAmount);
        System.out.println("Select a payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.next();
                checkout.setPaymentStrategyInterface(new UPIPayment(upiId));
                break;

            case 2:
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = scanner.next();
                System.out.print("Enter Card Holder Name: ");
                scanner.nextLine(); // Consume newline
                String cardHolderName = scanner.nextLine();
                checkout.setPaymentStrategyInterface(new CreditCardPayment(cardNumber, cardHolderName));
                break;

            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        checkout.payment(totalAmount);
    }
}