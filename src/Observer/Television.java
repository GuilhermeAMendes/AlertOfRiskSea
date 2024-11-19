package Observer;

import Subject.RiskCategory;

public class Television implements Observer {

    @Override
    public void onRiskLevelUpdate(RiskCategory riskLevel) {
        System.out.println("Alert: risk level in the region is " + riskLevel.getLabel());
    }
}
