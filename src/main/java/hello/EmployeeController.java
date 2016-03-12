package hello;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseBody
    public String createEmployee(Principal currentUser,@RequestBody Employee employee) throws Exception {
    	System.out.println("EmployeeController:createEmployee method is called");
    	return employeeService.createEmployee(currentUser, employee);
   }
    
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(Authentication currentUser,@PathVariable String id) throws Exception {
    	System.out.println("EmployeeController:getEmployee method is called");
    	return employeeService.getEmployee(currentUser, id);
    }
    
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteEmployee(Principal currentUser,@PathVariable String id) throws Exception {
    	System.out.println("EmployeeController:deleteEmployee method is called");
    	return employeeService.deleteEmployee(currentUser, id);
    }
    
    
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    @ResponseBody
    public String updateEmployee(Principal currentUser,@RequestBody Employee employee) throws Exception {
    	System.out.println("EmployeeController:updateEmployee method is called");
    	return employeeService.updateEmployee(currentUser, employee);
    }

}
