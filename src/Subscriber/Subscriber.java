package Subscriber;

import Publisher.RiskEventPublisher;
import Publisher.RiskCategory;
import java.util.UUID;

public class Subscriber implements RiskEventListener {
    private UUID id;
    private String nome;
    private RiskEventPublisher publisher;

    public Subscriber(String nome, RiskEventPublisher publisher) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.publisher = publisher;
    }

    public void unsubscribe() {
        publisher.removeSubscriber(this);
    }

    public void subscribe() {
        publisher.addSubscriber(this);
    }

    @Override
    public void updateContext(RiskCategory riskLevel) {
        System.out.println("Alerta para " + nome + ": nível de risco na região é " + riskLevel);
    }
}
