package mx.gnc.as.gutsncode.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select USERNAME, PASSWORD, EMAIL, ENABLED, NUMBER_TRIES from USERS where USERNAME=?")
		.authoritiesByUsernameQuery("select USERNAME, AUTHORITY from AUTHORITIES where USERNAME=?")
		.passwordEncoder(new BCryptPasswordEncoder())
		;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			/*.headers().frameOptions().disable().and()*/
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Disable cookies
			.and().cors() //Put the Cross-Origin Resource Sharing at default values
			.and().csrf()
			.disable() // Disable the Cross-site request forgery filter - could cause that any page
//									// could get the token
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) 
			// Add filters for required authentication services
			.authorizeRequests() // Start to authorize the next connections
//			.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security",
//					"/swagger-ui.html", "/webjars/**")
//			.permitAll() // Swagger
//			.antMatchers("/managment/getTopic/*","/managment/*").permitAll() // User services don't need
			.antMatchers("/gncu/*").permitAll() // User services don't need authorization
			.antMatchers(HttpMethod.POST, "/login").permitAll() // Login doesn't need authorization
			.anyRequest().authenticated(); // All other pages are securized

	}
}