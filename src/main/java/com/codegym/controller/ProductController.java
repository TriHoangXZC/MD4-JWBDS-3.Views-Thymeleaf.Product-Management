package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products/list")
    public ModelAndView showProductList() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        List<Product> products = productService.displayAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/products/create")
    public ModelAndView showCreateProductForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/products/create")
    public ModelAndView createProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products/list");
        productService.createProduct(product);
        return modelAndView;
    }

    @GetMapping("/products/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable int id){
        Product product = productService.findProductById(id);
        return new ModelAndView("/product/edit", "product", product);
    }

    @PostMapping("/products/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id, @ModelAttribute Product product){
        productService.editProductById(id, product);
        return new ModelAndView("redirect:/products/list");
    }

    @GetMapping("/products/delete/{id}")
    public ModelAndView showDeleteProductForm(@PathVariable int id) {
        Product product = productService.findProductById(id);
        return new ModelAndView("/product/delete", "product", product);
    }

    @PostMapping("/products/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return new ModelAndView("redirect:/products/list");
    }

    @GetMapping("/products/{id}")
    public ModelAndView showProductDetail(@PathVariable int id) {
        Product product = productService.findProductById(id);
        return new ModelAndView("/product/view", "product", product);
    }
}
