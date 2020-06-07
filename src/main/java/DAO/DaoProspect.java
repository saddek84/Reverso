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
import list.ListProspect1;

/**
 *
 * @author sad
 */
public class DaoProspect extends DAO<Prospect1> {
     private Statement stmt;
    private ResultSet rS;
   

public DaoProspect()throws IOException, SQLException{
    
}

public List<Prospect1> select() throws SQLException, ExceptionMetier1, ParseException{
    

    stmt = null;
    String query = "select idProspect,Rsprospect,NumRueProsp, " +
                   "NomRueProspect,CPprospect,VilleProspect,TelProspect,MailProspect, " +
                   "ComProspect,DatedeProspection,ProspInter" + " from "+"reverso"+".prospect";
    try {
        stmt = this.connect.createStatement();
        rS = stmt.executeQuery(query);
        while (rS.next()) {
            String rsprospect = rS.getString("Rsprospect");
            String NumRue = rS.getString("NumRueProsp");
            String NomRue = rS.getString("NomRueProspect");
            String Cp = rS.getString("CPprospect");
            String ville = rS.getString("VilleProspect");
            String tel =rS.getString("TelProspect");
            String mail=rS.getString("MailProspect");
            String com=rS.getString("ComProspect");
            String DateProsp =rS.getString("DatedeProspection");
            String prospInter=rS.getString("ProspInter");
           
            System.out.println(rsprospect + "\t" + NumRue +
                               "\t" + NomRue + "\t" + Cp +
                               "\t" + ville + "\t" + tel + "\t" +mail+
                                "\t"+com+"\t"+DateProsp+"\t"+prospInter);
            
        Prospect1 p=new Prospect1();
        p.setRaisonSociale(rsprospect);
        p.setNumerodeRue(NumRue);
        p.setNomdeRue(NomRue);
        p.setCodePostal(Cp);
        p.setVille(ville);
        p.setTelePhone(tel);
        p.setAdresseMail(mail);
        p.setCommenTaire(com);
        p.setDatedeProspection(DateProsp);
        p.setProspectInterresse(prospInter);
        ListProspect1.getListProspect().add(p);
        }
    }catch(SQLException e){
           e.getMessage();
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return ListProspect1.getListProspect();
}

    @Override
    public void insert(Prospect1 obj) throws SQLException {
        
     PreparedStatement stmtPi = null; 
        try{
            connect.setAutoCommit(false);
            stmtPi=this.connect.prepareStatement("insert into prospect ( idProspect,Rsprospect,NumRueProsp,"
                    + "NomRueProspect,CPprospect,VilleProspect,TelProspect,MailProspect,"
                    + " ComProspect,DatedeProspection,ProspInter) values(?,?,?,?,?,?,?,?,?,?,?)");  
   
            stmtPi.setInt(1,obj.getIdT());
            stmtPi.setString(2,obj.getRaisonSociale());
            stmtPi.setString(3,obj.getNumerodeRue());
            stmtPi.setString(4,obj.getNomdeRue());
            stmtPi.setString(5,obj.getCodePostal());
            stmtPi.setString(6,obj.getVille());
            stmtPi.setString(7,obj.getTelePhone());
            stmtPi.setString(8,obj.getAdresseMail());
            stmtPi.setString(9,obj.getCommenTaire());
            stmtPi.setString(10,obj.getDatedeProspection());
            stmtPi.setString(11,obj.getProspectInterresse());
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
    public void update(Prospect1 obj) throws SQLException {
        
        
       
        PreparedStatement stmtP = null; 
        try{
            stmtP=this.connect.prepareStatement("update prospect set Rsprospect=?,NumRueProsp=?,"
                + "NomRueProspect=?,CPprospect=?,VilleProspect=?,TelProspect=?,MailProspect=?,"
                + " ComProspect=?,DatedeProspection=?,ProspInter=? where idProspect="+obj.getIdT());
            connect.setAutoCommit(false);
            stmtP.setString(1,obj.getRaisonSociale());
            stmtP.setString(2,obj.getNumerodeRue());
            stmtP.setString(3,obj.getNomdeRue());
            stmtP.setString(4,obj.getCodePostal());
            stmtP.setString(5,obj.getVille());
            stmtP.setString(6,obj.getTelePhone());
            stmtP.setString(7,obj.getAdresseMail());
            stmtP.setString(8,obj.getCommenTaire());
            stmtP.setString(9,obj.getDatedeProspection());
            stmtP.setString(10,obj.getProspectInterresse());
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
    public void delete(int id) throws SQLException {
        
        PreparedStatement stmtPd = null; 
        try{
            stmtPd=this.connect.prepareStatement("delete from prospect where idProspect="+id);
   
            stmtPd.execute();
        }catch(SQLException e){
            e.getMessage();
        } finally {
        if (stmtPd != null) { stmtPd.close(); }
        }   
       
    }

    @Override
    public Prospect1 find(int i) throws SQLException {
    
    Prospect1 p=new Prospect1();
    this.stmt= null;
    String query = "select idProspect,Rsprospect,NumRueProsp, " +
                   "NomRueProspect,CPprospect,VilleProspect,TelProspect,MailProspect, " +
                   "ComProspect,DatedeProspection,ProspInter" + " from "+"reverso"+".prospect where idProspect="+i;
    try {
        stmt = this.connect.createStatement();
        rS = stmt.executeQuery(query);
        while (rS.next()) {
            String rsprospect = rS.getString("Rsprospect");
            String NumRue = rS.getString("NumRueProsp");
            String NomRue = rS.getString("NomRueProspect");
            String Cp = rS.getString("CPprospect");
            String ville = rS.getString("VilleProspect");
            String tel =rS.getString("TelProspect");
            String mail=rS.getString("MailProspect");
            String com=rS.getString("ComProspect");
            String DateProsp =rS.getString("DatedeProspection");
            String prospInter=rS.getString("ProspInter");
              
            p.setRaisonSociale(rsprospect);
            p.setNumerodeRue(NumRue);
            p.setNomdeRue(NomRue);
            p.setCodePostal(Cp);
            p.setVille(ville);
            p.setTelePhone(tel);
            p.setAdresseMail(mail);
            p.setCommenTaire(com);
            p.setDatedeProspection(DateProsp);
            p.setProspectInterresse(prospInter);
            
        }
    }catch(SQLException e){
           e.getMessage();
    }    catch (ExceptionMetier1 | ParseException ex) {
             Logger.getLogger(DaoProspect.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
        if (stmt != null) { stmt.close(); }
    }
    return p;    
    }
}