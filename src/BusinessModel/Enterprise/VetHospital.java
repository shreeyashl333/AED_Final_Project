/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Enterprise;

import BusinessModel.Organization.OrgDirectory;
import BusinessModel.Role.Role;
import java.util.ArrayList;
    
public class VetHospital extends Enterprise {
    
    private OrgDirectory organizationDirectory;
    
    public VetHospital(String name){
        super(name,EnterpriseType.VetHospital);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
