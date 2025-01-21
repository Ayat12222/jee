package com.example.microservice_commande.model;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Commande {
    // Getters et Setters
    @Id
    private Long id;                // Identifiant unique de la commande
    private String description;     // Description de la commande
    private int quantite;           // Quantité des produits commandés
    private LocalDate date;         // Date de la commande
    private double montant;         // Montant total de la commande
    private Long idProduit;         // Identifiant du produit associé à la commande (version 2 de la table)

    // Constructeur sans argument
    public Commande() {
    }

    // Constructeur avec tous les arguments
    public Commande(Long id, String description, int quantite, LocalDate date, double montant, Long idProduit) {
        this.id = id;
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
        this.idProduit = idProduit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", date=" + date +
                ", montant=" + montant +
                ", idProduit=" + idProduit +
                '}';
    }
}
