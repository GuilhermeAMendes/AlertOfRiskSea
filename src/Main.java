import Observer.Television;
import Subject.RiskCategory;
import Subject.RiskNotifier;
import Observer.Smartphone;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RiskNotifier app = RiskNotifier.getInstance();
        RiskCategory[] riskLevels = RiskCategory.values();
        Random random = new Random();
        Smartphone smartphone1 = new Smartphone("John");
        Television television1 = new Television();
        app.addSubscriber(smartphone1);
        app.addSubscriber(television1);
        RiskCategory riskLevel1 = riskLevels[random.nextInt(riskLevels.length)];
        app.updateRiskLevel(riskLevel1);
        app.removeSubscriber(television1);
        RiskCategory riskLevel2 = riskLevels[random.nextInt(riskLevels.length)];
        app.updateRiskLevel(riskLevel2);
    }
}
