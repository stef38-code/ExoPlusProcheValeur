package org.example.exo;

import java.util.Collection;

public class PlusProcheValeur {
    public Integer rechercher(Collection<Integer> tableau,
                              int valeurRecherche) {
        long count = tableau.stream().filter(valeur -> valeur.equals(valeurRecherche)).count();
        if (count > 0) {
            return valeurRecherche;
        }
        return 0;
    }
}
