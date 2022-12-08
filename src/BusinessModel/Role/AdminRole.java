/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Role;

import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.Org;
import BusinessModel.UserAccount.UserAccount;
import UI.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rutuj
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Org organization, Enterprise enterprise, Environment business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise, business);
    }

    
    
}
