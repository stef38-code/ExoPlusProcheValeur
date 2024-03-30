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

        //tri decroissant
        Collection<Integer> reverseOrder = tableau.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
        log.info(reverseOrder.toString());
        Optional<Integer> dernierPlusPetit = reverseOrder.stream().filter(valeur -> valeur < valeurRecherche).findFirst();


        if(premierPlusGrand.isPresent() && dernierPlusPetit.isPresent()) {
            Integer grand = premierPlusGrand.get();
            Integer petit = dernierPlusPetit.get();

            //calcul l'ecart
            Integer ecartGrand = grand - valeurRecherche;
            Integer ecartPetit = valeurRecherche - petit;
            log.info(String.valueOf(ecartGrand));
            log.info(String.valueOf(ecartPetit));
            if (ecartGrand > ecartPetit) {
                return petit;
            }
        } else if (premierPlusGrand.isPresent()) {
            return premierPlusGrand.get();
        }
        return dernierPlusPetit.get();

    }
}
