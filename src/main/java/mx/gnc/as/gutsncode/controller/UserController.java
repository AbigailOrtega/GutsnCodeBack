package mx.gnc.as.gutsncode.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gnc.as.gutsncode.model.User;

@RestController
@CrossOrigin(origins = "https://guts-n-code-test.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	User user;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
	public ResponseEntity<User> login(@RequestBody User user) {
		try {
			System.out.println("entre login");
			Authentication userAuth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUser(), user.getPwd()));
			System.out.println("QUERY EXITOSO");
			user = new User();
			user.setUser(userAuth.getName());
			user.setToken(getJWTToken(userAuth.getName()));
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	private String getJWTToken(String username) {
		String secretKey = "tokenGNCtoken";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ADMIN");
		System.out.println("TOKEN PREPARADO");
		String token = Jwts
				.builder()
				.setId("GutsNCode")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000000))
				.signWith(SignatureAlgorithm.HS512,
//				.signWith(SignatureAlgorithm.ES256,
						secretKey.getBytes()).compact();
		System.out.println("REGRESANDO TOKEN");
		return "GNCTOKEN " + token;
	}
	
	@PostMapping("logout")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The payload was correct"),
			@ApiResponse(code = 204, message = "The payload do not contain correct/enough info"),
			@ApiResponse(code = 400, message = "The payload do not contain required info") })
//	public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
	public ResponseEntity<User> logout(@RequestBody User user) {
		try {
			System.out.println("entre logout");
			Authentication userAuth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUser(), user.getPwd()));
			//UserDetails userDetails=userDetailsService.loadUserByUsername(userAuth.getName());
			user = new User();
			user.setUser(userAuth.getName());
			user.setToken(getJWTToken(userAuth.getName()));
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (DisabledException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
	}
}