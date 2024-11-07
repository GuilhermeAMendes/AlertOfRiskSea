package Publisher;

public enum RiskCategory {
    SEVERE("Grave"),
    ABOVE_AVERAGE("Acima da média"),
    STANDARD("Normal"),
    LOW("Baixo");

    private final String label;

    RiskCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}