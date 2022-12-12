/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NgoStaffRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NgoOfficeOrganization;
import Business.Organization.PetShelterOrganization;
import Business.Role.FieldWorkerRole;
import Business.Role.NgoAccountantRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SupplyWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaitanya
 */
public class SupplyRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplyRequestJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private NgoOfficeOrganization ngoOfficeOrganization;
    private EcoSystem business; 
    private String selection;
    private PetShelterOrganization org;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public SupplyRequestJPanel(JPanel userProcessContainer, UserAccount userAccount,NgoOfficeOrganization ngoOfficeOrganization,PetShelterOrganization org, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.enterprise = enterprise;
        this.ngoOfficeOrganization = ngoOfficeOrganization; 
        this.org = org;
        selection = "Pending request for approval";
        populateTable();
        
    }
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        model.setRowCount(0);
        switch(selection){
            case "Pending request for approval":  processJButton.setEnabled(true); break;
            case "Pending bill pay": processJButton.setEnabled(false); break;
            case "Approved request": processJButton.setEnabled(false); break;
            case "Bill Paid": processJButton.setEnabled(true); break;
        }
        ngoOfficeOrganization.getWorkQueue().getWorkRequestList().forEach(req->{
            Object[] row = new Object[7];
            if(req.getStatus().equalsIgnoreCase(selection)){
                row[0] = req;
                row[1] = req.getMessage();
                row[2] = req.getSender().getEmployee().getName();
                row[3] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
                row[4] = ((SupplyWorkRequest)req).getItemList();
                row[5] = ((SupplyWorkRequest)req).getBillamount();
                row[6] = req.getStatus();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        backJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(162, 182, 227));
        setForeground(new java.awt.Color(162, 182, 227));
        setPreferredSize(new java.awt.Dimension(1200, 850));
        setSize(new java.awt.Dimension(1200, 850));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Message", "Sender", "Receiver", "Item List", "Bill Amount", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 1010, 270));

        refreshJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Request type: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approved request", "Pending bill pay", "Pending request for approval", "Bill Paid" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        backJButton.setBackground(new java.awt.Color(0, 153, 255));
        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 100, 42));

        processJButton.setBackground(new java.awt.Color(0, 153, 255));
        processJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 410, 107, 42));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/adopt_1200x850.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selection = (String)(jComboBox1.getSelectedItem());
        //        populateTable();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NgoStaffWorkAreaJPanel sysngostfjp = (NgoStaffWorkAreaJPanel) component;

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "No pending request at our end");
            return;
        }
        SupplyWorkRequest request = (SupplyWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);
            if(request.getStatus().equalsIgnoreCase("Bill paid")){
                request.setStatus("Approved request");
                populateTable();
            }else{
                JOptionPane.showMessageDialog(null, "Request state changed to pending bill pay");

                request.setStatus("Pending bill pay");
                dB4OUtil.storeSystem(business);
                for(UserAccount user : ngoOfficeOrganization.getUserAccountDirectory().getUserAccountList()) {
                    if (user.getRole() instanceof NgoAccountantRole) {
                        user.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
            
        
        
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
