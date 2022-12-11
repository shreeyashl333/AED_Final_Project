/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author rutuj
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    private OrganizationDirectory organizationDirectory;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.VetHospital){
            enterprise=new VetHospital(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Merchant){
            enterprise =new MerchantEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        if(type==Enterprise.EnterpriseType.Ngo){
            enterprise =new NgoEnterprise(name);
            enterpriseList.add(enterprise);
        }
      if(type==Enterprise.EnterpriseType.PetSchool){
            enterprise =new PetTrainingSchoolEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }
    
    public Enterprise fetchEnterprise(String name, Enterprise.EnterpriseType type){
         for(Enterprise enterprise: enterpriseList){
             if(enterprise.getName().equals(name) && enterprise.getEnterpriseType().equals(type)){
                 return enterprise;
             }
           
         }
           return null;
     }
    
    
    public Enterprise removeEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = fetchEnterprise(name, type);
        if (type == Enterprise.EnterpriseType.VetHospital) {
            enterpriseList.remove(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Merchant) {
            enterpriseList.remove(enterprise);
        }
        if (type == Enterprise.EnterpriseType.Ngo) {
            enterpriseList.remove(enterprise);
        }
         if (type == Enterprise.EnterpriseType.PetSchool) {
            enterpriseList.remove(enterprise);
        }
        return enterprise;
    }
    
    public boolean IsDuplicateEnterprise(String name){
        for(Enterprise enterprise: enterpriseList){
             if(enterprise.getName().equals(name)){
                 return true;
             }
     }
        return false; 
    }
    
    public Boolean checkIfEnterpriseIsUnique(String name){
        return this.enterpriseList.stream().noneMatch(ep->ep.getName().equalsIgnoreCase(name));
    }
}
