package Subject;

import Observer.Observer;

import Utils.ValidationsUtils;

import java.util.ArrayList;
import java.util.List;

public class RiskNotifier implements Subject<Observer> {
    private static RiskNotifier instance;
    private final List<Observer> subscribers = new ArrayList<>();
    private RiskCategory currentRiskLevel;

    private RiskNotifier(){
        this.currentRiskLevel = RiskCategory.STANDARD;
    }

    public static RiskNotifier getInstance(){
        if (instance == null) instance = new RiskNotifier();
        return instance;
    }

    @Override
    public void addSubscriber(Observer subscriber){
        ValidationsUtils.validateNotNull(subscriber, "Subscriber cannot be null");
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Observer subscriber){
        ValidationsUtils.validateNotNull(subscriber, "Subscriber cannot be null");
        ValidationsUtils.validateExistsInList(subscriber,subscribers,"Subscriber not in list");
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers () {
        if (ValidationsUtils.validadeIsNotEmpty(subscribers)) return;
        subscribers.forEach(subscriber -> subscriber.onRiskLevelUpdate(currentRiskLevel));
    }

    public void updateRiskLevel(RiskCategory newLevel){
        currentRiskLevel = newLevel;
        notifyAllSubscribers();
    }
}
