import Publisher.RiskCategory;
import Publisher.RiskNotifier;
import Subscriber.Subscriber;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RiskNotifier app = RiskNotifier.getInstance();
        Random random = new Random();

        Subscriber subscriber1 = new Subscriber("g",app);
        Subscriber subscriber2 = new Subscriber("a",app);
        Subscriber subscriber3 = new Subscriber("l",app);

        subscriber1.subscribe();
        subscriber2.subscribe();
        subscriber3.subscribe();

        RiskCategory[] riskLevels = RiskCategory.values();

        for (int i = 0; i < 10; i++) {
            if (i == 3) subscriber3.unsubscribe();

            if (i == 5) subscriber3.subscribe();
            RiskCategory newRiskLevel = riskLevels[random.nextInt(riskLevels.length)];
            System.out.println("\n--- Atualizando o nível de risco para: " + newRiskLevel + " ---");
            app.updateRiskLevel(newRiskLevel);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Erro na execução da thread: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        subscriber1.unsubscribe();
        subscriber2.unsubscribe();
        System.out.println("\nFim da simulação.");
    }
}
