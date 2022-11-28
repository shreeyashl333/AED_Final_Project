/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.DoctorRole;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class ClinicOrg extends Org{
    
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    public ClinicOrg() {
        super(Org.VetHospitalType.VetClinic.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }
     
}