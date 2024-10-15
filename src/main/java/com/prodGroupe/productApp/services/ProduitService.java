package com.prodGroupe.productApp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prodGroupe.productApp.models.Produit;
import com.prodGroupe.productApp.repositories.ProduitRepository;

@Service
public class ProduitService {

@Autowired
private ProduitRepository produitRepository; 

public List<Produit> findAll(){
    return produitRepository.findAll();
}

public Produit save(Produit produit){
    return produitRepository.save(produit);
}

    
}    

