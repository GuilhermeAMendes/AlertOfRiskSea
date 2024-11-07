package Subscriber;

import Publisher.RiskCategory;

public class Subscriber implements RiskEventListener {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void onRiskLevelUpdate(RiskCategory riskLevel) {
        System.out.println("Alert for " + name + ": risk level in the region is " + riskLevel.getLabel());
    }
}
