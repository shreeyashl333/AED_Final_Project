/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;

import BusinessModel.Role.FoodAdminRole;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class FoodOrg extends Org{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public FoodOrg() {
        super(Org.MerchantType.Food.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FoodAdminRole());
        return roles;
    }
}
