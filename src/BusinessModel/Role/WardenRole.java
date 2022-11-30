/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Role;

import BusinessModel.Environment;
import BusinessModel.Enterprise.Enterprise;
import BusinessModel.Organization.PetShelterOrg;
import BusinessModel.Organization.Org;
import BusinessModel.UserAccount.UserAccount;
import javax.swing.JPanel;
import UI.WardenRole.WardenWorkAreaJPanel;

/**
 *
 * @author shree
 */
public class WardenRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Org organization, Enterprise enterprise, Environment business) 
    {

        return new WardenWorkAreaJPanel(userProcessContainer, 
                                             account, 
                                            (PetShelterOrg)organization, 
                                             enterprise,
                                             business);
    }
    }
