package com.example.product.web;

import com.example.product.dto.ProductDto;
import com.example.product.dto.SearchDto;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public String home(Model model) {
        var all = service.findAll();
        model.addAttribute("products", all);
        return "home";
    }

    @PostMapping
    public String add(ProductDto dto, Model model) {
        service.creatProduct(dto);
        model.addAttribute("products", service.findAll());
        return "home";
    }

    @PostMapping("/search")
    public String search(SearchDto dto, Model model) {
        var result = service.findBy(dto);
        model.addAttribute("products", result);
        return "home";
    }

    @PostMapping("/search_quantity")
    public String searchQuantity(SearchDto dto, Model model) {
        var result = service.findByQuantity(dto);
        model.addAttribute("products", result);
        return "home";
    }

    @PostMapping("/search_cost")
    public String searchCost(SearchDto dto, Model model) {
        var result = service.findByCost(dto);
        model.addAttribute("products", result);
        return "home";
    }

    @PostMapping("/search_delivery")
    public String searchDelivery(SearchDto dto, Model model) {
        var result = service.findByDeliveryTrue();
        model.addAttribute("products", result);
        return "home";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        service.deleteAll();
        return "redirect:/product";
    }
}