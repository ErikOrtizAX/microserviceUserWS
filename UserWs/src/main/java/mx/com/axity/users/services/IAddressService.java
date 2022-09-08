package mx.com.axity.users.services;

import mx.com.axity.users.commons.to.ResponseTO;
import mx.com.axity.users.commons.to.AddressTO;

import java.util.List;

public interface IAddressService {

	AddressTO getAddressByaddressId(int addressId);
    AddressTO getAddressByUserId(int userId);
	List<AddressTO> getAllAddress();
	List<AddressTO> getAllByUserid(int userId);
	ResponseTO createAddress(AddressTO address);
	ResponseTO updateAddress(int usrId, AddressTO address);
	ResponseTO deleteAddress(int usrId);


}
