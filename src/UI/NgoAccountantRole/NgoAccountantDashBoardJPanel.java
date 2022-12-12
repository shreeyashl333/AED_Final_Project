/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.NgoAccountantRole;

import BusinessModel.db4oConfig.DB4OUtil;
import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.NgoOfficeOrg;
import BusinessModel.Role.NgoAccountantRole;
import BusinessModel.UserAccount.UserAccount;
import BusinessModel.WorkQueue.SupplyWorkRequest;
import BusinessModel.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaitanya
 */
public class NgoAccountantDashBoardJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Environment business;
    private NgoOfficeOrg organization;
    private UserAccount account;
    private Enterprise enterprise;
    private String selection;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    /**
     * Creates new form WardenDashBoardJPanel
     */
    public NgoAccountantDashBoardJPanel(JPanel userProcessContainer, UserAccount account, NgoOfficeOrg organization, Enterprise enterprise, Environment business) {
        initComponents();
        jLabel3.setText(enterprise.getName());
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.organization = organization;
        this.enterprise = enterprise;
        this.account = account;
        selection = "Bill paid";
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        switch(selection){
            case "Pending bill pay": processJButton.setEnabled(true); break;
            case "Bill paid" : processJButton.setEnabled(false); break;
        }
        for (UserAccount user : organization.getUserAccountDirectory().getUserAccountList()) {
            if (user.getRole() instanceof NgoAccountantRole) {
                for (WorkRequest req : user.getWorkQueue().getWorkRequestList()) {
                    Object[] row = new Object[7];
                    if (req.getStatus().equalsIgnoreCase(selection)) {
                        row[0] = req;
                        row[1] = req.getMessage();
                        row[2] = req.getSender().getEmployee().getName();
                        row[3] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
                        row[4] = ((SupplyWorkRequest) req).getItemList();
                        row[5] = req.getStatus();
                        row[6] = ((SupplyWorkRequest) req).getBillamount();
                        model.addRow(row);
                    }
                }
            }
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Enterprise:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(226, 153, 0));
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 97, -1));

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Message", "Sender", "Receiver", "Item List", "Request Status", "Bill Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 166, 751, 147));

        backJButton.setBackground(new java.awt.Color(0, 153, 255));
        backJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 451, 100, 43));

        processJButton.setBackground(new java.awt.Color(0, 153, 255));
        processJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 451, 107, 43));

        refreshJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 102, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Request type: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 106, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending bill pay", "Bill Paid" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 103, 204, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        int billAmount = (int) (workRequestJTable.getModel().getValueAt(selectedRow, 6));
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table");
            return;
        }
        SupplyWorkRequest request = (SupplyWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if ((request.getStatus().equalsIgnoreCase("Bill Paid"))){
            JOptionPane.showMessageDialog(null, "Request already processed");
            return;
        } else {
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("NgoAccountantPaymentJPanel ", new NgoAccountantPaymentJPanel(userProcessContainer, account, organization, enterprise, business, request, billAmount));
                layout.next(userProcessContainer);
        }

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selection = (String)(jComboBox1.getSelectedItem());
        //        populateTable();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}