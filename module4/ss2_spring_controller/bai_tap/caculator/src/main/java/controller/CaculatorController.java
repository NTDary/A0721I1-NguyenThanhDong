package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CaculatorService;
import service.impl.ICaculatorService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CaculatorController {
    private ICaculatorService iCaculatorService = new CaculatorService();
    private final String ADDITION = "Addition(+)";
    private final String SUBTRACTION = "Subtraction(-)";
    private final String MULTIPLICATION = "Multiplication(X)";
    private final String DIVISION = "Division(/)";

    @RequestMapping("/")
    public ModelAndView showCaculaotor() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/caculator")
    public ModelAndView chooseCaculator(@RequestParam String numberA, String numberB, String choose) {
        ModelAndView modelAndView = new ModelAndView("result");
        HashMap<String, String> validate = iCaculatorService.validate(numberA, numberB);

        if (validate.isEmpty()) {
            float number1 = Float.parseFloat(numberA);
            float number2 = Float.parseFloat(numberB);
            float result = 0;
            String error = "";
            switch (choose) {
                case ADDITION:
                    result = iCaculatorService.add(number1, number2);
                    modelAndView.addObject("result", result);
                    break;
                case SUBTRACTION:
                    result = iCaculatorService.sub(number1, number2);
                    modelAndView.addObject("result", result);
                    break;
                case MULTIPLICATION:
                    result = iCaculatorService.multi(number1, number2);
                    modelAndView.addObject("result", result);
                    break;
                case DIVISION:
                    if (number2 != 0) {
                        result = iCaculatorService.div(number1, number2);
                        modelAndView.addObject("result",result);
                    } else {
                        modelAndView.addObject("result", "Cannot divide by zero");
                    }
            }

            return modelAndView;
        } else {
            for (Map.Entry<String, String> entry : validate.entrySet()) {
                modelAndView.addObject(entry.getKey(), entry.getValue());
            }
            return modelAndView;
        }

    }
}
