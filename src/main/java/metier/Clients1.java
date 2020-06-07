/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exception.ExceptionMetier1;
import list.*;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author CDA03-16
 */
public class Clients1 extends Societe1 {
    
    private int chiffredaffaire;
    private int nbrEmploye;
    private  List<Contrat1> listContrat=new ArrayList<Contrat1>();  
   
    
public Clients1() {
    this.setListContrat(listContrat);
}
    


public Clients1(String p_raisonsociale,String p_numerodeRue,String p_nomdeRue,String p_CodePostal,String p_Ville,String p_telephone,String p_adresseMail,String p_Commentaire,int chiffredaffaire,int nbrEmploye)throws ExceptionMetier1 {
        
    super(p_raisonsociale,p_numerodeRue,p_nomdeRue,p_CodePostal,p_Ville,p_telephone,p_adresseMail,p_Commentaire);
    this.setChiffredaffaire(chiffredaffaire);
    this.setNbrEmploye(nbrEmploye);
    


}

@Override
public String toString(){
    String sp = super.toString();
    return sp+getChiffredaffaire()+getNbrEmploye();
}


public int getChiffredaffaire() {
    return chiffredaffaire;
}

public int getNbrEmploye() {
    return nbrEmploye;
}
/**
 * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
 * @param chiffredaffaire
 * @throws ExceptionMetier :leve une exception de type metier
 */
public void setChiffredaffaire(int chiffredaffaire) throws ExceptionMetier1 {
    
    if(chiffredaffaire > 200){
    this.chiffredaffaire = chiffredaffaire;
    }
    else {
        
        throw new ExceptionMetier1("le chiffre d'affaire doit etre superieur à 200");
    }
          
}
/**
 * accesseur en ecriture :teste le parametre si valide sinon levee d'exception
 * @param nbrEmploye
 * @throws ExceptionMetier :leve une exception de type metier
 */
public void setNbrEmploye(int nbrEmploye) throws ExceptionMetier1 {
    if(nbrEmploye >0){
    this.nbrEmploye = nbrEmploye;
    }
    else{
        
        throw new ExceptionMetier1("le nombre d'employés doit etre superieur à zero");
    }
       
}

public  List<Contrat1> getListContrat() {
        return listContrat;

}

public  void setListContrat(List<Contrat1> listContrat) {
    this.listContrat = listContrat;

}

    


}
