package mx.com.axity.users.services.Impl;

import mx.com.axity.users.commons.to.ResponseTO;
import mx.com.axity.users.commons.to.AddressTO;
import mx.com.axity.users.model.AddressDO;
import mx.com.axity.users.persistence.AddressRepository;
import mx.com.axity.users.services.IAddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressService{
	
static final Logger LOG = LogManager.getLogger(AddressServiceImpl.class);
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public AddressTO getAddressByaddressId(int addressId) {
		
		LOG.info("Obteniendo valor para el parámetro " + addressId);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AddressDO addressDo = addressRepository.findByAddressId(addressId);
		AddressTO returnValue = modelMapper.map(addressDo, AddressTO.class);
		
		return returnValue;
	}
        @Override
	public AddressTO getAddressByUserId(int userId) {
		
		LOG.info("Obteniendo valor para el parámetro " + userId);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AddressDO addressDo = addressRepository.findByUserid(userId);
		AddressTO returnValue = modelMapper.map(addressDo, AddressTO.class);
		
		return returnValue;
	}
        @Override
	public List<AddressTO> getAllByUserid(int userid) {
		
		LOG.info("Obteniendo todad las Address ");
		
		List<AddressDO> AddressDo =  addressRepository.findAllByUserid(userid);

		return AddressDo.stream()
					  .map(this::convertToTO)
					  .collect(Collectors.toList());
	}
	@Override
	public List<AddressTO> getAllAddress() {
		
		LOG.info("Obteniendo todad las Address ");
		
		List<AddressDO> AddressDo =  (List<AddressDO>) addressRepository.findAll();

		return AddressDo.stream()
					  .map(this::convertToTO)
					  .collect(Collectors.toList());
	}

	
	private AddressTO convertToTO(AddressDO address) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AddressTO userTo = modelMapper.map(address, AddressTO.class);
		
		return userTo;
	}
	
	@Override
	public ResponseTO createAddress(AddressTO address) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AddressDO addressDo = modelMapper.map(address, AddressDO.class);
		
		addressRepository.save(addressDo);
		
		ResponseTO responseValue = new ResponseTO();
		
		responseValue.setCode(201);
		responseValue.setMessage("Se ha creado el usuario con identificador --> " + addressDo.getAddressId());
		
		return responseValue;
	}

	@Override
	public ResponseTO updateAddress(int addressId, AddressTO address) {
		
		AddressDO addressDo = addressRepository.findByAddressId(addressId);
		
		addressDo.setStreet(address.getStreet());
		addressDo.setNum(address.getNum());
		addressDo.setCP(address.getCP());
		addressDo.setSuburb(address.getSuburb());
		addressDo.setCity(address.getCity());
		addressDo.setUserid(address.getUserid());
                
		addressRepository.save(addressDo);
		
		ResponseTO responseValue = new ResponseTO();
		responseValue.setCode(200);
		responseValue.setMessage("Se ha actualizado el usuario con identificador --> " + addressId);
		
		return responseValue;
	}

	@Override
	public ResponseTO deleteAddress(int addressId) {
		addressRepository.deleteByAddressId(addressId);
		ResponseTO responseValue = new ResponseTO();
		responseValue.setCode(200);
		responseValue.setMessage("Se ha borrado el usuario con identificador --> " + addressId);
		
		return responseValue;
	}


}
