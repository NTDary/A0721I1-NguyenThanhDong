package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CondimentsService;

@Controller
public class CondimentsController {
    @RequestMapping("/")
    public ModelAndView showCondiments(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        CondimentsService condimentsService = new CondimentsService();
        condimentsService.save(condiment);
        model.addAttribute("condiment",condimentsService.showCondiments());
      return "result";
    }
}
