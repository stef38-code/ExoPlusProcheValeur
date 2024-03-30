package org.example.exo;

import java.util.Collection;

public class PlusProcheValeur {
    public Integer rechercher(Collection<Integer> tableau,
                              int valeurRecherche) {
        //si present dans la collection
        boolean isPresentInCollection = tableau.stream().anyMatch(valeur -> valeur.equals(valeurRecherche));
        if (isPresentInCollection ) {
            return valeurRecherche;
        }
        return 0;
    }
}
