package mx.com.axity.users.commons.to;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3689346877580023771L;
	
	private int userId;
	private String Email;
	private String Password;
	private String Name;
    private List<AddressTO> Address;


	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the userInformationId to set
	 */
	public void setName(String name) {this.Name = name;}

        public List<AddressTO> getAddress() {
            return Address;
        }

        public void setAddress(List<AddressTO> Address) {
            this.Address = Address;
        }

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
                        .append("userId", this.userId)
                        .append("Email", this.Email)
                        .append("Password", this.Password)
                        .append("userName", this.Name)
                        .append("Address", this.Address)
                        .toString();
	}

        


}
