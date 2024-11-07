package Publisher;

import Subscriber.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class RiskNotifier implements RiskEventPublisher<Subscriber> {
    private static RiskNotifier instance;
    private final List<Subscriber> subscribers = new ArrayList<>();
    private RiskCategory currentRiskLevel;

    private RiskNotifier(){
        this.currentRiskLevel = RiskCategory.STANDARD;
    }

    public static RiskNotifier getInstance(){
        if (instance == null) instance = new RiskNotifier();
        return instance;
    }

    @Override
    public void addSubscriber(Subscriber subscriber){
        if (subscriber == null) throw new IllegalArgumentException("Subscriber cannot be null");
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        if (subscriber == null) throw new IllegalArgumentException("Subscriber cannot be null");
        if (!subscribers.contains(subscriber)) throw new IllegalArgumentException("Subscriber not in list");
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers () {
        for (Subscriber s : subscribers) {
            s.updateContext(currentRiskLevel);
        }
    }

    public void updateRiskLevel(RiskCategory newLevel){
        currentRiskLevel = newLevel;
        if (subscribers.isEmpty()) return;
        notifyAllSubscribers();
    }
}
