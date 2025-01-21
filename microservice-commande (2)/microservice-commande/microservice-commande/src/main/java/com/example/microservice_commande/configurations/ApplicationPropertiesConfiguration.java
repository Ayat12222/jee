package com.example.microservice_commande.configurations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationPropertiesConfiguration {
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    public int getCommandesLast() {
        return commandesLast;
    }


    public void setCommandesLast(int commandesLast) {
        this.commandesLast = commandesLast;
    }
}
