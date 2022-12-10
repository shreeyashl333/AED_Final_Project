/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rutuj
 */
public class PetTrainingSchoolEnterprise extends Enterprise{
    
    private OrganizationDirectory organizationDirectory;
    PetTrainingSchoolEnterprise(String name) {
      super(name,Enterprise.EnterpriseType.PetSchool);
    }
     
     @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
