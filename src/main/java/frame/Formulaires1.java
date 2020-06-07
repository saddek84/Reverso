/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import DAO.DAO;
import DAO.DAOfactory;
import exception.ExceptionMetier1;
import metier.*;
import list.*;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;


/**
 *
 * @author CDA03-16
 */

public class Formulaires1  extends javax.swing.JFrame  {
    
    
    private String choix;
    private Societe1 sc;
    private int modif;//parametre ajout/modification/suppression
    private boolean flag=true;
    private Prospect1 p=null;
    private Clients1 c=null;
        
    /**
     * Creates new form Clients
     */
    public Formulaires1() {
        initComponents();
        
        cbxProspectInt.removeAllItems();
        for(EnumerationCbx1 choix:EnumerationCbx1.values()){
        cbxProspectInt.addItem(choix.toString());
        
        }
        //txtRs.requestFocus();
      
    }
    public Formulaires1(String p_choix)throws ExceptionMetier1,ParseException{
        initComponents();
        this.choix=p_choix;
        cbxProspectInt.removeAllItems();
        cbxProspectInt.addItem(EnumerationCbx1.OUI.toString());
        cbxProspectInt.addItem(EnumerationCbx1.NON.toString());
        
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/image/img2.png")).getImage());                
        Prospect1 p=null;
        Clients1 c=null;      
        lblClients.setText("Ajouts "+choix);
        
        
        if(p_choix.equalsIgnoreCase("prospects")){
          
            sc=new Prospect1();
            lblClients.setText("Prospect");
            cbxProspectInt.setVisible(true);
            lblCa.setVisible(false);
            txtCa.setVisible(false);
            lblNbrEmploye.setVisible(false);
            txtNbrEmploye.setVisible(false);                              
        }
        else{           
            sc=new Clients1();
            cbxProspectInt.setVisible(false);
            lblChoix.setVisible(false);
            lblDate.setVisible(false);
            txtDate.setVisible(false);
        }
        
        
    }
     public Formulaires1(String p_choix,int p_modif,Societe1 p_sc)throws ExceptionMetier1,ParseException{
        initComponents();
        this.modif=p_modif;
        this.sc=p_sc;
        this.choix=p_choix;
        cbxProspectInt.removeAllItems();
        cbxProspectInt.addItem(EnumerationCbx1.OUI.toString());
        cbxProspectInt.addItem(EnumerationCbx1.NON.toString());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/image/img2.png")).getImage());
        lblClients.setText("Ajout"+choix);
                
       if(modif==1){
            lblClients.setText("Modifications "+choix);
            if(p_choix.equalsIgnoreCase("prospects")){
                p=(Prospect1)sc;
                txtRs.setText(p.getRaisonSociale());
                txtNumRue.setText(p.getNumerodeRue());
                txtNomRue.setText(p.getNomdeRue());
                txtCp.setText(p.getCodePostal());
                txtVille.setText(p.getVille());
                txtTel.setText(p.getTelePhone());
                txtMail.setText(p.getAdresseMail());
                txtDate.setText(p.getDatedeProspection());
                txtComm.setText(p.getCommenTaire());
                cbxProspectInt.setSelectedItem(p.getProspectInterresse());
            }
            else
            {   
                c=(Clients1)sc;
                txtRs.setText(c.getRaisonSociale());
                txtNumRue.setText(c.getNumerodeRue());
                txtNomRue.setText(c.getNomdeRue());
                txtCp.setText(c.getCodePostal());
                txtVille.setText(c.getVille());
                txtTel.setText(c.getTelePhone());
                txtMail.setText(c.getAdresseMail());
                txtComm.setText(c.getCommenTaire());
                txtCa.setText(String.valueOf(c.getChiffredaffaire()));
                txtNbrEmploye.setText(String.valueOf(c.getNbrEmploye()));
             
            }
                
        }
        if(modif==2){
            lblClients.setText("Suppression "+choix);
            txtRs.setEnabled(false);
            txtNumRue.setEnabled(false);
            txtNomRue.setEnabled(false);
            txtCp.setEnabled(false);
            txtVille.setEnabled(false);
            txtTel.setEnabled(false);
            txtMail.setEnabled(false);
            txtDate.setEnabled(false);
            txtComm.setEnabled(false);
            txtCa.setEnabled(false);
            txtNbrEmploye.setEnabled(false);
            cbxProspectInt.setEnabled(false);
            this.setTitle(" Suppression");
        if(p_choix.equalsIgnoreCase("prospects")){
                p=(Prospect1)sc;
                txtRs.setText(p.getRaisonSociale());
                txtNumRue.setText(p.getNumerodeRue());
                txtNomRue.setText(p.getNomdeRue());
                txtCp.setText(p.getCodePostal());
                txtVille.setText(p.getVille());
                txtTel.setText(p.getTelePhone());
                txtMail.setText(p.getAdresseMail());
                txtDate.setText(p.getDatedeProspection());
                txtComm.setText(p.getCommenTaire());
                cbxProspectInt.setSelectedItem(p.getProspectInterresse());
            }
            else
            {   
                c=(Clients1)sc;
                txtRs.setText(c.getRaisonSociale());
                txtNumRue.setText(c.getNumerodeRue());
                txtNomRue.setText(c.getNomdeRue());
                txtCp.setText(c.getCodePostal());
                txtVille.setText(c.getVille());
                txtTel.setText(c.getTelePhone());
                txtMail.setText(c.getAdresseMail());
                txtComm.setText(c.getCommenTaire());
                txtCa.setText(String.valueOf(c.getChiffredaffaire()));
                txtNbrEmploye.setText(String.valueOf(c.getNbrEmploye()));
             
            }
                
        }
        
        if(p_choix.equalsIgnoreCase("prospects")){
                               
            cbxProspectInt.setVisible(true);
            lblCa.setVisible(false);
            txtCa.setVisible(false);
            lblNbrEmploye.setVisible(false);
            txtNbrEmploye.setVisible(false);
        }
        else{
           
            cbxProspectInt.setVisible(false);
            lblChoix.setVisible(false);
            lblDate.setVisible(false);
            txtDate.setVisible(false);
        }
        
        
    }

  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClients = new javax.swing.JLabel();
        paBouton = new javax.swing.JPanel();
        paClientsProspect = new javax.swing.JPanel();
        lblnumRue = new javax.swing.JLabel();
        lblNomRue = new javax.swing.JLabel();
        lblCodePostal = new javax.swing.JLabel();
        txtRs = new javax.swing.JTextField();
        txtNomRue = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        lblVille = new javax.swing.JLabel();
        txtVille = new javax.swing.JTextField();
        lblCa = new javax.swing.JLabel();
        lblNbrEmploye = new javax.swing.JLabel();
        txtCa = new javax.swing.JTextField();
        txtNbrEmploye = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        scrComm = new javax.swing.JScrollPane();
        txtComm = new javax.swing.JTextArea();
        lblCom = new javax.swing.JLabel();
        lblChoix = new javax.swing.JLabel();
        cbxProspectInt = new javax.swing.JComboBox<>();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtNumRue = new javax.swing.JTextField();
        lblRaisonSociale = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnRetour = new javax.swing.JButton();
        btnValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblClients.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClients.setText("Clients");

