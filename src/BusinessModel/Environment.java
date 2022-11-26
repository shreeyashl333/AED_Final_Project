/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModel;

import BusinessModel.POJO.UserDirectory;
import BusinessModel.Network.Network;
import BusinessModel.Organization.Org;
import BusinessModel.POJO.IDGenerator;
import BusinessModel.POJO.PetsDirectory;
import BusinessModel.Role.Role;
import BusinessModel.Role.SystemAdminRole;
import java.util.ArrayList;

public class Environment extends Org{
    
    private static Environment business;
    private ArrayList<Network> networkList;
    private UserDirectory ud;
    private PetsDirectory pd;
    private IDGenerator idgen;
    public static Environment getInstance() {
        if(business==null){
            business=new Environment();
        }
        return business;
    }
    
    public UserDirectory getUserDirInstance(){
        if(ud==null){
            ud = new UserDirectory(); 
        }
        return ud;
    }
    
    public PetsDirectory getPetDirInstance(){
        if(pd==null){
            pd = new PetsDirectory();
            pd.getListOfPets();//creating empty array
        }
        return pd;
    }
    
    public IDGenerator getIdGenInstance(){
        if(idgen == null)
        {
            idgen = new IDGenerator();
        }
        return idgen;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    
    public Boolean checkifNetworkIsUnique(String name){
        return networkList.stream().noneMatch(nwk->nwk.getName().equalsIgnoreCase(name));
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private Environment(){
        super(null);
        networkList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserDirInstance().checkIfUsernameIsUnique(userName)){
            return false;
        }
        return true;
    }
}
