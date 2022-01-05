package repository.impl;

import model.Calculator;
import repository.ICalculatorRepository;

import java.util.List;

public class CalculatorRepository implements ICalculatorRepository {
    private static Calculator calculator = new Calculator();
    @Override
    public float calculatorAdd(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public float calculatorSub(float firstNumber, float secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public float calculatorMulti(float firstNumber, float secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public float calculatorDiv(float firstNumber, float secondNumber) {
        return firstNumber / secondNumber;
    }
}
