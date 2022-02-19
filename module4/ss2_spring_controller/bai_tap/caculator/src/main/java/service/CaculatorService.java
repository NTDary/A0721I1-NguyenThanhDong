package service;

import model.Caculator;
import service.impl.ICaculatorService;

import java.util.HashMap;

public class CaculatorService implements ICaculatorService {
    @Override
    public float add(float numberA, float numberB) {
        return numberA + numberB;
    }

    @Override
    public float sub(float numberA, float numberB) {
        return numberA - numberB;
    }

    @Override
    public float multi(float numberA, float numberB) {
        return numberA * numberB;
    }

    @Override
    public float div(float numberA, float numberB) {
       return numberA / numberB;
    }

    @Override
    public HashMap<String,String> validate(String text1, String text2){
        HashMap<String,String> errors = new HashMap<>();

        if(text1 == null || text1.trim().isEmpty() || text2 == null || text2.trim().isEmpty()){
            errors.put("emptyError", "must have a number");
        }else {
            if(!text1.matches("^[+-]?([0-9]*[.])?[0-9]+$") || !text2.matches("^[+-]?([0-9]*[.])?[0-9]+$")){
                errors.put("format","Number Format");
            }
        }
        return errors;
    }

}
