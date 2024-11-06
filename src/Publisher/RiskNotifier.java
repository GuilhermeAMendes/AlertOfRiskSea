package Publisher;

import Subscriber.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class RiskNotifier implements RiskEventPublisher {
    private static RiskNotifier instance;
    private List<Subscriber> subscribers = new ArrayList<>();
    private RiskCategory currentRiskLevel;

    private RiskNotifier(){
        this.currentRiskLevel = RiskCategory.STANDARD;
    }

    public static RiskNotifier getInstance(){
        return instance == null ? instance = new RiskNotifier() : instance;
    }

    @Override
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers () {
        for (Subscriber s : subscribers) {
            s.updateContext(currentRiskLevel);
        }
    }

    public void updateRiskLevel(RiskCategory newLevel){
        this.currentRiskLevel = newLevel;
        notifyAllSubscribers();
    }
}
