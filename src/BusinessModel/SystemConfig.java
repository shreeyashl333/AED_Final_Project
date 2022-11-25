package BusinessModel;

import BusinessModel.Employee.Employee;
import BusinessModel.Role.SystemAdminRole;
import BusinessModel.UserAccount.UserAccount;

public class SystemConfig {
    
    public static Environment configure(){
        
        Environment system = Environment.getInstance();
      
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
}
