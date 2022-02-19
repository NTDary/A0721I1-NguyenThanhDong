package service;

import java.util.HashMap;

public class SimpleDictionaryValidate {
    public HashMap<String,String> validate(String text){
        HashMap<String,String> errors = new HashMap<>();

        if(text == null || text.trim().isEmpty()){
            errors.put("emptyError", "must have a word");
        }else {
            if(text.matches("^[0-9]$")){
                errors.put("StringFormat","String Format");
            }
        }
        return errors;
    }
}
