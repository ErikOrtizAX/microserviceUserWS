package mx.com.axity.users.commons.to;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AddressTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3689346877580023771L;
	
	private int addressId;
	private String Street;
	private String Num;
	private String CP;
	private String Suburb;
	private String City;
	private int userid;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String Num) {
        this.Num = Num;
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

    public void setSuburb(String Suburb) {
        this.Suburb = Suburb;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


	
    @Override
    public String toString() {

        return new ToStringBuilder(this)
        .append("addressId", this.addressId)
        .append("Street", this.Street)
        .append("Num", this.Num)
        .append("CP", this.CP)
        .append("Suburb", this.Suburb)
        .append("City", this.City)
        .append("userid", this.userid)
        .toString();
    }


}
