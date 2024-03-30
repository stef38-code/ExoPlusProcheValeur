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
        Optional<Integer> premierPlusGrand = getPremierPlusGrand(tableau,valeurRecherche);

        Optional<Integer> dernierPlusPetit = getDernierPlusPetit(tableau,valeurRecherche);


        if(premierPlusGrand.isPresent() && dernierPlusPetit.isPresent()) {
            return rechercheLePlusPetitEcart(valeurRecherche, premierPlusGrand.get(), dernierPlusPetit.get());
        } else if (premierPlusGrand.isPresent()) {
            return premierPlusGrand.get();
        }
        if (dernierPlusPetit.isEmpty()) {
            throw new PlusProcheValeurException("Error.....Bizarre.....Aucune valeur..");
        }
        return dernierPlusPetit.get();

    }
    private Optional<Integer> getDernierPlusPetit(Collection<Integer> tableau,
                                                  int valeurRecherche){
        //tri decroissant
        Collection<Integer> reverseOrder = tableau.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
        log.info("tri decroissant de la collection {}",reverseOrder);
        return reverseOrder.stream().filter(valeur -> valeur < valeurRecherche).findFirst();
    }
    private Optional<Integer> getPremierPlusGrand(Collection<Integer> tableau,
                                                  int valeurRecherche){
        //tri croissant de la collection
        Collection<Integer> listSorted = tableau.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        log.info("tri croissant de la collection {}",listSorted);
        return listSorted.stream().filter(valeur -> valeur > valeurRecherche).findFirst();
    }
    private int rechercheLePlusPetitEcart(int valeurRecherche,
                                 Integer premierPlusGrand,
                                 Integer dernierPlusPetit) {
        //calcul l'ecart
        Integer ecartGrand = premierPlusGrand - valeurRecherche;
        Integer ecartPetit = valeurRecherche - dernierPlusPetit;
        log.info("ecartGrand: {}",ecartGrand);
        log.info("ecartPetit: {}",ecartPetit);
        if (ecartGrand > ecartPetit) {
            return dernierPlusPetit;
        }else{
            return premierPlusGrand;
        }
    }
}
