/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ExceptionMetier1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
/**
 *
 * @author sad
 */
public abstract class DAO<T> {
    
    public Connection connect;

    public DAO() throws IOException, SQLException {
        this.connect = DAOconnection.getInstance();
    }

    
	
	
    public abstract List<T> select()throws SQLException, ExceptionMetier1, ParseException;
    
    public abstract T find(int i)throws SQLException;
        	
	
    public abstract void insert(T obj)throws SQLException;
	
	
    public abstract void update(T obj)throws SQLException;
	
	
    public abstract void delete(int id)throws SQLException;
}


    

