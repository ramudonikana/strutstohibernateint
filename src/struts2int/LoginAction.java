package struts2int;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String email;
	private String password;
	public void validate() {

		if(email.length()<1)
		addFieldError("email", "email cant be blank");
	if(password.length()<1)
		addFieldError("password", "password cannot be blank");

	}
	public String execute() {
		if(email.equals("ramu.d513@gmail.com")&&password.equals("ramu"))
			return "success";
		else
			return "failure";
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}