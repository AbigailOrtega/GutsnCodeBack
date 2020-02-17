package mx.gnc.as.gutsncode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.gnc.as.gutsncode.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	User user;

	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private UserDetailsService userDetailsService;

	@PostMapping("login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) throws Exception {
		try {
			System.out.println("entre login");
			Authentication userAuth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pwd));
			//UserDetails userDetails=userDetailsService.loadUserByUsername(userAuth.getName());
			User user = new User();
			user.setUser(userAuth.getName());
			user.setToken(getJWTToken(userAuth.getName()));		
			return user;
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
	}

	private String getJWTToken(String username) {
		String secretKey = "tokenGNCtoken";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ADMIN");
		
		String token = Jwts
				.builder()
				.setId("GutsNCode")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
//						.signWith(SignatureAlgorithm.ES256,
						secretKey.getBytes()).compact();

		return "GNCTOKEN " + token;
	}
}