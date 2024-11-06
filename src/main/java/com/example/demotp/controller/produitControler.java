package com.prodGroupe.productApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prodGroupe.productApp.models.Produit;
import com.prodGroupe.productApp.services.ProduitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/produits")
public class produitControler {
@Autowired
private ProduitService produitService;


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
