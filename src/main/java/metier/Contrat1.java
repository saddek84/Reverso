/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import exception.ExceptionMetier1;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author sad
 */
public class Contrat1 {
  
  private static  int ident; 
  private int idContrat;
  private String lblContrat;
  private double montantContrat;
  private  LocalDate dateDebutContrat;
  private  LocalDate dateFinContrat;
  public final static DateTimeFormatter DATEFORME =DateTimeFormatter.ofPattern("dd/MM/yyyy");
  
  
  public Contrat1()
  {
    this.ident++;
    this.setIdContrat(this.ident);
  }
/**
 * constructeur
 * @param idContrat
 * @param lblContrat
 * @param montantContrat
 * @param dateDebutContrat
 * @param dateFinContrat 
 */
 public Contrat1(String p_lblContrat, double p_montantContrat, String p_dateDebutContrat, String p_dateFinContrat) throws ExceptionMetier1, ParseException {
        this.ident++;
        this.setIdContrat(this.ident);
        this.setLblContrat(p_lblContrat);
        this.setMontantContrat(p_montantContrat);
        this.setDateDebutContrat(p_dateDebutContrat);
        this.setDateFinContrat(p_dateFinContrat);
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    public void setLblContrat(String lblContrat) throws ExceptionMetier1 {
        if(lblContrat ==null || lblContrat.isEmpty()){
            throw new ExceptionMetier1("Libelle du Contrat non renseigne");
        }
        this.lblContrat = lblContrat;
    }

    public void setMontantContrat(double montantContrat)throws ExceptionMetier1 {
        if(montantContrat< 0){
            throw new ExceptionMetier1("valeur non correcte");
            
        }
        this.montantContrat=montantContrat;
    }

    public void setDateDebutContrat(String dateDebutContrat)throws ExceptionMetier1, ParseException {
        
        if(dateDebutContrat==null || dateDebutContrat.isEmpty()){
            throw new ExceptionMetier1("date non renseigne");
        }
        try{
            
            
            this.dateDebutContrat=LocalDate.parse(dateDebutContrat);
            
        
        }catch(DateTimeParseException de){
          
           JOptionPane.showMessageDialog(null,"date invalide : " +dateDebutContrat);
                 
        }    
    }

    public void setDateFinContrat(String dateFinContrat)throws ExceptionMetier1, DateTimeParseException {
        
        if(dateFinContrat==null || dateFinContrat.isEmpty()){
            throw new ExceptionMetier1("date non renseigne");
        }
        try{
            this.dateFinContrat=LocalDate.parse(dateFinContrat);
        
        }catch(DateTimeParseException de){
           
           JOptionPane.showMessageDialog(null,"date invalide : " +dateFinContrat);
           
        
        }
        
      
    }

    public int getIdContrat() {
        return idContrat;
    }

    public String getLblContrat() {
        return lblContrat;
    }

    public double getMontantContrat() {
        return montantContrat;
    }

    public LocalDate getDateDebutContrat() {
        return dateDebutContrat;
    }

    public LocalDate getDateFinContrat() {
        return dateFinContrat;
    }
          
 
  
 
}
