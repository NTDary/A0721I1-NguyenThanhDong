package model;

public class Caculator {
    private float numberA;
    private float numberB;

    public Caculator() {
    }

    public Caculator(float numberA, float numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public float getNumberA() {
        return numberA;
    }

    public void setNumberA(float numberA) {
        this.numberA = numberA;
    }

    public float getNumberB() {
        return numberB;
    }

    public void setNumberB(float numberB) {
        this.numberB = numberB;
    }
}
