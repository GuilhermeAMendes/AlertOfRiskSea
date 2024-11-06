package Publisher;

import Subscriber.Subscriber;

public interface RiskEventPublisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifyAllSubscribers();
}
