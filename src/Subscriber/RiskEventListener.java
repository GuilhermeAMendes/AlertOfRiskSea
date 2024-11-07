package Subscriber;

import Publisher.RiskCategory;

public interface RiskEventListener {
    void onRiskLevelUpdate(RiskCategory riskLevel);
}
