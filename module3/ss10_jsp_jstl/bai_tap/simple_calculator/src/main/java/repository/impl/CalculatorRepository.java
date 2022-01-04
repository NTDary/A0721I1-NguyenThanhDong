package repository.impl;

import model.Calculator;
import repository.ICalculatorRepository;

import java.util.List;

public class CalculatorRepository implements ICalculatorRepository {
    private static Calculator calculator = new Calculator();
    @Override
    public float calculatorAdd() {
        return calculator.getFirstNumber() + calculator.getSecondNumber();
    }

    @Override
    public float calculatorSub() {
        return calculator.getFirstNumber() - calculator.getSecondNumber();
    }

    @Override
    public float calculatorMulti() {
        return calculator.getFirstNumber() * calculator.getSecondNumber();
    }

    @Override
    public float calculatorDiv() {
        return calculator.getFirstNumber() / calculator.getSecondNumber();
    }
}
