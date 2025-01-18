import DecoratorDP.*;
import ObservablePackage.ProductStockObservable;
import ObserverPackage.Customer;
import PaymentStrategy.CreditCardPayment;
import PaymentStrategy.UPIPayment;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        ProductStockObservable productStockObservable = new ProductStockObservable("Iphone");
        productStockObservable.add(customer1);
        productStockObservable.add(customer2);

        int stock = 0;
        System.out.println("Product initially out of stock...");
        productStockObservable.setData(stock);

        stock = 10; // Stock is now available
        System.out.println("\nUpdating stock...");
        productStockObservable.setData(stock);

        if(stock > 0){
            Scanner scanner = new Scanner(System.in);
            CartCheckoutClass checkout = new CartCheckoutClass();
            Product product = new BaseProduct("Iphone", 50000);

            int totalAmount = 1500;

            System.out.println("Your total amount: ₹" + totalAmount);
            System.out.println("Select any additional features for your product");
            System.out.println("1. Gift Wrap");
            System.out.println("2. Extended Warranty");
            System.out.println("3. Express Shipping");
            System.out.println("4. Checkout, no additional features needed");

            System.out.println("Do you want to add Gift Wrapping? (yes/no)");
            String giftWrapChoice = scanner.nextLine();
            if (giftWrapChoice.equalsIgnoreCase("yes")) {
                product = new GiftWrapDecorator(product);
            }

            System.out.println("Do you want to add Express Shipping? (yes/no)");
            String expressShippingChoice = scanner.nextLine();
            if (expressShippingChoice.equalsIgnoreCase("yes")) {
                product = new ExpressShippingDecorator(product);
            }

            System.out.println("Do you want to add Extended Warranty? (yes/no)");
            String extendedWarrantyChoice = scanner.nextLine();
            if (extendedWarrantyChoice.equalsIgnoreCase("yes")) {
                product = new ExtendedWarrantyDecorator(product);
            }
            System.out.println("\nThe product to be checked out is " + product.getDescription() + " and price is " + product.cost());

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

            checkout.payment(product.cost());
        }
    }
}