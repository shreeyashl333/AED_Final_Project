/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.MedAdminRole;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class MedicineOrg extends Org{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    public MedicineOrg() {
        super(Org.MerchantType.Medicines.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MedAdminRole());
        return roles;
    }
}
