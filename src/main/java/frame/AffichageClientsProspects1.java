/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import DAO.DAO;
import DAO.DAOfactory;
import DAO.DaoContrat;
import exception.ExceptionMetier1;
import metier.*;
import list.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CDA03-16
 */
public class AffichageClientsProspects1 extends javax.swing.JFrame {
 
    
      private Societe1 sc;
      private int modif;
      private String choix;
      private boolean flagContrat=false;
                     
    /**
     * Creates new form TableClientsProspects
     */
    
    
    public AffichageClientsProspects1(){
         initComponents();
         this.setVisible(false);
        this.flagContrat=false;
                
    }
    public AffichageClientsProspects1(Societe1 p_sc)throws ExceptionMetier1, ParseException, SQLException, IOException {
        initComponents();
        this.sc=p_sc;
        this.flagContrat=true;
        this.setVisible(false);
        double montGlobal=0;
        DAO<Contrat1> dao=DAOfactory.getDaoContrat();
        DaoContrat daoC=(DaoContrat)dao;
        Clients1 c=(Clients1)sc;
        daoC.findClients(c);
        System.out.print(c.getListContrat());
        String[] enteteClients ={"idContrat","libelle Contrat","Montant","Date Debut Contrat","Date Fin Contrat"};
        DefaultTableModel model=new DefaultTableModel(new Object[][]{},enteteClients){
            @Override //surcharge de la methode isCellEditable de la classe Defaulttable model
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
       
      
            for(Contrat1 contrat: c.getListContrat()){
                model.addRow(new Object[]{contrat.getIdContrat(),contrat.getLblContrat(),contrat.getMontantContrat(),contrat.getDateDebutContrat().format(Contrat1.DATEFORME)
                        ,contrat.getDateFinContrat().format(Contrat1.DATEFORME)});
            } 
            
            this.lblTitre.setText("Liste des Contrats Clients");
            this.lblTitre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                           
            for(int i=0;i<c.getListContrat().size();i++){
                montGlobal=c.getListContrat().get(i).getMontantContrat()+montGlobal;
                
            }
            jMontant.setForeground(Color.red);
            jmontantGlobal.setEditable(false);
            jmontantGlobal.setText(String.valueOf(montGlobal));
                                                                                                   
            this.tblClientsProspects.setModel(model);
            jScrollPane1.setPreferredSize(tblClientsProspects.getPreferredSize());
            tblClientsProspects.setRowHeight(30);
            tblClientsProspects.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblClientsProspects.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblClientsProspects.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblClientsProspects.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblClientsProspects.getColumnModel().getColumn(4).setPreferredWidth(100);       
            paBtnModifSupp.setVisible(false);
            c.getListContrat().clear();
            
    }

    public AffichageClientsProspects1(String choix,Societe1 p_sc) {
        initComponents();
        this.flagContrat=false;
        this.choix=choix;
        this.sc=p_sc;
        this.setVisible(false);
        String[] enteteProspect ={"id","Raison sociale","Adresse","Telephone","Adresse mail","Commentaires","Date de prospection","Prospect Interesse"};
        String[] enteteClients ={"id","Raison sociale","Adresse","Telephone","Adresse mail","Commentaires","Chiffre d'affaire","Nombre employes"};
        DefaultTableModel model=new DefaultTableModel(new Object[][]{},enteteClients){
            @Override //surcharge de la methode isCellEditable de la classe Defaulttable model
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        if(choix.equalsIgnoreCase("clients")){
            
            for(Clients1 c : ListClient1.getListClients()){
               
                model.addRow(new Object[]{c.getIdT(),c.getRaisonSociale(),c.getNumerodeRue()+" "+c.getNomdeRue()+" "+c.getCodePostal()+" "+c.getVille()
                                         ,c.getTelePhone(),c.getAdresseMail(),c.getCommenTaire(),c.getChiffredaffaire(),c.getNbrEmploye()});
            }                    
            this.lblTitre.setText("Liste des Clients");
            this.lblTitre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                           
        }
        else{
            model.setColumnIdentifiers(enteteProspect);
            for(Prospect1 p : ListProspect1.getListProspect()){
               
                model.addRow(new Object[]{p.getIdT(),p.getRaisonSociale(),p.getNumerodeRue()+" "+p.getNomdeRue()+" "+p.getCodePostal()+" "+p.getVille()
                                         ,p.getTelePhone(),p.getAdresseMail(),p.getCommenTaire(),p.getDatedeProspection(),p.getProspectInterresse()});
                                    
            }
            this.lblTitre.setText("Liste des Prospects");
            this.lblTitre.setHorizontalTextPosition((int) CENTER_ALIGNMENT);                        
        }
                                                         
            this.tblClientsProspects.setModel(model);
            jScrollPane1.setPreferredSize(tblClientsProspects.getPreferredSize());
            tblClientsProspects.setRowHeight(30);
            tblClientsProspects.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblClientsProspects.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblClientsProspects.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblClientsProspects.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblClientsProspects.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblClientsProspects.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblClientsProspects.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblClientsProspects.getColumnModel().getColumn(7).setPreferredWidth(100);
            paBtnModifSupp.setVisible(false);
            
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRetourMenuPrincipal = new javax.swing.JButton();
        btnQuitter = new javax.swing.JButton();
        lblTitre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientsProspects = new javax.swing.JTable();
        paBtnModifSupp = new javax.swing.JPanel();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        jmontantGlobal = new javax.swing.JTextField();
        jMontant = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnRetourMenuPrincipal.setText("Retour Menu Principal");
        btnRetourMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourMenuPrincipalActionPerformed(evt);
            }
        });

