/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ExceptionMetier1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import list.ListClient1;
import metier.Clients1;
import metier.Contrat1;

/**
 *
 * @author sad
 */
public class DaoContrat extends DAO<Contrat1> {
    
    private Statement stmt;
    private ResultSet rS;


public DaoContrat()throws IOException, SQLException{
    
}

    @Override
    public List<Contrat1> select() throws SQLException, ExceptionMetier1, ParseException {
    
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

           
    }
    @Override
    public Contrat1 find(int i) throws SQLException {
    
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void insert(Contrat1 obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Contrat1 obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public  List<Contrat1> findClients(Clients1 c) throws ExceptionMetier1, ParseException, SQLException{
    
    stmt = null;
    String query = "select idCOntrat,LblContrat,montantContrat, " +
                   "dateDebut,dateFin" + " from "+ "reverso" +".contrat where  idClientContrat="+c.getIdT();
    try {
        stmt = this.connect.createStatement();
        rS = stmt.executeQuery(query);
        
        while (rS.next()) {
            
            int idContrat = rS.getInt("idContrat");
            String lblContrat = rS.getString("LblContrat");
            double montant = rS.getDouble("montantContrat");
            String dateDebut = rS.getString("dateDebut");
            String dateFin = rS.getString("dateFin");
            Contrat1 obj=new Contrat1();  
            obj.setIdContrat(idContrat);
            obj.setLblContrat(lblContrat);
            obj.setMontantContrat(montant);
            obj.setDateDebutContrat(dateDebut);
            obj.setDateFinContrat(dateFin);
            c.getListContrat().add(obj);
        
        
        }    
    } catch (SQLException e ) {
        e.getMessage();
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return c.getListContrat();    
        
    }
}
