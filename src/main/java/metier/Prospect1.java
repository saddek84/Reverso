/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exception.ExceptionMetier1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author CDA03-16
 */
public class Prospect1 extends Societe1{
    
    private String datedeProspection;
    private String prospectInterresse;

    
public Prospect1() {
    
}
    
    
    
    
public Prospect1 (String p_raisonsociale,String p_numerodeRue,String p_nomdeRue,String p_CodePostal,String p_Ville,String p_telephone,String p_adresseMail,String p_Commentaire,String p_datedeprospection,String p_prospectInterresse)throws ExceptionMetier1, ParseException {
   
    
    super(p_raisonsociale,p_numerodeRue,p_nomdeRue,p_CodePostal,p_Ville,p_telephone,p_adresseMail,p_Commentaire);
    this.setDatedeProspection(p_datedeprospection);
    this.setProspectInterresse(p_prospectInterresse);
    
    
}
/**
 * surcharge de la methode toString()
 * @return : retourne une chaine  
 */
@Override
public String toString(){
    String sp = super.toString();
    return sp+" "+getDatedeProspection()+" "+getProspectInterresse();
}

public String getDatedeProspection() {
    return datedeProspection;
}


public String getProspectInterresse() {
    return prospectInterresse;
}
/**
 * accesseur en ecriture :teste le parametre si valide sinon levee d'exception
 * @param datedeProspection
 * @throws ExceptionMetier
 * @throws ParseException 
 */
public void setDatedeProspection(String datedeProspection)throws ExceptionMetier1, ParseException{
   DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
   Date date=null;
    if(datedeProspection.isEmpty()){
        throw new ExceptionMetier1("date non renseigne");
    }
    if(datedeProspection.equals(date=dateformat.parse(datedeProspection))){
        throw new ParseException("Format invalide",0);
    }
        
    this.datedeProspection =datedeProspection; 
     
}
/**
 * accesseur en ecriture :teste le parametre si valide sinon levee d'exception
 * @param prospectInterresse 
 */
public void setProspectInterresse(String prospectInterresse) {
    this.prospectInterresse = prospectInterresse;
}


    
}
