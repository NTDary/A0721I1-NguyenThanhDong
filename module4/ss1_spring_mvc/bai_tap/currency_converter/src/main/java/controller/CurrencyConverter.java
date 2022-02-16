package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ConverterValidate;

import java.util.List;
import java.util.Map;

@Controller
public class CurrencyConverter {
    @RequestMapping(
            value = "",
            method = {RequestMethod.GET}
    )
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping(
            value = {"/converter"},
            method = {RequestMethod.POST}
    )
    public ModelAndView curencyConverter(@RequestParam("number") String number, @RequestParam("curencyFrom") String fromConvert, @RequestParam("curencyTo") String toConvert){
        float result = 0;
        float rate = 23000;
        ConverterValidate converterValidate = new ConverterValidate();
        Map<String,String> map =  converterValidate.validate(number);
        if(map.isEmpty()){
            switch (fromConvert){
                case "usd":
                    switch (toConvert){
                        case "vnd":
                            result = Float.parseFloat(number) * rate;
                            break;
                        case "usd":
                            result = Float.parseFloat(number);
                            break;
                    }
                    break;
                case "vnd":
                    switch (toConvert){
                        case "vnd":
                            result = Float.parseFloat(number);
                            break;
                        case "usd":
                            result = Float.parseFloat(number) / rate;
                            break;
                    }
                    break;
            }
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("result",result);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("result");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                modelAndView.addObject(entry.getKey(),entry.getValue());
            }
            return modelAndView;
        }

    }
}
