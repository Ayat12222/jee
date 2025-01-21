package com.example.microservice_commande.dao;
import com.example.microservice_commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommandeDao  extends JpaRepository<Commande, Long> {

}
