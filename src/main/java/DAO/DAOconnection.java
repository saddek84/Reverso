/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
 

/**
 *
 * @author sad
 */
public class DAOconnection {
    
    private static Connection conn;    
    
   
    



public DAOconnection(){
     
    
}

public static Connection getInstance() throws IOException, SQLException{
    
    try{

        Class.forName("com.mysql.cj.jdbc.Driver");
        final Properties dataProperties = new Properties();
            dataProperties.load(DAOconnection.class.getClassLoader().getResourceAsStream("database.properties"));
        //System.out.println("Le pilote JDBC MySQL a été chargé");

        conn = DriverManager.getConnection(dataProperties.getProperty("url"),dataProperties.getProperty("login"),dataProperties.getProperty("password"));   
        return conn;    
    }catch (ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,"communication impossible");
        System.exit(0);
        e.printStackTrace();
        return null;
    }catch (IOException io){
        io.getMessage();
    } 
    return conn;
}    
  
}
