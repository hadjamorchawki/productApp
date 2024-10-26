package com.example.demotp.controller;

import com.example.demotp.model.Produit;
import com.example.demotp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    // Display all products
    @GetMapping
    public String getAllProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits"; // This matches the template name
    }
    
    // Add a new product
    @PostMapping("/add")
    public String addProduit(Produit produit) {
        produitService.save(produit);
        return "redirect:/produits"; // Redirect to the list of products after adding
    }

    // Show form to edit a product
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            model.addAttribute("produit", produit);
            return "editProduit"; // Updated to point to the edit view (editProduit.html)
        } else {
            return "redirect:/produits"; // Redirect if product is not found
        }
    }

    // Update a product
    @PostMapping("/edit/{id}")
    public String updateProduit(@PathVariable("id") Long id, Produit produitDetails) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            produit.setLibelle(produitDetails.getLibelle());
            produit.setPrix(produitDetails.getPrix());
            produit.setQteStock(produitDetails.getQteStock());
            produitService.save(produit);
        }
        return "redirect:/produits"; // Redirect to the product list after updating
    }

    // Delete a product
    @PostMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Long id) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            produitService.delete(id);
        }
        return "redirect:/produits"; // Redirect to the product list after deletion
    }
}
