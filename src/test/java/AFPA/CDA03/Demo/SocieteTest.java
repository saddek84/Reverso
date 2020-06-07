/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.Demo;

import exception.ExceptionMetier1;
import metier.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


/**
 *
 * @author Acer
 */
@DisplayName("classe test societe")
public class SocieteTest extends Societe1 {
    public SocieteTest() {
    }
   
    @Test
    void null_RsSociete()
    {
        Prospect1 prospect = new Prospect1();
        
        boolean exceptionRaised = false;
        try {
            prospect.setRaisonSociale(null);
        }
        catch (ExceptionMetier1 re) {
            exceptionRaised = true;
        }
        
        assertTrue(exceptionRaised);
    }

    

   
    @Test
    void valueNullEmptySetterRaisonSociale () {
        String[] invalidValues = {"",null, "\r", "\n" };
        assertTrue( true );
        for (String invalidValue : invalidValues) {
            ExceptionMetier1 assertThrows = assertThrows(ExceptionMetier1.class, () -> { new SocieteTest().setRaisonSociale(invalidValue); }); 
            System.out.println(assertThrows);
       }
    }
    
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"ttttt", "afpa.rt", "afpa@hhh","afpa@afpa.c", "" })
    void invalidFormatMail (String invalidValues) {
        ExceptionMetier1 assertThrows = assertThrows(ExceptionMetier1.class, () -> { new SocieteTest().setAdresseMail(invalidValues); }); 
        System.out.println(assertThrows);
    }
    

    

    
    @ParameterizedTest
    @ValueSource(strings = {"formation@afpa.fr", "rrrrrrr@domain.com" })        
    void mailOk (String mail) {
        assertDoesNotThrow(
                () -> {
                    new SocieteTest().setAdresseMail(mail);
                });
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"000000000", "+65458752","01.01.01.01.01" })      
    void telInvalid(String tel) {
        ExceptionMetier1 assertThrows = assertThrows(ExceptionMetier1.class, () -> { new SocieteTest().setTelePhone(tel); }); 
        System.out.println(assertThrows);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"0388254547", "06.54.58.75.20","+33 6 51 56 58 36" })      
    void telOk(String tel) {
        assertDoesNotThrow( () -> { new SocieteTest().setTelePhone(tel); }); 
       
    }
}

