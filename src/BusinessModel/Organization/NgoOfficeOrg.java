/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.NgoAccountantRole;
import BusinessModel.Role.NgoStaffRole;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class NgoOfficeOrg extends Org{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public NgoOfficeOrg() {
        super(Org.NGOType.NgoOffice.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NgoStaffRole());
        roles.add(new NgoAccountantRole());
        return roles;
    }
     
   
    
    
}
