package org.example.exo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Recherche de la plus priche valeur")
class PlusProcheValeurTest {
    private List<Integer> tableau;

    @BeforeEach
    void setUp() {
        tableau = List.of(12,1,8,6,18,9);
    }

    @Test
    @DisplayName("La valeur la plus proche de 8 est 8 (car présent dans le tableau")
    void recherche_Lorsque_huit_Attend_huit() {
        //Conditions préalables (given)
        PlusProcheValeur plusProcheValeur = new PlusProcheValeur();
        //Une action se produit (when)
        Integer resultat = plusProcheValeur.rechercher(tableau,8);
        //Vérifier la sortie (then)
        assertThat(resultat).isEqualTo(8);
    }
    @Test
    @DisplayName("La valeur la plus proche de 7 est 8 (7 est à égale distance de 6 et 8, on prend le plus grand")
    void recherche_Lorsque_sept_Attend_huit() {
        //Conditions préalables (given)
        PlusProcheValeur plusProcheValeur = new PlusProcheValeur();
        //Une action se produit (when)
        Integer resultat = plusProcheValeur.rechercher(tableau,7);
        //Vérifier la sortie (then)
        assertThat(resultat).isEqualTo(8);
    }
    @Test
    @DisplayName("La valeur la plus proche de 14 est 12")
    void recherche_Lorsque_quatorze_Attend_douze() {
        //Conditions préalables (given)
        PlusProcheValeur plusProcheValeur = new PlusProcheValeur();
        //Une action se produit (when)
        Integer resultat = plusProcheValeur.rechercher(tableau,14);
        //Vérifier la sortie (then)
        assertThat(resultat).isEqualTo(12);
    }
    @Test
    @DisplayName("La valeur la plus proche de -999 est 1")
    void recherche_Lorsque_negatif_Attend_un() {
        //Conditions préalables (given)
        PlusProcheValeur plusProcheValeur = new PlusProcheValeur();
        //Une action se produit (when)
        Integer resultat = plusProcheValeur.rechercher(tableau,-999);
        //Vérifier la sortie (then)
        assertThat(resultat).isEqualTo(1);
    }
    @Test
    @DisplayName("La valeur la plus proche de 999 est 18")
    void recherche_Lorsque_superieurAuPlusGrandDuTableau_Attend_DixHuit() {
        //Conditions préalables (given)
        PlusProcheValeur plusProcheValeur = new PlusProcheValeur();
        //Une action se produit (when)
        Integer resultat = plusProcheValeur.rechercher(tableau,999);
        //Vérifier la sortie (then)
        assertThat(resultat).isEqualTo(18);
    }
}
