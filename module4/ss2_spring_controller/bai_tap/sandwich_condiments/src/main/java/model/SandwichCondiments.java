package model;

public class SandwichCondiments {
    private String[] condiments;

    public SandwichCondiments() {
    }

    public SandwichCondiments(String[] condiments) {
        this.condiments = condiments;
    }

    public String[] getCondiments() {
        return condiments;
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
}
