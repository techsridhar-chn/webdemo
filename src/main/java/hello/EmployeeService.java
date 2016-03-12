package hello;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;



public interface EmployeeService {

	@PreAuthorize("hasRole('USER_EMPLOYEE')")
	Employee getEmployee(Authentication authUser,String id) throws Exception;
	
	@PreAuthorize("hasRole('USER_EMPLOYEE')")
	String createEmployee(Principal currentUser,Employee employee) throws Exception;
	
	@PreAuthorize("hasRole('USER_EMPLOYEE')")
	String deleteEmployee(Principal currentUser,String id) throws Exception;
	
	@PreAuthorize("hasRole('USER_EMPLOYEE')")
	String updateEmployee(Principal currentUser,Employee employee) throws Exception;
}
