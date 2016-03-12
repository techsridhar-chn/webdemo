package hello;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public Employee getEmployee(Authentication authUser, String id) throws Exception {
		System.out.println("EmployeeService:getEmployee method is called");
		return new Employee();
	}

	@Override
	public String createEmployee(Principal currentUser, Employee quote) throws Exception {
		System.out.println("EmployeeService:createEmployee method is called");
		return "Employee Created";
	}

	@Override
	public String deleteEmployee(Principal currentUser, String id) throws Exception {
		System.out.println("EmployeeService:deleteEmployee method is called");
		return "Employee Deleted";
	}

	@Override
	public String updateEmployee(Principal currentUser, Employee quote) throws Exception {
		System.out.println("EmployeeService:updateEmployee method is called");
		return "Employee Updated";
	}

}
