/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.sql.SQLException;
import metier.*;

/**
 *
 * @author sad
 */
public class DAOfactory  {

public static DAO<Clients1> getDaoClients() throws IOException, SQLException{
		return new DaoClients();
}
	
public static DAO<Prospect1> getDaoProspect() throws IOException, SQLException{
		return new DaoProspect();
	}
	
public static DAO<Contrat1> getDaoContrat() throws IOException, SQLException{
		return new DaoContrat();
}    
}
