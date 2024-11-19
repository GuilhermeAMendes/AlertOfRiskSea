package Observer;

import Subject.RiskCategory;

public interface Observer {
    void onRiskLevelUpdate(RiskCategory riskLevel);
}
