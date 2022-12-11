/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MedAdminRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.NgoEnterprise;
import Business.Network.Network;
import Business.Organization.MedicineOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Organization.PetShelterOrganization;
import Business.WorkQueue.MedWorkRequest;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shree
 */
public class MedAdminWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private ArrayList<PetShelterOrganization> psorg;
    private ArrayList<Organization> org;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private MedicineOrganization medOrganization;
    private EcoSystem business;
    private String selection;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public MedAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, MedicineOrganization medOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.medOrganization = medOrganization;
        this.enterprise = enterprise;
        this.business = business;
        psorg = new ArrayList<>();
        //fetch network
        Network network=business.getNetworkList().stream().filter(item->item.getEnterpriseDirectory().getEnterpriseList().stream().anyMatch(item1->item1.getName().equalsIgnoreCase(enterprise.getName())))
                       .findFirst()
                       .orElse(null);
        //fetch all merchant organizations
        for(Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof NgoEnterprise){
               org = ent.getOrganizationDirectory().getOrganizationList();
               break;
            }
        }
        //fetch parent pet organizaation list
//        org.stream().filter((o) -> (o.name.contains("Pet"))).forEachOrdered((o) -> {
//            psorg.add((PetShelterOrganization) o);
//        });
            for(Organization o: org){
            if(o.name.contains("Pet")){
                psorg.add((PetShelterOrganization)(o));
            }
        }
            selection = "Completed request";
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        model.setRowCount(0);
        switch(selection){
            case "Completed request": processJButton.setEnabled(false); break;
            case "Pending request": processJButton.setEnabled(true); break;
        }
        medOrganization.getWorkQueue().getWorkRequestList().forEach(req->{
        Object[] row = new Object[6];
            if(req.getStatus().equalsIgnoreCase(selection)){
                row[0] = req;
                row[1] = req.getMessage();
                row[2] = req.getSender().getEmployee().getName();
                row[3] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
                row[4] = ((MedWorkRequest)req).getMedList();
                row[5] = req.getStatus();
                model.addRow(row);
            }
            });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        refreshJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 850));
        setSize(new java.awt.Dimension(1200, 850));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setText("Med Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Message", "Sender", "Receiver", "Item List", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setToolTipText("");
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 191, 1040, 300));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Request type");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completed request", "Pending request" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, -1, -1));

        processJButton.setBackground(new java.awt.Color(0, 153, 255));
        processJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 195, 41));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/adopt_1200x850.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selection = (String)(jComboBox1.getSelectedItem());
                populateTable();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        MedWorkRequest mwr = (MedWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if(!mwr.getStatus().equalsIgnoreCase("Completed request")){
            mwr.setReceiver(userAccount);
            mwr.setStatus("Completed request");
//            medOrganization.getWorkQueue().getWorkRequestList().add(mwr);
            dB4OUtil.storeSystem(business);
            //add to petshelter q
//            for(Organization o1: psorg){
//                o1.getWorkQueue().getWorkRequestList().add(mwr);
//            }
        }else{
            JOptionPane.showMessageDialog(null, "Request already processed");
            return;
        }
        
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

}
