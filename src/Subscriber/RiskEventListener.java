package Subscriber;

import Publisher.RiskCategory;

public interface RiskEventListener {
    void updateContext(RiskCategory riskLevel);
}
