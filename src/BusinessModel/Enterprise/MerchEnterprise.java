/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Enterprise;

import BusinessModel.Organization.OrgDirectory;
import BusinessModel.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rutuj
 */
public class MerchEnterprise extends Enterprise{
    
    private OrgDirectory organizationDirectory;
    
    MerchEnterprise(String name) {
         super(name,Enterprise.EnterpriseType.Merchant);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}

