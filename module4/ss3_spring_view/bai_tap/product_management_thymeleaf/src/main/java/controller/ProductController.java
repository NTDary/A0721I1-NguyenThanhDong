package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.Param;
import service.IProductService;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService  iProductService = new ProductService();

    @GetMapping("")
    public ModelAndView index(){
        List<Product> productList = iProductService.showAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("product",productList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create","product", new Product());
    }
    @PostMapping("/save")
    public ModelAndView save(Product product, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product/");
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);

        redirectAttrs.addFlashAttribute("message", "Added successfully");

        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("edit","product",iProductService.findById(id));
    }
    @PostMapping("/update")
    public ModelAndView update(Product product, RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Updated successfully");
        return new ModelAndView("redirect:/product/");
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        return new ModelAndView("delete","product",iProductService.findById(id));
    }
    @PostMapping("/delete")
    public ModelAndView delete(Product product, RedirectAttributes redirectAttributes){
        iProductService.deleteProduct(product.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted successfully");
        return new ModelAndView("redirect:/product/");
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        return new ModelAndView("view","product",iProductService.findById(id));
    }
    @PostMapping("/search")
        public ModelAndView search(@RequestParam("keyword") String keyword){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("product",iProductService.findByName(keyword));
        modelAndView.addObject("keyword",keyword);
        return modelAndView;
    }

}
