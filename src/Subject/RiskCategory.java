package Subject;

public enum RiskCategory {
    SEVERE("Severe"),
    ABOVE_AVERAGE("Above Average"),
    STANDARD("Standard"),
    LOW("Low");

    private final String label;

    RiskCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}