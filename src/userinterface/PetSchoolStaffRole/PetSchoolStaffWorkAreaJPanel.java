/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.PetSchoolStaffRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PetTrainingSchoolOrganization;
import Business.POJO.Users;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.JoinPetSchoolRequest;
import EmailUtility.EmailUtility;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaitanya
 */
public class PetSchoolStaffWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PetSchoolStaffWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PetTrainingSchoolOrganization petTrainingSchoolOrganization;
    private EcoSystem business;

    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
        private EmailUtility em=new EmailUtility();

    public PetSchoolStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PetTrainingSchoolOrganization petTrainingSchoolOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.petTrainingSchoolOrganization = petTrainingSchoolOrganization;
        this.enterprise = enterprise;
        this.business = business;
        populateAdmissionReq();
        
    }
   
    
    public void populateAdmissionReq(){
                DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();

        model.setRowCount(0);
                enterprise.getWorkQueue().getWorkRequestList()
                        .stream().filter(wq -> wq instanceof JoinPetSchoolRequest)
                        .forEach(request -> {
                            Object[] row = new Object[12];
                            row[0] =((JoinPetSchoolRequest) request);
                            row[1] = ((JoinPetSchoolRequest) request).getUsername();
                            row[2] = request.getStatus();
                            row[3] = ((JoinPetSchoolRequest) request).getCourseType();
                            
                            if(((JoinPetSchoolRequest) request).getCourseType().equals("Basic Training"))
                                {
                                        row[4] = "$300";
                                }
                            
                            else
                                {
                                    row[4] = "$500";
                                }

                            row[5] = ((JoinPetSchoolRequest) request).getRequestDate();
                            row[6] = ((JoinPetSchoolRequest) request).getResolveDate();
                            row[7] = ((JoinPetSchoolRequest) request).getComments();
                            row[8] = ((JoinPetSchoolRequest) request).getEmailId();
                            model.addRow(row);
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

        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        reqApprovalBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnPdf = new javax.swing.JButton();
        BtnSendBillMail = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 850));
        setSize(new java.awt.Dimension(1200, 850));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refreshTestJButton.setBackground(new java.awt.Color(0, 153, 255));
        refreshTestJButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 28, 150, 30));

        valueLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(226, 153, 0));
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 158, 26));

        workRequestJTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestId", "Request Raised By", "Status", "Course Type", "Course Fee", "Request Date", "Resolve Date", "Comments", "Email ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1100, 300));

        reqApprovalBtn.setBackground(new java.awt.Color(0, 153, 255));
        reqApprovalBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        reqApprovalBtn.setText("Approve");
        reqApprovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqApprovalBtnActionPerformed(evt);
            }
        });
        add(reqApprovalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, 108, 45));

        rejectBtn.setBackground(new java.awt.Color(0, 153, 255));
        rejectBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rejectBtn.setText("Reject");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });
        add(rejectBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, 105, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/output-onlinegiftools.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 200, 35));

        BtnPdf.setBackground(new java.awt.Color(0, 153, 255));
        BtnPdf.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        BtnPdf.setText("Generate Bill PDF");
        BtnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPdfActionPerformed(evt);
            }
        });
        add(BtnPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 180, 30));

        BtnSendBillMail.setBackground(new java.awt.Color(0, 153, 255));
        BtnSendBillMail.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        BtnSendBillMail.setText("Send Bill Mail");
        BtnSendBillMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSendBillMailActionPerformed(evt);
            }
        });
        add(BtnSendBillMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/adopt_1200x850.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        populateAdmissionReq();
        
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void reqApprovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqApprovalBtnActionPerformed
        // TODO add your handling code here:
        Integer selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            JoinPetSchoolRequest pa = (JoinPetSchoolRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if(pa.getStatus().equalsIgnoreCase("Approved") || pa.getStatus().equalsIgnoreCase("Request Rejected")){
                JOptionPane.showMessageDialog(null, "request already processed");
                return;
            }
            pa.setStatus("Approved");
            pa.setReceiver(userAccount);
            pa.setResolveDate(new Date());
            Map a = new HashMap<String, String>();
            a.put("Approval Comment", "Congratulations and thankyou for joining the pet training School!");
            pa.setComments1(a);
            JOptionPane.showMessageDialog(null, "Congratulations and thankyou for joining the pet training School!");
            dB4OUtil.storeSystem(business);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from Requests Available for approval");
        }
    }//GEN-LAST:event_reqApprovalBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        // TODO add your handling code here:
        Integer selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            JoinPetSchoolRequest pa = (JoinPetSchoolRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if(pa.getStatus().equalsIgnoreCase("Request Rejected") || pa.getStatus().equalsIgnoreCase("Approved request")){
                JOptionPane.showMessageDialog(null, "request already processed");
                return;
            }
            pa.setStatus("Request Rejected");
            pa.getPet().setIsAvailableForAdoption(Boolean.TRUE);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from request table!!");
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void BtnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPdfActionPerformed
        // TODO add your handling code here:
        
        String path = "";
        JFileChooser j= new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x=j.showSaveDialog(this);
        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = j.getSelectedFile().getPath();
            
            
        
        }
        
        
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc,new FileOutputStream(path+"/Bill.pdf"));
            doc.open();
            Paragraph paragraph1 = new Paragraph("Bill Generated For Pet School Admission");
            paragraph1.setSpacingAfter(72f);

            doc.add(paragraph1);
        
        


            PdfPTable tbl = new PdfPTable(6);
            tbl.addCell("Request ID");
            tbl.addCell("Bill Generated For");
            tbl.addCell("Status");
            tbl.addCell("Course Type");
            tbl.addCell("Course Fee");
            tbl.addCell("Comments");
            
                    Integer selectedRow = workRequestJTable.getSelectedRow();

                    
            
                    String ID = workRequestJTable.getValueAt(selectedRow,0).toString();
                    String SendingTo = workRequestJTable.getValueAt(selectedRow,1).toString();
                    String Status = workRequestJTable.getValueAt(selectedRow,2).toString();
                    String CourseType = workRequestJTable.getValueAt(selectedRow,3).toString();
                    String CourseFee = workRequestJTable.getValueAt(selectedRow,4).toString();
                    String Comments = workRequestJTable.getValueAt(selectedRow,7).toString();


                    tbl.addCell(ID);
                    tbl.addCell(SendingTo);
                    tbl.addCell(Status);

                     tbl.addCell(CourseType);
                     tbl.addCell(CourseFee);
                     tbl.addCell(Comments);
                    
            doc.add(tbl);
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PetSchoolStaffWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PetSchoolStaffWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();

    }//GEN-LAST:event_BtnPdfActionPerformed

    private void BtnSendBillMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSendBillMailActionPerformed
        // TODO add your handling code here:
                            Integer selectedRow = workRequestJTable.getSelectedRow();

        System.out.println(workRequestJTable.getValueAt(selectedRow,8).toString());
     
        em.sendBillMail(workRequestJTable.getValueAt(selectedRow,8).toString());
                    JOptionPane.showMessageDialog(null, "Bill Invoice successfilly sent to" + " "+workRequestJTable.getValueAt(selectedRow,1).toString() + " " + workRequestJTable.getValueAt(selectedRow,8).toString());

    }//GEN-LAST:event_BtnSendBillMailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPdf;
    private javax.swing.JButton BtnSendBillMail;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JButton reqApprovalBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}