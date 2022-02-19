package controller;

import model.SimpleDictionary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.SimpleDictionaryRepository;
import service.SimpleDictionaryValidate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleDictionaryControler {
    @RequestMapping(
            value = "",
            method = {RequestMethod.GET}
    )
    public ModelAndView showFrom(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping(
            value = "",
            method = {RequestMethod.POST}
    )
    public ModelAndView translateEngtoVN(@RequestParam("eng") String eng){
        ModelAndView modelAndView = new ModelAndView("index");
        SimpleDictionaryValidate simpleDictionaryValidate = new SimpleDictionaryValidate();
        HashMap<String,String> validate = simpleDictionaryValidate.validate(eng);

        if(validate.isEmpty()){
            String result = "";
            SimpleDictionaryRepository simpleDictionaryRepository = new SimpleDictionaryRepository();
            HashMap<String,String> map = simpleDictionaryRepository.dictonaryLibrary();
            result = map.get(eng);
            modelAndView.addObject("result",result);
            return modelAndView;
        }else{
            for (Map.Entry<String, String> entry : validate.entrySet()) {
                modelAndView.addObject(entry.getKey(),entry.getValue());
            }
            return modelAndView;
        }

    }

}
