package com.casestudy.controller;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.user.User;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user" ,new User());
        return "login";
    }
    @GetMapping("/index")
    public String show() {
        return "index";
    }

    @GetMapping("/403")
    public String getPage403(){
        return "/403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
            Cookie cookie = new Cookie("remember-me","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }

}
