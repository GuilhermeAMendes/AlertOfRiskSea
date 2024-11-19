package Observer;

import Subject.RiskCategory;

public class Smartphone implements Observer {
    private final String name;

    public Smartphone(String name) {
        this.name = name;
    }

    @Override
    public void onRiskLevelUpdate(RiskCategory riskLevel) {
        System.out.println("Pop-up: " + name + ": risk level in the region is " + riskLevel.getLabel());
    }
}
