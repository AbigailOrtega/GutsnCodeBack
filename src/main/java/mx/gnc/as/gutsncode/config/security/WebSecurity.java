package mx.gnc.as.gutsncode.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.headers().frameOptions().disable().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() //Disable cookies
//		.cors().and() //Put the Cross-Origin Resource Sharing at default values
		.csrf().disable() //Disable the Cross-site request forgery filter - could cause that any page could get the token
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) //Add filters for required authentication services
		.authorizeRequests() // Start to authorize the next connections 
		.antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"
                ).permitAll() //Swagger
		.antMatchers("/gncu/*","/managment/*","/h2-console/*").permitAll() //User services don't need authorization 
		.antMatchers(HttpMethod.POST,"/login").permitAll() //Login doesn't need authorization 
		.anyRequest().authenticated(); //All other pages are securized
		
	}
}