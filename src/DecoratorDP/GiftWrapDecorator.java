package DecoratorDP;

public class GiftWrapDecorator extends ProductDecorator{

    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " Gift wrapping added";
    }

    @Override
    public int cost() {
        return product.cost() + 50;
    }


}
