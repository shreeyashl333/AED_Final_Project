/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.PharmacistRole;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class PharmacyOrg extends Org{
    
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public PharmacyOrg() {
        super(Org.VetHospitalType.Pharmacy.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PharmacistRole());
        return roles;
    }
     
   
    
    
}
