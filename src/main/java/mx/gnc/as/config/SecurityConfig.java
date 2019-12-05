package mx.gnc.as.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//			.authorizeRequests()
//			.antMatchers("/gncu/*").permitAll()
//			.antMatchers(HttpMethod.POST,"/login").permitAll()
////			.antMatchers(HttpMethod.POST, "/gncu/*").permitAll()
//			.anyRequest().authenticated();
//	}
	
}