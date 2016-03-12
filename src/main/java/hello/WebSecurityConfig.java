package hello;
																										
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
	
	public WebSecurityConfig(){
		String roleHierarchyStringRepresentation ="ADMIN_EMPLOYEE > USER_EMPLOYEE";
		roleHierarchy.setHierarchy(roleHierarchyStringRepresentation);
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeRequests()
           .accessDecisionManager(getAccessDecisionManager())
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    	
    	  
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth
        .inMemoryAuthentication()
            .withUser("user002@domain.com").password("password").roles("TEST_USER_EMPLOYEE");
    	auth
            .inMemoryAuthentication()
                .withUser("user001@domain.com").password("password").roles("USER_EMPLOYEE");
        auth
            .inMemoryAuthentication().
            	withUser("admin001@domain.com").password("password").roles("ADMIN_EMPLOYEE");
    }
    
    

	@Bean
	public AffirmativeBased getAccessDecisionManager() {
	DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
	expressionHandler.setRoleHierarchy(roleHierarchy);
	
	WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
	webExpressionVoter.setExpressionHandler(expressionHandler);
	
	List<AccessDecisionVoter<? extends Object>> voters = new ArrayList<>();
	
	voters.add(webExpressionVoter);
	return new AffirmativeBased(voters);
	}
}
