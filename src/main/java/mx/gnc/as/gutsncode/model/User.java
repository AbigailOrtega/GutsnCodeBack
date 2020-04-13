package mx.gnc.as.gutsncode.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {

	private String user;
	private String pwd;
	private String token;
	
//	private static List<User> users = User.createList();
//	
//	private static List<User> createList() {
//		
//		List<User> tempUsers = new ArrayList<>();
//		
//		User emp1 = new User();
//		emp1.setUser("sebas");
//		emp1.setPwd("123456789");
//
//		User emp2 = new User();
//		emp2.setUser("aby");
//		emp2.setPwd("987654321");
//		
//		tempUsers.add(emp1);
//		tempUsers.add(emp2);
//		return tempUsers;
//	}
//	
//	public boolean checkValidUser(User user2Check) {
//		
//		boolean[] valid = {false,false};
//		
//		for (User user : users) {
//			valid[0] = user.getUser().equalsIgnoreCase(user2Check.getUser())? true: false;
//			valid[1] = user.getPwd().contentEquals(user2Check.getPwd())? true: false;
//			
//			if(valid[0] && valid[1])	return true;
//			else	continue;
//		}
//		return false;
//	}
//	
//
//	public User() {
//		super();
//	}
//
//	public User(String user, String pwd) {
//		super();
//		this.user = user;
//		this.pwd = pwd;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}

}