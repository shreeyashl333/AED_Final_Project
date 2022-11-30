/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Role;

import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.MedicineOrg;
import BusinessModel.Organization.Org;
import BusinessModel.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.MedAdminRole.MedAdminWorkAreaJPanel;

/**
 *
 * @author shree
 */
public class MedAdminRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Org organization, Enterprise enterprise, Environment business) 
    {

        return new MedAdminWorkAreaJPanel(userProcessContainer, 
                                             account, 
                                            (MedicineOrg)organization, 
                                             enterprise,
                                             business);
    }
    }
