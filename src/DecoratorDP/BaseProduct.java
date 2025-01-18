package DecoratorDP;

public class BaseProduct implements Product{
    private String productName;
    private int cost;

    public BaseProduct(String productName, int cost) {
        this.productName = productName;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return productName;
    }

    @Override
    public int cost() {
        return cost;
    }
}
