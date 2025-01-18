package DecoratorDP;

public class ExtendedWarrantyDecorator extends ProductDecorator{
    public ExtendedWarrantyDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + extended warranty added";
    }

    @Override
    public int cost() {
        return product.cost() + 5000;
    }
}
