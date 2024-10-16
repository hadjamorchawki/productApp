package com.example.demotp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotp.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
