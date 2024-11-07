import Publisher.RiskCategory;
import Publisher.RiskNotifier;
import Subscriber.Subscriber;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RiskNotifier app = RiskNotifier.getInstance();
        RiskCategory[] riskLevels = RiskCategory.values();
        Random random = new Random();

        Subscriber subscriber1 = new Subscriber("g");
        Subscriber subscriber2 = new Subscriber("a");
        Subscriber subscriber3 = new Subscriber("l");

        app.addSubscriber(subscriber1);
        app.addSubscriber(subscriber2);
        app.addSubscriber(subscriber3);


        for (int i = 0; i < 10; i++) {
            if(i == 3) app.removeSubscriber(subscriber3);
            if(i == 5) app.addSubscriber(subscriber3);
            RiskCategory newRiskLevel = riskLevels[random.nextInt(riskLevels.length)];
            System.out.println("\n--- Atualizando o nível de risco para: " + newRiskLevel.getLabel() + " ---\n");
            app.updateRiskLevel(newRiskLevel);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Erro na execução da thread: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        app.removeSubscriber(subscriber1);
        app.removeSubscriber(subscriber2);
        System.out.println("\nFim da simulação.");
    }
}
