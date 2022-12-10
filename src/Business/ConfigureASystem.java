package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.Role.WardenRole;
import Business.UserAccount.UserAccount;

public class ConfigureASystem {
    
    public static EcoSystem configure(){
                System.out.println("I am here");

        
        EcoSystem system = EcoSystem.getInstance();
      
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        UserAccount ma = system.getUserAccountDirectory().createUserAccount("warden", "warden", employee, new WardenRole());

        return system;
    }
    
}
