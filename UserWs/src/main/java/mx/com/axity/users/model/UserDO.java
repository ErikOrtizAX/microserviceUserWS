package mx.com.axity.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "user")
public class UserDO implements Comparable<UserDO>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "Name")
	private String Name;
	
	protected UserDO () {
		
	}
	
	public UserDO (int userId, String Email, String Password, String Name) {
		
		this.userId = userId;
		this.Email = Email;
		this.Password = Password;
		this.Name = Name;
	}
	

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
	 * @return the Email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param Email the Email to set
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

	/**
	 * @return the Password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the Password to set
	 */
	public void setPassword(String password) {
		this.Password = password;
	}

	/**
	 * @return the userInformationId
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the userInformationId to set
	 */
	public void setName(String name) {
		this.Name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.userId).toHashCode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object object) {

		boolean isEquals = false;

		if (this == object) {
			isEquals = true;
		} else if (object != null && object.getClass().equals(this.getClass())) {
			UserDO that = (UserDO) object;
			isEquals = new EqualsBuilder().append(this.userId, that.userId).isEquals();
		}
		return isEquals;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("userId", this.userId).append("Email", this.Email)
				.append("Password", this.Password).append("userName", this.Name).toString();
	}

	
	@Override
	public int compareTo(UserDO o) {
		return new CompareToBuilder().append(this.userId, o.userId).toComparison();
	}


}
