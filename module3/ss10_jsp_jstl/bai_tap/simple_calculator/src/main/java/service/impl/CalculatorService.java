package service.impl;

import model.Calculator;
import repository.ICalculatorRepository;
import repository.impl.CalculatorRepository;
import service.ICalculatorService;

public class CalculatorService implements ICalculatorService {
    private ICalculatorRepository iCalculatorRepository = new CalculatorRepository();
    @Override
    public float calculatorAdd(float firstNumber, float secondNumber) {
        return iCalculatorRepository.calculatorAdd(firstNumber,secondNumber);
    }

    @Override
    public float calculatorSub(float firstNumber, float secondNumber) {
        return iCalculatorRepository.calculatorSub(firstNumber,secondNumber);
    }

    @Override
    public float calculatorMulti(float firstNumber, float secondNumber) {
        return iCalculatorRepository.calculatorMulti(firstNumber,secondNumber);
    }

    @Override
    public float calculatorDiv(float firstNumber, float secondNumber) {
        return iCalculatorRepository.calculatorDiv(firstNumber,secondNumber);
    }
}
