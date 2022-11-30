/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Role;

import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.ClinicOrg;
import BusinessModel.Organization.Org;
import BusinessModel.UserAccount.UserAccount;
import UI.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shree
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Org organization, Enterprise enterprise, Environment business) {
        return new DoctorWorkAreaJPanel(userProcessContainer, 
                                        account, 
                                       (ClinicOrg)organization, 
                                        enterprise,
                                        business);
    }
    
    
}
