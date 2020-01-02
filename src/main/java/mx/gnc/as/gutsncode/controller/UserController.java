package mx.gnc.as.gutsncode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.gnc.as.gutsncode.model.User;

@RestController
public class UserController {
	
	@Autowired
	User user;

	@PostMapping("login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		if(!user.checkValidUser(new User(username, pwd)))
			return null;
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
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