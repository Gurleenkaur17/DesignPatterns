package ObservablePackage;

import ObserverPackage.Observer;

import java.util.ArrayList;
import java.util.List;

public class ProductStockObservable implements Obeservable{

    private List<Observer> observers;
    private int stock;
    private String productName;

    public ProductStockObservable(String productName) {
        this.observers = new ArrayList<>();
        this.stock = 0;
        this.productName = productName;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer obs: observers){
            obs.update(productName);
        }
    }

    @Override
    public void setData(int stock) {
        if(stock != 0){
            notifyObserver();
        }
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }
}
