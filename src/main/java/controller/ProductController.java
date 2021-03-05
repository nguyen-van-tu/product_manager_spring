package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IProduct;

import service.ProductServiceORM;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProduct productService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.fillAll();
        modelAndView.addObject("listProduct", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("p", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) {
        int id = productService.fillAll().size();
        product.setId(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.save(product);

        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showFormEdit(@PathVariable int id, ModelMap modelMap) {
        Product product = productService.findById(id);
        modelMap.addAttribute("product", product);
        return "edit";
    }


//    @PostMapping("/edit/{id}")
//    public ModelAndView editStudent(@PathVariable int id, @RequestParam String name, double price, String description) {
//        Product product = new Product(id, name,price , description);
//        productService.update(product, id);
//        return new ModelAndView("redirect:/product");
//    }
@PostMapping("/edit/{id}")
public ModelAndView editStudent(@ModelAttribute Product product){
    productService.update(product);
    return new ModelAndView("redirect:" + "/product");
}
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        productService.delete(id);
        return new ModelAndView("redirect:/product");
    }
    @PostMapping("")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> result = productService.findByName(search);
        modelAndView.addObject("listProduct", result);
        return modelAndView;
    }


}
