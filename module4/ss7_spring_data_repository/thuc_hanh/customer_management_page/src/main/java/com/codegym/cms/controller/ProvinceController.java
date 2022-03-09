package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.ICustomerService;
import com.codegym.cms.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView listProvinces(@RequestParam(name = "namePro", required = false, defaultValue = "") String name, @PageableDefault(size = 5) Pageable pageable) {
        //Page<Province> provinces = provinceService.findAll(pageable);
        Page<Province> provinces = provinceService.searchByName(name,pageable);
        long totalItems = provinces.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        modelAndView.addObject("totalItems", totalItems);
        modelAndView.addObject("namePro", name);
        modelAndView.addObject("currentPage", pageable.getPageNumber() - 1);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createProvinces(){
       ModelAndView modelAndView = new ModelAndView("/province/create");
       modelAndView.addObject("province",new Province());
       return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveProvinces(Province province, RedirectAttributes ra){
        ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
        provinceService.save(province);
        ra.addFlashAttribute("message","Added successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editProvince(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province",province.get());
            return modelAndView;
        }else{
            return new ModelAndView("error404");
        }
    }
//    @GetMapping("/view/{id}")
//    public ModelAndView viewProvince(@PathVariable Long id, @PageableDefault(size = 5) Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/province/view");
//        Province province = provinceService.searchByProvince(id);
//        if(province != null){
//            modelAndView.addObject("province",province);
//            //modelAndView.addObject("province",provinceService.findById(id));
//            return modelAndView;
//        }else {
//            return new ModelAndView("error404");
//        }
//    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProvince(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("redirect:/provinces");
            provinceService.remove(id);
            return modelAndView;
        }else {
            return new ModelAndView("error404");
        }
    }
}
