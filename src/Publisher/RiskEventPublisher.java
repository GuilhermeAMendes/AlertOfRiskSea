package Publisher;

import Subscriber.Subscriber;

public interface RiskEventPublisher<T> {
    void addSubscriber(T subscriber);
    void removeSubscriber(T subscriber);
    void notifyAllSubscribers();
}