        btnQuitter.setText("Quitter");
        btnQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitterActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        tblClientsProspects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblClientsProspects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblClientsProspects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientsProspects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientsProspectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientsProspects);
        tblClientsProspects.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paBtnModifSuppLayout = new javax.swing.GroupLayout(paBtnModifSupp);
        paBtnModifSupp.setLayout(paBtnModifSuppLayout);
        paBtnModifSuppLayout.setHorizontalGroup(
            paBtnModifSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBtnModifSuppLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnSupprimer)
                .addGap(78, 78, 78))
        );
        paBtnModifSuppLayout.setVerticalGroup(
            paBtnModifSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paBtnModifSuppLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(paBtnModifSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifier)
                    .addComponent(btnSupprimer))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jMontant.setText("Montant Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paBtnModifSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitter, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRetourMenuPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jmontantGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMontant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jmontantGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRetourMenuPrincipal)
                        .addGap(32, 32, 32)
                        .addComponent(btnQuitter))
                    .addComponent(paBtnModifSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblTitre.getAccessibleContext().setAccessibleName("lblTitre");

        getAccessibleContext().setAccessibleParent(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitterActionPerformed
        // TODO add your handling code here:
        int reponse =JOptionPane.showConfirmDialog(null,"voulez vous quitter la fenetre","Quitter",JOptionPane.YES_NO_OPTION);
            if(reponse==JOptionPane.YES_OPTION){
                dispose();
                System.exit(0);
            }
        
    }//GEN-LAST:event_btnQuitterActionPerformed

    private void btnRetourMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetourMenuPrincipalActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MenuPrincipal1 m;
        try {
            m = new MenuPrincipal1();
            m.setVisible(true);
        } catch (ExceptionMetier1 ex) {
            Logger.getLogger(AffichageClientsProspects1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnRetourMenuPrincipalActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         int reponse =JOptionPane.showConfirmDialog(null,"voulez vous quitter la fenetre","Quitter",JOptionPane.YES_NO_OPTION);
                if(reponse==JOptionPane.YES_OPTION){
                    dispose();
                    System.exit(0);
                }
    }//GEN-LAST:event_formWindowClosing

    private void tblClientsProspectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientsProspectsMouseClicked
        // TODO add your handling code here:
        //pour surligner la ligne selectionner                
        if(!tblClientsProspects.getColumnSelectionAllowed() && !flagContrat){
           
            tblClientsProspects.setColumnSelectionInterval(0,7); 
            tblClientsProspects.setSelectionBackground(Color.cyan);
            paBtnModifSupp.setVisible(true);             
        }
        else{
            tblClientsProspects.repaint();
            tblClientsProspects.clearSelection();
            paBtnModifSupp.setVisible(false);                    
        }                
    }//GEN-LAST:event_tblClientsProspectsMouseClicked

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
        this.dispose();
        modif=1;
         if(choix.equalsIgnoreCase("clients")){
             sc =ListClient1.getListClients().get(tblClientsProspects.getSelectedRow());
        }
        else{
            sc=ListProspect1.getListProspect().get(tblClientsProspects.getSelectedRow());
            
        }
        Formulaires1 cl;
        try {
            cl = new Formulaires1(choix, modif,sc);
            cl.setVisible(true);
            
        } catch (ExceptionMetier1 | ParseException ex) {
            Logger.getLogger(MenuPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // TODO add your handling code here:
        this.dispose();
        modif=2;  
        if(choix.equalsIgnoreCase("clients")){
             sc =ListClient1.getListClients().get(tblClientsProspects.getSelectedRow());
        }
        else{
            sc=ListProspect1.getListProspect().get(tblClientsProspects.getSelectedRow());
            
        }
        Formulaires1 cl;
        try {
            cl = new Formulaires1(choix, modif,sc);
            cl.setVisible(true);
            
                        
        } catch (ExceptionMetier1 | ParseException ex) {
            Logger.getLogger(MenuPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_btnSupprimerActionPerformed
   
    
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AffichageClientsProspects1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffichageClientsProspects1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffichageClientsProspects1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffichageClientsProspects1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffichageClientsProspects1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnQuitter;
    private javax.swing.JButton btnRetourMenuPrincipal;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JLabel jMontant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmontantGlobal;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel paBtnModifSupp;
    private javax.swing.JTable tblClientsProspects;
    // End of variables declaration//GEN-END:variables
}
