/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Role;

import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.NgoOfficeOrg;
import BusinessModel.Organization.Org;
import BusinessModel.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.NgoAccountantRole.NgoAccountantWorkAreaJPanel;

/**
 *
 * @author chaitanya
 */
public class NgoAccountantRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Org organization, Enterprise enterprise, Environment business) 
    {

        return new NgoAccountantWorkAreaJPanel(userProcessContainer, 
                                             account, 
                                            (NgoOfficeOrg)organization, 
                                             enterprise,
                                             business);
    }
    }
