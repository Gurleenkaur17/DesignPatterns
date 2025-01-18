package DecoratorDP;

public class ExpressShippingDecorator extends ProductDecorator{
    public ExpressShippingDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Express shipping provided";
    }

    @Override
    public int cost() {
        return product.cost() + 100;
    }
}
