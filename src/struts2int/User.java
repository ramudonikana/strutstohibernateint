package struts2int;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
private int id;
private String name,password,email,address1,address2,city,state,zipcode,mobile;
private char gender;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
@Override
	public void validate() {
	if(name.length()<1)
		addFieldError("name", "name cant be blank");
	if(password.length()<6)
		addFieldError("password", "password cant be less than 6 chars");
	if(email.length()<1)
		addFieldError("email", "email cant be blank");
	if(address1.length()<1)
		addFieldError("address1", "address1 cant be blank");
	
	if(address2.length()<1)
		addFieldError("address2", "address2 cant be blank");

	if(city.length()<1)
		addFieldError("city", "city cant be blank");

	if(state.length()<1)
		addFieldError("state", "state cant be blank");
	if(zipcode.length()<0)
		addFieldError("zipcode", "zipcode cant be blank");
	if(mobile.length()<0)
		addFieldError("mobile", "mobile cant be blank");
	}
public String execute(){
	RegisterDao.saveUser(this);
	return "success";
}

}
