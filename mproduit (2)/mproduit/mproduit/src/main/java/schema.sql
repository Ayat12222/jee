
CREATE TABLE IF NOT EXISTS produit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    prix DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Ajouter une contrainte d'unicité sur le nom (si nécessaire)
CREATE UNIQUE INDEX idx_nom_produit ON produit(nom);
