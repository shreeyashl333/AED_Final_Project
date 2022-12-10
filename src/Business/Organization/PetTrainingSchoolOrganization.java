/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.PatSchoolStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author chaitanya
 */
public class PetTrainingSchoolOrganization extends Organization {
        private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public PetTrainingSchoolOrganization() {
        super(Organization.PetSchoolType.PetTrainingSchool.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PatSchoolStaffRole());
        return roles;
    }
}
