/*
 * Name: Duy Tran
 * Date: March 13, 2015
 */

package server;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CustomerInformationBean
 */
@Stateless
@LocalBean
public class CustomerInformationBean {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private String ethnicity;
	private String gender;
	private String[] fruits;
	private String comment;
	
    /**
     * Default constructor. 
     */
    public CustomerInformationBean() {
        // TODO Auto-generated constructor stub
    }

    public String getPersonalInfo() {
    	String result = "SUBSCRIBED<br/>";
    	result += "Name: " + getFirstName() + " " + getLastName() + "<br/>";
    	result += "Address: " + getAddress() + "<br/>";
    	result += getCity() + ", " + getState() +", " + getZip() + "<br/>";
    	result += "Phone: " + getPhone() + "<br/>";
    	result += "Email: " + getEmail() + "<br/>";
    	return result;
    }
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName.toUpperCase().charAt(0) + "";
		this.firstName += firstName.toLowerCase().substring(1, firstName.length());
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName.toUpperCase().charAt(0) + "";
		this.lastName += lastName.toLowerCase().substring(1, lastName.length());
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		if (phone.isEmpty())
			return "n/a";
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		if (email.isEmpty())
			return "n/a";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender == null)
			this.gender = "Asian";
		else
			this.gender = gender;
	}

	public String getFruits() {
		String result = "";
		for (String f: fruits) {
			result += f + ", ";
		}
		if (result.isEmpty())
			return "You do not have a favorite fruit.";
		else
			return result.substring(0, result.length()-2);
	}

	public void setFruits(String[] fruits) {
		if (fruits != null) {
			this.fruits = new String[fruits.length];
			for(int i = 0; i < fruits.length; i++)
				this.fruits[i] = fruits[i];
		}
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
}
