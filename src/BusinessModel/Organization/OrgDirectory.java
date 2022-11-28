/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Organization;


import BusinessModel.Organization.Org.MerchantType;
import BusinessModel.Organization.Org.NGOType;
import BusinessModel.Organization.Org.VetHospitalType;
import java.util.ArrayList;

/**
 *
 * @author shree
 */
public class OrgDirectory {
    
    private ArrayList<Org> organizationList;

    public OrgDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Org> getOrganizationList() {
        return organizationList;
    }
    
    public Org createOrganizationHospital(VetHospitalType type, String name){
        Org organization = null;
        if (type.getValue().equals(VetHospitalType.VetClinic.getValue())){
            organization = new ClinicOrg();
            organization.setName(name);
            organizationList.add(organization);
        }else{
            if (type.getValue().equals(VetHospitalType.Pharmacy.getValue())){
             organization = new PharmacyOrg();
             organization.setName(name);
             organizationList.add(organization);
            }
        }
        return organization;
    }
    public Org createOrganizationSupplier(MerchantType type, String name){
        Org organization = null;
        if (type.getValue().equals(MerchantType.Food.getValue())){
            organization = new FoodOrg();
            organization.setName(name);
            organizationList.add(organization);
        }else{
           if (type.getValue().equals(MerchantType.Medicines.getValue())){
            organization = new MedicineOrg();
            organization.setName(name);
            organizationList.add(organization);
            }
        }
        return organization;
    }
    public Org createOrganizationNgo(NGOType type,String name){
        Org organization = null;
        if (type.getValue().equals(NGOType.NgoOffice.getValue())){
            organization = new NgoOfficeOrg();
            organization.setName(name);
            organizationList.add(organization);
        }else{
            if (type.getValue().equals(NGOType.PetShelter.getValue())){
            organization = new PetShelterOrg();
            organization.setName(name);
            organizationList.add(organization);
            }
        }
        return organization;
    }
}