        javax.swing.GroupLayout paBoutonLayout = new javax.swing.GroupLayout(paBouton);
        paBouton.setLayout(paBoutonLayout);
        paBoutonLayout.setHorizontalGroup(
            paBoutonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paBoutonLayout.setVerticalGroup(
            paBoutonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        paClientsProspect.setPreferredSize(new java.awt.Dimension(500, 500));

        lblnumRue.setText("Numero de rue");

        lblNomRue.setText("Nom de rue");

        lblCodePostal.setText("Code postal");

        txtRs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRsFocusLost(evt);
            }
        });

        txtNomRue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomRueFocusLost(evt);
            }
        });

        txtCp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpFocusLost(evt);
            }
        });

        lblVille.setText("Ville");

        txtVille.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVilleFocusLost(evt);
            }
        });

        lblCa.setText("Chiffre d'affaire");

        lblNbrEmploye.setText("Nombre d'employés");

        txtCa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCaFocusLost(evt);
            }
        });

        txtNbrEmploye.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNbrEmployeFocusLost(evt);
            }
        });

        lblTel.setText("Telephone");

        txtTel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelFocusLost(evt);
            }
        });

        txtComm.setColumns(20);
        txtComm.setRows(5);
        scrComm.setViewportView(txtComm);

        lblCom.setText("Commentaires");

        lblChoix.setText("Prospect Interesse?");

        cbxProspectInt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMail.setText("Mail");

        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMailFocusLost(evt);
            }
        });

        lblDate.setText("Date de prospection");

        txtNumRue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumRueFocusLost(evt);
            }
        });

        lblRaisonSociale.setText("Raison sociale");

        javax.swing.GroupLayout paClientsProspectLayout = new javax.swing.GroupLayout(paClientsProspect);
        paClientsProspect.setLayout(paClientsProspectLayout);
        paClientsProspectLayout.setHorizontalGroup(
            paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paClientsProspectLayout.createSequentialGroup()
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodePostal))
                        .addGap(71, 71, 71)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVille, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVille, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCa)
                            .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNbrEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNbrEmploye)))
                    .addComponent(lblMail, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxProspectInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChoix))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblCom)
                        .addGap(18, 18, 18)
                        .addComponent(scrComm, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(paClientsProspectLayout.createSequentialGroup()
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumRue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaisonSociale, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRs, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paClientsProspectLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addComponent(lblnumRue)
                        .addGap(79, 79, 79)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(83, 83, 83))
        );
        paClientsProspectLayout.setVerticalGroup(
            paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paClientsProspectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRaisonSociale, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumRue)
                    .addComponent(lblNomRue))
                .addGap(18, 18, 18)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodePostal)
                    .addComponent(lblVille)
                    .addComponent(lblTel)
                    .addComponent(lblChoix))
                .addGap(18, 18, 18)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProspectInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrComm, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paClientsProspectLayout.createSequentialGroup()
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCa)
                            .addComponent(lblNbrEmploye)
                            .addComponent(lblCom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paClientsProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNbrEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(lblDate)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnRetour.setText("Retour");
        btnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourActionPerformed(evt);
            }
        });

        btnValider.setText("Valider");
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClients, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paClientsProspect, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValider)
                    .addComponent(btnRetour))
                .addGap(44, 44, 44)
                .addComponent(paBouton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblClients, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnValider)
                                .addGap(50, 50, 50)
                                .addComponent(btnRetour)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(paClientsProspect, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(529, Short.MAX_VALUE)
                        .addComponent(paBouton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        try {
            // TODO add your handling code here:
            
            
            DAO<Clients1>  daoClients = DAOfactory.getDaoClients();
            
            DAO<Prospect1> daoProspect = DAOfactory.getDaoProspect();;
            
            
            
            
            if(choix.equalsIgnoreCase("clients")){
                if(modif==0){
                    ajout();
                    try{
                        
                        daoClients.insert(c);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"ajout echouer");
                    }
                }
                if(modif==1){ //Modification d'un client
                    modifier();
                    try{
                        daoClients.update(c);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Modification echouer");
                    }
                }
                if(flag && modif==2){ //Suppression d'un clients
                    supprimer();
                    try{
                        daoClients.delete(c.getIdT());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"suppression echouer");
                    }
                }
            }
            else{
                
                if(modif==0){//Ajout d'un prospect
                    ajout();
                    try{
                        daoProspect.insert(p);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"ajout echouer");
                    }
                }
                if(modif==1){ //Modification d'un prospect
                    modifier();
                    try{
                        daoProspect.update(p);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Modification echouer");
                    }
                }
                if(modif==2){ //Suppression d'un prospect
                    supprimer();
                    try{
                        daoProspect.delete(p.getIdT());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Suppression echouer");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
        }                                     
    }//GEN-LAST:event_btnValiderActionPerformed
    /**
     * methode teste les champs pour Clients ou Prospects
     */
    public void testSaisieClientsProspects(){
                       
        //teste champs saisie pour un  clients
        if(choix.equalsIgnoreCase("clients")){
            
            c=(Clients1)sc; 
      
            try{
                c.setRaisonSociale(txtRs.getText());
                flag=true;
                
            }catch (ExceptionMetier1 ex ) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage()); 
                txtRs.setBorder(BorderFactory.createLineBorder(Color.red));                
                txtRs.requestFocus();                
                flag=false;
            }                                                
            if(flag){
                
             try{
                c.setNumerodeRue(txtNumRue.getText());
                flag=true;
            }catch(ExceptionMetier1 er){
                
                JOptionPane.showMessageDialog(null, er.getMessage()); 
                txtNumRue.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNumRue.requestFocus();
                flag=false;
            }
            }                          
            if(flag){
            try{
                c.setNomdeRue(txtNomRue.getText());
                flag=true;
            }catch(ExceptionMetier1 enr){
                
                JOptionPane.showMessageDialog(null, enr.getMessage()); 
                txtNomRue.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNomRue.requestFocus();
                flag=false;
            }
            }            
            if(flag){
            try{
                c.setCodePostal(txtCp.getText());
                flag=true;
            }catch(ExceptionMetier1 eCp){
                
                JOptionPane.showMessageDialog(null, eCp.getMessage());
                txtCp.setBorder(BorderFactory.createLineBorder(Color.red));
                txtCp.requestFocus();
                flag=false;
            }
            }         
            if(flag){
            try{
                c.setVille(txtVille.getText());
                flag=true;
            }catch(ExceptionMetier1 eVl){
                
                JOptionPane.showMessageDialog(null, eVl.getMessage()); 
                txtVille.setBorder(BorderFactory.createLineBorder(Color.red));
                txtVille.requestFocus();
                flag=false;
            }
            }           
            if(flag){
            try{
                c.setTelePhone(txtTel.getText());
                flag=true;
            }catch(ExceptionMetier1 eTl){
                
                JOptionPane.showMessageDialog(null, eTl.getMessage()); 
                txtTel.setBorder(BorderFactory.createLineBorder(Color.red));
                txtTel.requestFocus();
                flag=false;
            }
            }           
            if(flag){
            try{
                c.setChiffredaffaire(Integer.parseInt(txtCa.getText()));
                flag=true;
            }catch(ExceptionMetier1 eCA){
                
                JOptionPane.showMessageDialog(null, eCA.getMessage());
                txtCa.setBorder(BorderFactory.createLineBorder(Color.red));
                txtCa.requestFocus();
                flag=false;
            }catch(NumberFormatException nCa){
                JOptionPane.showMessageDialog(null,"le chiffre d'affaire doit contenir que des chiffres");
                txtCa.setBorder(BorderFactory.createLineBorder(Color.red));
                txtCa.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                c.setNbrEmploye(Integer.parseInt(txtNbrEmploye.getText()));
                flag=true;
            }catch(ExceptionMetier1 eNbremploye){
                
                JOptionPane.showMessageDialog(null, eNbremploye.getMessage());
                txtNbrEmploye.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNbrEmploye.requestFocus();
                flag=false;
            }
            catch(NumberFormatException nEmp){
                JOptionPane.showMessageDialog(null,"veuillez saisir un nombre positif");
                txtNbrEmploye.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNbrEmploye.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                c.setAdresseMail(txtMail.getText());
                flag=true;
            }catch(ExceptionMetier1 eMail){
                
                JOptionPane.showMessageDialog(null, eMail.getMessage()); 
                txtMail.setBorder(BorderFactory.createLineBorder(Color.red));
                txtMail.requestFocus();
                flag=false;
            }
            }
           
            c.setCommenTaire(txtComm.getText());                                  
        }
        //teste les champs saisie pour un prospect
        else {
            
            p=(Prospect1)sc;
            try{
                p.setRaisonSociale(txtRs.getText());
                flag=true;
                
            }catch(ExceptionMetier1 e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                txtRs.setBorder(BorderFactory.createLineBorder(Color.red));
                txtRs.requestFocus();               
                flag=false;
            }
            if(flag){
            try{
                p.setNumerodeRue(txtNumRue.getText());
                flag=true;
            }catch(ExceptionMetier1 er){
                
                JOptionPane.showMessageDialog(null, er.getMessage());
                txtNumRue.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNumRue.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                p.setNomdeRue(txtNomRue.getText());
                flag=true;
            }catch(ExceptionMetier1 enr){
                
                JOptionPane.showMessageDialog(null, enr.getMessage()); 
                txtNomRue.setBorder(BorderFactory.createLineBorder(Color.red));
                txtNomRue.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                p.setCodePostal(txtCp.getText());
                flag=true;
            }catch(ExceptionMetier1 eCp){
                
                JOptionPane.showMessageDialog(null, eCp.getMessage());
                txtCp.setBorder(BorderFactory.createLineBorder(Color.red));
                txtCp.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                p.setVille(txtVille.getText());
                flag=true;
            }catch(ExceptionMetier1 eVl){
                
                JOptionPane.showMessageDialog(null, eVl.getMessage());
                txtVille.setBorder(BorderFactory.createLineBorder(Color.red));
                txtVille.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                p.setTelePhone(txtTel.getText());
                flag=true;
            }catch(ExceptionMetier1 eTl){
                
                JOptionPane.showMessageDialog(null, eTl.getMessage());
                txtTel.setBorder(BorderFactory.createLineBorder(Color.red));
                txtTel.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                p.setAdresseMail(txtMail.getText());
                flag=true;
            }catch(ExceptionMetier1 eMail){
                
                JOptionPane.showMessageDialog(null, eMail.getMessage());
                txtMail.setBorder(BorderFactory.createLineBorder(Color.red));
                txtMail.requestFocus();
                flag=false;
            }
            }
            if(flag){
            try{
                System.out.println();  
                p.setDatedeProspection(txtDate.getText());
                flag=true;
            }catch(ExceptionMetier1 eDt){
                
                JOptionPane.showMessageDialog(null, eDt.getMessage());
                txtDate.setBorder(BorderFactory.createLineBorder(Color.red));
                txtDate.requestFocus();
                flag=false;
            }catch(ParseException pdate){
                
                JOptionPane.showMessageDialog(null,"format non valide");
               txtDate.setBorder(BorderFactory.createLineBorder(Color.red));
                
                flag=false;
            }
            }
                p.setProspectInterresse(cbxProspectInt.getSelectedItem().toString());
                p.setCommenTaire(txtComm.getText());
                
         
           
        }
    }
    /**
     * methode ajouter creation d'un client ou d'un prospect
     */
    public void ajout(){
        
            testSaisieClientsProspects();
            if(choix.equalsIgnoreCase("clients")){
                                
                if(flag){
                    c=(Clients1)sc;
                    ListClient1.getListClients().add(c);
                    Collections.sort(ListClient1.getListClients(),Comparer1.compareNom); 
                }
        
            }
            else{
                p=(Prospect1)sc;
                if(flag){
                 ListProspect1.getListProspect().add(p);
                 Collections.sort(ListProspect1.getListProspect(),Comparer1.compareNom); 
                }
            }
            if(flag){
            //remet les champs à vide après ajout
            JOptionPane.showMessageDialog(null,"Ajout d'un "+choix,"Ajout"+choix,1);   
            txtRs.setText("");
            txtNumRue.setText("");
            txtNomRue.setText("");
            txtNbrEmploye.setText("");
            txtCa.setText("");
            txtComm.setText("");
            txtTel.setText("");
            txtVille.setText("");
            txtMail.setText("");
            txtCp.setText("");                           
            txtDate.setText("");
            txtRs.requestFocus();
            //couleur de la bordure en gris
            txtRs.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtNumRue.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtNomRue.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtCp.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtCa.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtTel.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtNbrEmploye.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtVille.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtDate.setBorder(BorderFactory.createLineBorder(Color.gray));
            txtMail.setBorder(BorderFactory.createLineBorder(Color.gray));
            }    
    }
    public void modifier(){
        testSaisieClientsProspects();
        if(choix.equalsIgnoreCase("clients")){
            
            if(flag){
            Collections.sort(ListClient1.getListClients(),Comparer1.compareNom);
            int reponseModif =JOptionPane.showConfirmDialog(null,"voulez vous vraiment modifier?","Suppression",JOptionPane.YES_NO_OPTION);
                if(reponseModif==JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"modification reussi");
                    this.dispose();
                    MenuPrincipal1 m;
                try {
                    m = new MenuPrincipal1(choix);
                    m.setVisible(true);
                }catch (ExceptionMetier1 | ParseException ex) {
                        Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        }
        else{
            
            if(flag){
            Collections.sort(ListProspect1.getListProspect(),Comparer1.compareNom);
            int reponseModif =JOptionPane.showConfirmDialog(null,"voulez vous vraiment modifier?","Suppression",JOptionPane.YES_NO_OPTION);
                if(reponseModif==JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"modification reussi");
                    this.dispose();
                    MenuPrincipal1 m;
                    try {
                        m = new MenuPrincipal1(choix);
                        m.setVisible(true);
                    }catch (ExceptionMetier1 | ParseException ex) {
                        Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
            }
        }
    }
    public void supprimer(){
        
    
        testSaisieClientsProspects();
        if(choix.equalsIgnoreCase("clients")){ 
            
        c=(Clients1)sc;
        
        int reponseSupr =JOptionPane.showConfirmDialog(null,"voulez vous supprimer","Suppression",JOptionPane.YES_NO_OPTION);
            if(reponseSupr==JOptionPane.YES_OPTION){
                ListClient1.getListClients().remove(c);
                this.dispose();
                MenuPrincipal1 m;
            try {
                m = new MenuPrincipal1(choix);
                m.setVisible(true);
            }catch (ExceptionMetier1 | ParseException ex) {
                Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        else{
            p=(Prospect1)sc; 
                int reponseSupr =JOptionPane.showConfirmDialog(null,"voulez vous vraiment supprimer "+p.toString(),"Suppression",JOptionPane.YES_NO_OPTION);
                    if(reponseSupr==JOptionPane.YES_OPTION){
                        ListProspect1.getListProspect().remove(p);
                        this.dispose();
                        MenuPrincipal1 m;
                    try {
                        m = new MenuPrincipal1(choix);
                        m.setVisible(true);
                    }catch (ExceptionMetier1 | ParseException ex) {
                    Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                    }
        }
    }
    private void btnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetourActionPerformed
        // TODO add your handling code here:
        //retour au meu principal
        this.setVisible(false);
        dispose(); 
        MenuPrincipal1 m;
        
        try {
            m = new MenuPrincipal1(choix);    
            m.setVisible(true);
               
        } catch (ExceptionMetier1 | ParseException ex) {
            Logger.getLogger(Formulaires1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }//GEN-LAST:event_btnRetourActionPerformed

    private void txtRsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRsFocusLost
        // TODO add your handling code here:
        if(txtRs.getText().isEmpty()){
            txtRs.setBorder(BorderFactory.createLineBorder(Color.red));
            txtRs.requestFocus();
        }
        else{
            txtRs.setBorder(BorderFactory.createLineBorder(Color.green));
        }
    }//GEN-LAST:event_txtRsFocusLost

    private void txtTelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelFocusLost
        // TODO add your handling code here:
        if(txtTel.getText().isEmpty()){
           txtTel.setBorder(BorderFactory.createLineBorder(Color.red));
           txtTel.requestFocus();
          
        }
        else{
           txtTel.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtTelFocusLost

    private void txtCpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpFocusLost
        // TODO add your handling code here:
        if(txtCp.getText().isEmpty()){
           txtCp.setBorder(BorderFactory.createLineBorder(Color.red));
           txtCp.requestFocus();
        }
        else{
           txtCp.setBorder(BorderFactory.createLineBorder(Color.green));   
        }  
    }//GEN-LAST:event_txtCpFocusLost

    private void txtNumRueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumRueFocusLost
        // TODO add your handling code here:
        if(txtNumRue.getText().isEmpty()){
           txtNumRue.setBorder(BorderFactory.createLineBorder(Color.red));
           txtNumRue.requestFocus();
        }
        else{
           txtNumRue.setBorder(BorderFactory.createLineBorder(Color.green));   
        }        
    }//GEN-LAST:event_txtNumRueFocusLost

    private void txtCaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCaFocusLost
        // TODO add your handling code here:
        if(txtCa.getText().isEmpty()){
           txtCa.setBorder(BorderFactory.createLineBorder(Color.red));
           txtCa.requestFocus();
        }
        else{
           txtCa.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtCaFocusLost

    private void txtMailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusLost
        // TODO add your handling code here:
        if(txtMail.getText().isEmpty()){
           txtMail.setBorder(BorderFactory.createLineBorder(Color.red));
           txtMail.requestFocus();
        }
        else{
           txtMail.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtMailFocusLost

    private void txtNbrEmployeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNbrEmployeFocusLost
        // TODO add your handling code here:
        if(txtNbrEmploye.getText().isEmpty()){
           txtNbrEmploye.setBorder(BorderFactory.createLineBorder(Color.red));
           txtNbrEmploye.requestFocus();
        }
        else{
           txtNbrEmploye.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtNbrEmployeFocusLost

    private void txtNomRueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomRueFocusLost
        // TODO add your handling code here:
        if(txtNomRue.getText().isEmpty()){
           txtNomRue.setBorder(BorderFactory.createLineBorder(Color.red));
           txtNomRue.requestFocus();
        }
        else{
           txtNomRue.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtNomRueFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         int reponse =JOptionPane.showConfirmDialog(null,"voulez vous quitter la fenetre","Quitter",JOptionPane.YES_NO_OPTION);
                if(reponse==JOptionPane.YES_OPTION){
                    dispose();
                    System.exit(0);
                }
    }//GEN-LAST:event_formWindowClosing

    private void txtVilleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVilleFocusLost
        // TODO add your handling code here:
        if(txtVille.getText().isEmpty()){
           txtVille.setBorder(BorderFactory.createLineBorder(Color.red));
           txtVille.requestFocus();
        }
        else{
           txtVille.setBorder(BorderFactory.createLineBorder(Color.green));   
        }
    }//GEN-LAST:event_txtVilleFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulaires1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulaires1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetour;
    private javax.swing.JButton btnValider;
    private javax.swing.JComboBox<String> cbxProspectInt;
    private javax.swing.JLabel lblCa;
    private javax.swing.JLabel lblChoix;
    private javax.swing.JLabel lblClients;
    private javax.swing.JLabel lblCodePostal;
    private javax.swing.JLabel lblCom;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNbrEmploye;
    private javax.swing.JLabel lblNomRue;
    private javax.swing.JLabel lblRaisonSociale;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblVille;
    private javax.swing.JLabel lblnumRue;
    private javax.swing.JPanel paBouton;
    private javax.swing.JPanel paClientsProspect;
    private javax.swing.JScrollPane scrComm;
    private javax.swing.JTextField txtCa;
    private javax.swing.JTextArea txtComm;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNbrEmploye;
    private javax.swing.JTextField txtNomRue;
    private javax.swing.JTextField txtNumRue;
    private javax.swing.JTextField txtRs;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtVille;
    // End of variables declaration//GEN-END:variables
}
