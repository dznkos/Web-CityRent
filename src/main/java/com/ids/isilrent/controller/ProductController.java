package com.ids.isilrent.controller;

import com.ids.isilrent.model.Product;
import com.ids.isilrent.repository.JdbcProductRepository;
import com.ids.isilrent.repository.JdbcSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/mc")
public class ProductController {
    @Autowired
    JdbcProductRepository jdbcProductRepository;

    @Autowired
    JdbcSupplierRepository jdbcSupplierRepository;

    @GetMapping("product/add/")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        //model.addAttribute("sku", id);
        model.addAttribute("welcome","bienvenido a agregar producto 2019");
        return "product-add";
    }
    @GetMapping("product/update/{id}")
    public String updateProduct(@PathVariable String id, Model model){
        model.addAttribute("products", new Product());
        model.addAttribute("sku", id);
        model.addAttribute("welcome","bienvenido a actualizar producto 2019");
        return "product-edit";
    }
    @PostMapping("/product/save")
    public String saveProduct(Product product, Model model){
        jdbcProductRepository.create(product);
        model.addAttribute("products", jdbcProductRepository.findAll());
        return "list-product";
    }
    @GetMapping("/product")
    public String getProductlist(Model model){

        model.addAttribute("products", jdbcProductRepository.findAll());
        return "list-product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteSupplier(@PathVariable String id, Model model){
        jdbcProductRepository.delete(id);
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "list-supplier";
    }
}
