package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille() {
        this.villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
                "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
                "Hong Kong", "Dubaï", "Rome", "Istanbul");
    }

    public List<String> rechercher(String mot) throws NotFoundException {
        if (mot.length() < 2) {
            throw new NotFoundException("Le texte de recherche doit contenir au moins 2 caractères.");
        }

        if (mot.equals("*")) {
            return new ArrayList<>(villes);
        }

        return villes.stream()
                .filter(ville -> ville.toLowerCase().contains(mot.toLowerCase()))
                .collect(Collectors.toList());
    }
}