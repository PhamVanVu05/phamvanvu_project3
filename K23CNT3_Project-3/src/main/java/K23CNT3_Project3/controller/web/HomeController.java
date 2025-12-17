package K23CNT3_Project3.controller.web;

import K23CNT3_Project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Trang chủ");
        model.addAttribute("featuredProducts", productService.getFeaturedProducts());
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("pageTitle", "Sản phẩm");
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "Giới thiệu");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Liên hệ");
        return "contact";
    }
}