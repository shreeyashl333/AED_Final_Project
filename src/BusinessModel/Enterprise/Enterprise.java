 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel.Enterprise;

import BusinessModel.Organization.Org;
import BusinessModel.Organization.OrgDirectory;

/**
 *
 * @author rutuj
 */
public abstract class Enterprise extends Org{
    
    private EnterpriseType enterpriseType;
    private OrgDirectory organizationDirectory;

    public void setOrganizationDirectory(OrgDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public OrgDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public enum EnterpriseType{

        VetHospital("Vet Hospital Enterprise"),Merchant("Merchant Enterprise"),Ngo("NGO Enterprise");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory=new OrgDirectory();
    }
}
