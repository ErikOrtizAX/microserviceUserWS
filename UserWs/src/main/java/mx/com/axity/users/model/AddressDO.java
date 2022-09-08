package mx.com.axity.users.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;


@Entity
@Table(name = "address")
public class AddressDO implements Comparable<AddressDO>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idaddress")
	private int addressId;

	@Column(name = "Street")
	private String Street;

	@Column(name = "Num")
	private String Num;

	@Column(name = "CP")
	private String CP;
	@Column(name = "Suburb")
	private String Suburb;
	@Column(name = "City")
	private String City;
	@Column(name = "userid")
	private int userid;


	protected AddressDO() {

	}

	public AddressDO(int addressId, String street, String num, String CP, String suburb, String city, int userid) {
		this.addressId = addressId;
		this.Street = street;
		this.Num = num;
		this.CP = CP;
		this.Suburb = suburb;
		this.City = city;
		this.userid = userid;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getNum() {
		return Num;
	}

	public void setNum(String num) {
		Num = num;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String CP) {
		this.CP = CP;
	}

	public String getSuburb() {
		return Suburb;
	}

	public void setSuburb(String suburb) {
		Suburb = suburb;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.addressId).toHashCode();
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
			AddressDO that = (AddressDO) object;
			isEquals = new EqualsBuilder().append(this.addressId, that.addressId).isEquals();
		}
		return isEquals;
	}




	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
                        .append("addressid", this.addressId)
                        .append("Street", this.Street)
                        .append("Num", this.Num)
                        .append("CP", this.CP)
                        .append("Suburb", this.Suburb)
                        .append("City", this.City)
                        .append("userid", this.userid)
                        .toString();
	}

        
	
	@Override
	public int compareTo(AddressDO o) {
		return new CompareToBuilder().append(this.addressId, o.addressId).toComparison();
	}




}
