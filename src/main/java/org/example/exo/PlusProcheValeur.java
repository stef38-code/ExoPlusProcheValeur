package org.example.exo;

import java.util.*;
import java.util.stream.Collectors;

public class PlusProcheValeur {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PlusProcheValeur.class);

    public Integer rechercher(Collection<Integer> tableau,
                              int valeurRecherche) {
        //si present dans la collection
        boolean isPresentInCollection = tableau.stream().anyMatch(valeur -> valeur.equals(valeurRecherche));
        if (isPresentInCollection ) {
            return valeurRecherche;
        }
        //tri croissant de la collection
        Collection<Integer> listSorted = tableau.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        log.info(listSorted.toString());
        Optional<Integer> premierPlusGrand = listSorted.stream().filter(valeur -> valeur > valeurRecherche).findFirst();
        log.info(String.valueOf(premierPlusGrand.get()));

        return premierPlusGrand.orElse(0);

    }
}
