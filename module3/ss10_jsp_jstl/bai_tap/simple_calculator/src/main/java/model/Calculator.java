package model;

public class Calculator {
   private float firstNumber;
   private float secondNumber;

    public Calculator(){

    }

    public Calculator(float firstNumber, float secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public float getFirstNumber() {
        return firstNumber;
    }

    public float getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(float firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(float secondNumber) {
        this.secondNumber = secondNumber;
    }
}
