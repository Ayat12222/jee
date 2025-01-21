package com.mproduit.mproduit.web.controller;


import com.mproduit.mproduit.configurations.*; 
import com.mproduit.mproduit.dao.*; 
import com.mproduit.mproduit.model.*; 
import com.mproduit.mproduit.web.exception.*; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.actuate.health.Health; 
import org.springframework.boot.actuate.health.HealthIndicator; 
import org.springframework.cloud.context.config.annotation.RefreshScope; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController; 

import java.util.List; 
import java.util.Optional; 

@RestController 
public class ProductController implements HealthIndicator { 

@Autowired 
ProductDao productDao; 

@Autowired 
ApplicationPropertiesConfiguration appProperties; 

// Affiche la liste de tous les produits disponibles 
@GetMapping(value = "/Produits") 
public List<Product> listeDesProduits() throws ProductNotFoundException { 
  
 System.out.println(" ********* ProductController listeDesProduits() "); 
 List<Product> products = productDao.findAll(); 

 if (products.isEmpty()) 
  throw new ProductNotFoundException("Aucun produit n'est disponible à la vente"); 

 List<Product> listeLimitee = products.subList(0, 
appProperties.getLimitDeProduits()); 

 return listeLimitee; 

} 

// Récuperer un produit par son id 
@GetMapping(value = "/Produits/{id}") 
public Optional<Product> recupererUnProduit(@PathVariable int id) throws ProductNotFoundException { 
 System.out.println(" ********* ProductController recupererUnProduit(@PathVariable int id) "); 
  
 Optional<Product> product = productDao.findById(id);
if (!product.isPresent()) 
throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas"); 
return product; 
} 
@Override 
public Health health() { 
System.out.println("****** Actuator : ProductController health() "); 
List<Product> products = productDao.findAll(); 
if (products.isEmpty()) { 
return Health.down().build(); 
} 
return Health.up().build(); 
} 
} 