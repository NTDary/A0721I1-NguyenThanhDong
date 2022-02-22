package controller;

import model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailSettingController {
    @GetMapping("/")
    public ModelAndView showSetting(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mailSetting", new MailSetting());
        return modelAndView;
    }

    @PostMapping("mail")
    public ModelAndView saveSetting(@ModelAttribute("mailSetting") MailSetting mailSetting){
        ModelAndView modelAndView = new ModelAndView("showSetting");

        return modelAndView;
    }
}
