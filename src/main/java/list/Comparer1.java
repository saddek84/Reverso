/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Comparator;
import metier.*;

/**
 *
 * @author CDA03-16
 */
public abstract class Comparer1 {
    
   
// surcharge de la methode  compareTo de la classe Comparator     
public static Comparator<Societe1> compareNom = new Comparator<Societe1>() {
    @Override
    public int compare(Societe1 s1, Societe1 s2) {
            return s1.getRaisonSociale().compareTo(s2.getRaisonSociale());
        
    }
};
       


    
}
