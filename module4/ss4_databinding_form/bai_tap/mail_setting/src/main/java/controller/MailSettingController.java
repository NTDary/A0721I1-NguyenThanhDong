package controller;

import model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        //Goi cac thuoc tinh trong doi tuong employee
        modelAndView.addObject("language", mailSetting.getLanguage());
        modelAndView.addObject("pageSize", mailSetting.getPageSize());
        modelAndView.addObject("filler", mailSetting.isFiller());
        modelAndView.addObject("signature", mailSetting.getSignature());
        return modelAndView;
    }
}
