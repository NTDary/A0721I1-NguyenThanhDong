package service;

import controller.CurrencyConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public class ConverterValidate {
    public HashMap<String,String> validate(String number){
        HashMap<String,String> errors = new HashMap<>();

        if(number == null || number.trim().isEmpty()){
            errors.put("emptyError", "must have a number");
        }else {
            try {
                Float.parseFloat(number);
            } catch (NumberFormatException e) {
                errors.put("numberformat","Invalid price value");
            }
        }
        return errors;
    }
}
