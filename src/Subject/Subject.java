package Subject;

public interface Subject<T> {
    void addSubscriber(T subscriber);
    void removeSubscriber(T subscriber);
    void notifyAllSubscribers();
}
