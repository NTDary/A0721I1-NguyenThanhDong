package controller;

import model.InforToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToKhaiYTeController {
    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("inforToKhaiYTe", new InforToKhaiYTe());

        return modelAndView;
    }

    @PostMapping("/send")
    public ModelAndView sendForm(@ModelAttribute("form") InforToKhaiYTe inforToKhaiYTe){
        ModelAndView modelAndView = new ModelAndView("send");

        modelAndView.addObject("inforToKhaiYTe",inforToKhaiYTe);
        return modelAndView;

    }
}
