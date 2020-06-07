/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exception.ExceptionMetier1;
import java.util.regex.Pattern;
/**
 *
 * @author CDA03-16
 */
public abstract class Societe1 {
    
    private static int identifiant;
    private int idT;
    private String raisonSociale;
    private String numerodeRue;
    private String nomdeRue;
    private String CodePostal;
    private String Ville;
    private String telePhone;
    private String adresseMail;
    private String commenTaire;
    
public Societe1(){
    this.identifiant++;
    this.setIdT(this.identifiant); 
   
    
    
} 
public Societe1 (String p_raisonsociale,String p_numerodeRue,String p_nomdeRue,String p_CodePostal,String p_Ville,String p_telephone,String p_adresseMail,String p_Commentaire)throws ExceptionMetier1{
    this.setRaisonSociale(p_raisonsociale);
    this.setNumerodeRue(p_numerodeRue);
    this.setNomdeRue(p_nomdeRue);
    this.setCodePostal(p_CodePostal);
    this.setVille(p_Ville);
    this.setTelePhone(p_telephone);
    this.setAdresseMail(p_adresseMail);
    this.setCommenTaire(p_Commentaire);
    this.identifiant++;
    this.setIdT(this.identifiant);
    
}
    
    public static int getIdentifiant() {
        return identifiant;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }
    
    public String getRaisonSociale() {
        return raisonSociale;
    }

    public String getNumerodeRue() {
        return numerodeRue;
    }

    public String getNomdeRue() {
        return nomdeRue;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public String getVille() {
        return Ville;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public String getCommenTaire() {
        return commenTaire;
    }

    public static void setIdentifiant(int identifiant) {
        Societe1.identifiant = identifiant;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param raisonSociale
     * @throws ExceptionMetier :leve une exception de type metier 
     */
    public void setRaisonSociale(String raisonSociale) throws ExceptionMetier1 {
        if(raisonSociale==null ||raisonSociale.trim().isEmpty()){
            throw new ExceptionMetier1("la raison sociale doit etre renseigne");
        }
        if(!raisonSociale.substring(0,1).equals(raisonSociale.substring(0,1).toUpperCase())){
           throw new ExceptionMetier1("la raison sociale  doit commencer par une majuscule");
        }
        this.raisonSociale = raisonSociale; 
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param numerodeRue
     * @throws ExceptionMetier : leve une exception de type metier 
     */
    public void setNumerodeRue(String numerodeRue) throws ExceptionMetier1 {
        numerodeRue=numerodeRue.trim();
        boolean p=Pattern.matches("^[0-9]{1,3}$",numerodeRue);
        
        if(numerodeRue==null || numerodeRue.isEmpty()){
            throw new ExceptionMetier1("le numero de rue doit etre renseigne");
        }
        
        if(!p){
            throw new ExceptionMetier1("numero de rue numerique");
            
        }
        this.numerodeRue = numerodeRue;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param nomdeRue
     * @throws ExceptionMetier :leve une exception de type metier 
     */
    public void setNomdeRue(String nomdeRue) throws ExceptionMetier1 {
        if(nomdeRue==null || nomdeRue.isEmpty()){
            throw new ExceptionMetier1("l'adresse doit etre renseigne");
        }
        this.nomdeRue = nomdeRue;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param CodePostal
     * @throws ExceptionMetier :leve une exception de type metier
     */
    public void setCodePostal(String CodePostal) throws ExceptionMetier1 {
        CodePostal=CodePostal.trim();
        boolean p=Pattern.matches("^[0-9]{5,5}$",CodePostal);
        if(CodePostal.isEmpty()){
            throw new ExceptionMetier1("le code postal doit etre renseigne");
        }
        if(!p){
            throw new ExceptionMetier1("le code postal n'est pas valide");
        }
        this.CodePostal = CodePostal;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param Ville
     * @throws ExceptionMetier :leve une exception de type metier
     */
    public void setVille(String Ville) throws ExceptionMetier1 {
        if(Ville==null || Ville.isEmpty()){
            throw new ExceptionMetier1("la ville doit etre renseigne");
        }
        this.Ville = Ville;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param telePhone
     * @throws ExceptionMetier :leve une exception de type metier
     */
    public void setTelePhone(String telePhone) throws ExceptionMetier1 {
        telePhone=telePhone.trim();
        boolean p=Pattern.matches("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$",telePhone);
        if(telePhone==null ||telePhone.isEmpty()){
            throw new ExceptionMetier1("le numero de telephone doit etre renseigne");
        }
        if(!p){
            
            throw new ExceptionMetier1("le numero de telephone  doit etre valide");
            
        }
        
        this.telePhone = telePhone;
    }
    /**
     * accesseur en ecriture : teste le parametre si valide sinon levee d'exception
     * @param adresseMail
     * @throws ExceptionMetier :leve une exception de type metier
     */
    public void setAdresseMail(String adresseMail) throws ExceptionMetier1 {
        boolean p=Pattern.matches("^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$",adresseMail);
        if(adresseMail==null || adresseMail.isEmpty()){
            throw new ExceptionMetier1("l'adresse mail doit etre renseigne");
        }
        if(!p){
            throw new ExceptionMetier1("adresse mail non valide");
        }
        this.adresseMail = adresseMail;
    }
    /**
     * accesseur en ecriture : modifie le parametre
     * @param commenTaire 
     */
    public void setCommenTaire(String commenTaire) {
        this.commenTaire = commenTaire;
    }
    
@Override
public String toString(){
    
    return getIdT()+" "+getRaisonSociale()+" "+getNumerodeRue()+","+getNomdeRue()+" "+getCodePostal()+" "+getVille()+" "+getTelePhone()+" "+getAdresseMail()+" "+getCommenTaire();
}
}
