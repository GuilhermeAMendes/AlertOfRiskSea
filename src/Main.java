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
        Smartphone smartphone1 = new Smartphone("g");
        Smartphone smartphone2 = new Smartphone("a");
        Television television1 = new Television();

        app.addSubscriber(smartphone1);
        app.addSubscriber(smartphone2);
        app.addSubscriber(television1);


        for (int i = 0; i < 6; i++) {
            if(i == 3) app.removeSubscriber(smartphone2);
            if(i == 5) app.addSubscriber(smartphone2);
            RiskCategory newRiskLevel = riskLevels[random.nextInt(riskLevels.length)];
            app.updateRiskLevel(newRiskLevel);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Error executing thread: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        app.removeSubscriber(smartphone1);
        app.removeSubscriber(smartphone2);
        System.out.println("\nEnd of simulation.");
    }
}