package service.impl;

import model.Calculator;
import repository.ICalculatorRepository;
import repository.impl.CalculatorRepository;
import service.ICalculatorService;

public class CalculatorService implements ICalculatorService {
    private ICalculatorRepository iCalculatorRepository = new CalculatorRepository();
    @Override
    public float calculatorAdd() {
        return calculatorAdd();
    }

    @Override
    public float calculatorSub() {
        return calculatorSub();
    }

    @Override
    public float calculatorMulti() {
        return calculatorMulti();
    }

    @Override
    public float calculatorDiv() {
        return calculatorDiv();
    }
}
