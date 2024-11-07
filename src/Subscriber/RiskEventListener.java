package Subscriber;

import Publisher.RiskCategory;

public interface RiskEventListener {
    void updateContextOf(RiskCategory riskLevel);
}
