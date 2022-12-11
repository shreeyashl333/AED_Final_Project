/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author shree
 */
public class PharmaWorkAreaProcess extends javax.swing.JPanel {

    /**
     * Creates new form PharmaWorkAreaProcess
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PharmacyOrganization pharmacyOrganization;
//    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public PharmaWorkAreaProcess(JPanel userProcessContainer, UserAccount account, PharmacyOrganization pharmacyOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        valueLabel.setText(enterprise.getName());
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = enterprise;
        this.pharmacyOrganization = (PharmacyOrganization)pharmacyOrganization;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 254, 254));
        setPreferredSize(new java.awt.Dimension(1200, 850));
        setSize(new java.awt.Dimension(1200, 850));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setText("View Requests");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 48));

        enterpriseLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 30));

        valueLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(226, 153, 0));
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 610, 26));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setText("Pharmacist Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/pharma.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 600, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PharmacistWorkAreaJPanel pharmacistWorkAreaJPanel = new PharmacistWorkAreaJPanel(userProcessContainer, userAccount,pharmacyOrganization, enterprise);
        userProcessContainer.add(pharmacistWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
