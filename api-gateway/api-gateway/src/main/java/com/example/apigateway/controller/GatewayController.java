package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/api/commandes")
    public ResponseEntity<?> routeCommandes() {
        String url = "http://localhost:9001/commandes";
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/api/commandes/{id}")
    public ResponseEntity<?> routeCommandeById(@PathVariable Long id) {
        String url = "http://localhost:9001/commandes/" + id;
        return restTemplate.getForEntity(url, String.class);
    }

    @PostMapping("/api/commandes")
    public ResponseEntity<?> addCommande(@RequestBody Object commande) {
        String url = "http://localhost:9001/commandes";
        return restTemplate.postForEntity(url, commande, String.class);
    }
}
