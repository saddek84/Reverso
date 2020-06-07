/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import DAO.*;
import exception.ExceptionMetier1;
import list.*;
import java.text.ParseException;

import frame.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.*;
/**
 *
 * @author CDA03-16
 */
public class GestionClientProspect1  {

private static final Logger logger = Logger.getLogger("GestionClientProspect1.class");
    
    public static void main(String[] args) throws ExceptionMetier1, ParseException, SQLException, IOException {
        // TODO code application logic here
   
    DAO<Clients1> daoc=DAOfactory.getDaoClients();
    DAO<Prospect1> daop=DAOfactory.getDaoProspect();
    
    
    daoc.select();
    daop.select();
    
    logger.log(Level.SEVERE, "erreur");
     
    Collections.sort(ListClient1.getListClients(), Comparer1.compareNom);
    Collections.sort(ListProspect1.getListProspect(),Comparer1.compareNom);
    
    MenuPrincipal1 m=new MenuPrincipal1();
        m.setVisible(true);
        
     

      
    
     
      
      
      
       
    }
    
}
