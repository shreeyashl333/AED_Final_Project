/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.FieldWorkerRole;
import BusinessModel.Role.Role;
import BusinessModel.Role.WardenRole;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class PetShelterOrg extends Org{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public PetShelterOrg() {
        super(Org.NGOType.PetShelter.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FieldWorkerRole());
        roles.add(new WardenRole());
        return roles;
    }
     
   
    
    
}
