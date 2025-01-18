package ObservablePackage;

import ObserverPackage.Observer;

public interface Obeservable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObserver();
    void setData(int data);
}
