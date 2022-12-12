/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.WardenRole;

import BusinessModel.db4oConfig.DB4OUtil;
import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Enterprise.MerchEnterprise;
import BusinessModel.Network.Network;
import BusinessModel.Organization.FoodOrg;
import BusinessModel.Organization.MedicineOrg;
import BusinessModel.Organization.Org;
import BusinessModel.Organization.PetShelterOrg;
import BusinessModel.UserAccount.UserAccount;
import BusinessModel.WorkQueue.FoodWorkRequest;
import BusinessModel.WorkQueue.MedWorkRequest;
import BusinessModel.WorkQueue.SupplyWorkRequest;
import BusinessModel.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author shree
 */
public class PlaceOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlaceOrderJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ArrayList<Org> org;
    private ArrayList<FoodOrg> forg;
    private ArrayList<MedicineOrg> meorg;
    private Environment business;
    private ArrayList<String> foodItem;
    private ArrayList<String> medItem;
    private ArrayList<String> Item;
    private SupplyWorkRequest swr;
    private PetShelterOrg organization;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private final Logger logger = Logger.getLogger(this.getClass());
    
    public PlaceOrderJPanel(JPanel userProcessContainer, UserAccount userAccount,SupplyWorkRequest swr,PetShelterOrg organization, Enterprise enterprise,Environment business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.business = business;
        this.swr = swr;
        this.organization = organization;
        forg = new ArrayList<>();
        meorg = new ArrayList<>();
        foodItem = new ArrayList<>();
        medItem = new ArrayList<>();
        Item = new ArrayList<>();
        if(!swr.getStatus().equalsIgnoreCase("Request sent to Supplier")){
        createArrayL(swr);
        populateTable(foodItem,medItem);
        }
//        populateMainTable();
        //fetch network
        Network network=business.getNetworkList().stream().filter(item->item.getEnterpriseDirectory().getEnterpriseList().stream().anyMatch(item1->item1.getName().equalsIgnoreCase(enterprise.getName())))
                       .findFirst()
                       .orElse(null);
        //fetch all merchant organizations
        for(Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof MerchEnterprise){
               org = ent.getOrganizationDirectory().getOrganizationList();
               break;
            }
        }
        //create arrays for food and med organization
        for (Org org1 : org) {
            if(org1 instanceof FoodOrg){
                forg.add((FoodOrg) org1);
            }
            if(org1 instanceof MedicineOrg){
                meorg.add((MedicineOrg) org1);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void createArrayL(SupplyWorkRequest swr) {

        Item = swr.getItemList();
        for (int i = 0; i < Item.size(); i++) {
            if(Item.get(i).contains("Food")){
                foodItem.add(Item.get(i));
            }else{
                medItem.add(Item.get(i));
            }
        }
    }
    
    private void populateTable(ArrayList<String> foodItem, ArrayList<String> medItem) {
        if(foodItem.size()>0){
            DefaultTableModel modelfood = (DefaultTableModel)FoodTable.getModel();
            modelfood.setRowCount(0);
            for(int i=0;i<foodItem.size();i++){
                Object[] row = new Object[1];
                row[0]= foodItem.get(i);
                modelfood.addRow(row);
            }
        }
        if(medItem.size()>0){
            DefaultTableModel modelmed = (DefaultTableModel)MedTable.getModel();
            modelmed.setRowCount(0);
            for(int i=0;i<medItem.size();i++){
                Object[] row = new Object[1];
                row[0]= medItem.get(i);
                modelmed.addRow(row);
            }
        }
    }
    
//    private void populateMainTable() {
//        DefaultTableModel model = (DefaultTableModel)WorkRequestJTable.getModel();
//        model.setRowCount(0);
//        for(WorkRequest req :organization.getWorkQueue().getWorkRequestList()){
//            Object[] row = new Object[6];
//            if(req instanceof SupplyWorkRequest){
//            }else{
//                row[0] = req;
//                row[1] = req.getMessage();
//                row[2] = req.getSender().getEmployee().getName();
//                row[3] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getName();
//                if(req instanceof FoodWorkRequest){    
//                    row[4] = ((FoodWorkRequest)req).getFoodList();
//                }
//                if(req instanceof MedWorkRequest){
//                row[4] = ((MedWorkRequest)req).getMedList();
//                }
//                row[5] = req.getStatus();
//                model.addRow(row);
//            }
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FoodTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 102, 44));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("Place an order for supplies");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 26, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Review your order:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 89, -1, -1));

        MedTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        MedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine List"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MedTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 182, 375, 64));

        FoodTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        FoodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Items"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(FoodTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 89, 375, 64));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Intiate Request to Supplier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 275, -1, 41));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MedicineOrg medorg= null;
        FoodOrg fodorg = null;
        
        if(foodItem.size()>0){
            FoodWorkRequest fwr = new FoodWorkRequest();
            fwr.setFoodReqId(swr.getSuppReqId());
            fwr.setSender(userAccount);
            fwr.setMessage("Food Item Request");
            fwr.setRequestDate(new Date());
            fwr.setStatus("Pending Request");
            fwr.setFoodList(foodItem);
        userAccount.getWorkQueue().getWorkRequestList().add(fwr);
            for(Org fo: forg){
                fodorg = (FoodOrg) fo;
                fodorg.getWorkQueue().getWorkRequestList().add(fwr);
            }
            organization.getWorkQueue().getWorkRequestList().add(fwr);
        }
        if(medItem.size()>0){
            MedWorkRequest mwr = new MedWorkRequest();
            mwr.setMedReqId(swr.getSuppReqId());
            mwr.setSender(userAccount);
            mwr.setMessage("Medicine Item Request");
            mwr.setRequestDate(new Date());
            mwr.setStatus("Pending Request");
            mwr.setMedList(medItem);
            for(Org mo: meorg){
                medorg = (MedicineOrg) mo;
                medorg.getWorkQueue().getWorkRequestList().add(mwr);
            }
            organization.getWorkQueue().getWorkRequestList().add(mwr);
        }
        if(foodItem.size() >0 || medItem.size()>0){
            JOptionPane.showMessageDialog(null, "Request sent");
            logger.info("Initiated request to Supplier");
        swr.setStatus("Request sent to Supplier");
        dB4OUtil.storeSystem(business);
        DefaultTableModel modelfood = (DefaultTableModel)FoodTable.getModel();
        modelfood.setRowCount(0);
        DefaultTableModel modelmed = (DefaultTableModel)MedTable.getModel();
        modelmed.setRowCount(0);
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FoodTable;
    private javax.swing.JTable MedTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}