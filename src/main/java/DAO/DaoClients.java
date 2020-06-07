/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ExceptionMetier1;
import java.io.IOException;
import metier.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import list.ListClient1;


/**
 *
 * @author sad
 */
public class DaoClients extends DAO<Clients1> {

    private Statement stmt;
    private ResultSet rS;
   

public DaoClients()throws IOException, SQLException{
    
}

    @Override
    public List<Clients1> select() throws SQLException, ExceptionMetier1, ParseException{
    

    stmt = null;
    String query = "select idClient,raisonSocialeClient,NumeroRueClient, " +
                   "NomdeRueClient,CodepostalClient,VilleClient,TelephoneClient,AdresseMailClient, " +
                   "ComClient,CAClient,NombreEmployeClient" + " from "+ "reverso" +".client";
    try {
        stmt = this.connect.createStatement();
        rS = stmt.executeQuery(query);
        while (rS.next()) {
            
            String rsclient = rS.getString("raisonSocialeClient");
            String NumRue = rS.getString("NumeroRueClient");
            String NomRue = rS.getString("NomdeRueClient");
            String Cp = rS.getString("CodepostalClient");
            String ville = rS.getString("VilleClient");
            String tel =rS.getString("TelephoneClient");
            String mail=rS.getString("adresseMailClient");
            String com=rS.getString("ComClient");
            int Ca =rS.getInt("CAClient");
            int nbEmploye=rS.getInt("NombreEmployeClient");
           
            
            
            Clients1 obj=new Clients1();
            obj.setRaisonSociale(rsclient);
            obj.setNumerodeRue(NumRue);
            obj.setNomdeRue(NomRue);
            obj.setCodePostal(Cp);
            obj.setVille(ville);
            obj.setTelePhone(tel);
            obj.setAdresseMail(mail);
            obj.setCommenTaire(com);
            obj.setChiffredaffaire(Ca);
            obj.setNbrEmploye(nbEmploye);
            
            ListClient1.getListClients().add(obj);
        
        }
      
    } catch (SQLException e ) {
        e.getMessage();
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return ListClient1.getListClients();
}

   
    @Override
    public void update(Clients1 obj) throws SQLException{
    
        
        PreparedStatement stmtP = null; 
        try{
            connect.setAutoCommit(false);
            stmtP=this.connect.prepareStatement("update client set raisonSocialeClient=?,NumeroRueClient=?,"
                + "NomdeRueClient=?,CodepostalClient=?,VilleClient=?,TelephoneClient=?,adresseMailClient=?,"
                + " ComClient=?,CAClient=?,NombreEmployeClient=? where idClient="+obj.getIdT());
            stmtP.setString(1,obj.getRaisonSociale());
            stmtP.setString(2,obj.getNumerodeRue());
            stmtP.setString(3,obj.getNomdeRue());
            stmtP.setString(4,obj.getCodePostal());
            stmtP.setString(5,obj.getVille());
            stmtP.setString(6,obj.getTelePhone());
            stmtP.setString(7,obj.getAdresseMail());
            stmtP.setString(8,obj.getCommenTaire());
            stmtP.setInt(9,obj.getChiffredaffaire());
            stmtP.setInt(10,obj.getNbrEmploye());
            stmtP.executeUpdate();
            connect.commit();
   
        }catch(SQLException e){
            e.getMessage();
            if(connect!=null){
            try {
                System.err.print("Transaction is being rolled back");
                connect.rollback();
            } catch(SQLException excep) {
                excep.getMessage();
            }

            }
        } finally {
        if (stmtP != null) { stmtP.close(); }
        connect.setAutoCommit(true);
        }
        
    }

    @Override
    public void delete(int id) throws SQLException{

        
        PreparedStatement stmtPd = null; 
        try{
            stmtPd=this.connect.prepareStatement("delete from client where idClient="+id);
   
            stmtPd.execute();
        }catch(SQLException e){
            e.getMessage();
        } finally {
        if (stmtPd != null) { stmtPd.close(); }
        }   
    }

    @Override
    public void insert(Clients1 obj) throws SQLException{
    
        
        PreparedStatement stmtPi = null; 
        try{
            this.connect.setAutoCommit(false);
            stmtPi=this.connect.prepareStatement("insert into client ( idClient,raisonSocialeClient,NumeroRueClient,"
                    + "NomdeRueClient,CodepostalClient,VilleClient,TelephoneClient,adresseMailClient,"
                    + " ComClient,CAClient,NombreEmployeClient) values(?,?,?,?,?,?,?,?,?,?,?)");  
   
            stmtPi.setInt(1,obj.getIdT());
            stmtPi.setString(2,obj.getRaisonSociale());
            stmtPi.setString(3,obj.getNumerodeRue());
            stmtPi.setString(4,obj.getNomdeRue());
            stmtPi.setString(5,obj.getCodePostal());
            stmtPi.setString(6,obj.getVille());
            stmtPi.setString(7,obj.getTelePhone());
            stmtPi.setString(8,obj.getAdresseMail());
            stmtPi.setString(9,obj.getCommenTaire());
            stmtPi.setInt(10,obj.getChiffredaffaire());
            stmtPi.setInt(11,obj.getNbrEmploye());
            stmtPi.executeUpdate();
            connect.commit();
            
            
        }catch(SQLException e){
            e.getMessage();
            if(connect!=null){
            try {
                System.err.print("Transaction is being rolled back");
                connect.rollback();
            } catch(SQLException excep) {
                excep.getMessage();
            }

            }
        } finally {
        if (stmtPi != null) { stmtPi.close(); }
        connect.setAutoCommit(true);
        }   
    
    }
    @Override
    public Clients1 find(int i)throws SQLException{
    
        
    Clients1 c=new Clients1();
    stmt = null;
    String query = "select idClient,raisonSocialeClient,NumeroRueClient, " +
                   "NomdeRueClient,CodepostalClient,VilleClient,TelephoneClient,AdresseMailClient, " +
                   "ComClient,CAClient,NombreEmployeClient from "+ "reverso" +".client where idClient="+i;
    try {
        stmt = this.connect.createStatement();
        rS = stmt.executeQuery(query);
        while (rS.next()) {
            String rsclient = rS.getString("raisonSocialeClient");
            String NumRue = rS.getString("NumeroRueClient");
            String NomRue = rS.getString("NomdeRueClient");
            String Cp = rS.getString("CodepostalClient");
            String ville = rS.getString("VilleClient");
            String tel =rS.getString("TelephoneClient");
            String mail=rS.getString("adresseMailClient");
            String com=rS.getString("ComClient");
            int Ca =rS.getInt("CAClient");
            int nbEmploye=rS.getInt("NombreEmployeClient");
           
            
            
            c.setRaisonSociale(rsclient);
            c.setNumerodeRue(NumRue);
            c.setNomdeRue(NomRue);
            c.setCodePostal(Cp);
            c.setVille(ville);
            c.setTelePhone(tel);
            c.setAdresseMail(mail);
            c.setCommenTaire(com);
            c.setChiffredaffaire(Ca);
            c.setNbrEmploye(nbEmploye);
            
            ListClient1.getListClients().add(c);
        
        }
      
    } catch (SQLException e ) {
        e.getMessage();
    }   catch (ExceptionMetier1 ex) {
            Logger.getLogger(DaoClients.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (stmt != null) { stmt.close(); }
    }    
        
    return c;    
    }
}
   

