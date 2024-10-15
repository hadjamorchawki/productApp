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

@GetMapping
public String getAllProduits(Model model) {
    model.addAttribute("produits", produitService.findAll());             
    return "produits"; //Non de la vue
}

@PostMapping("add")
public String addProduit(Produit produit) {
    produitService.save(produit);
    return "redirect:/produits"; //rediriger vers la liste des produits 
}



}
