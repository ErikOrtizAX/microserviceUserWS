package mx.com.axity.users.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.users.commons.constants.Constants;
import mx.com.axity.users.commons.to.ResponseTO;
import mx.com.axity.users.commons.to.ResponseTestTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import mx.com.axity.users.commons.to.AddressTO;
import mx.com.axity.users.services.IAddressService;

@RestController
@RequestMapping("address/v1")
@Api(value = "address-ws")
public class AddressController {

	static final Logger LOG = LogManager.getLogger(AddressController.class);

	@Autowired
	private Environment env;
	
	
	@Autowired
	IAddressService AddressService;

	@GetMapping(value = "/address", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<AddressTO>> getAddress() {
		LOG.info("Se invoca GET /Address" + env.getProperty("local.sever.port"));
		List<AddressTO> returnResponse = AddressService.getAllAddress();
		return new ResponseEntity<List<AddressTO>>(returnResponse, HttpStatus.OK);
	}
        
    @GetMapping(value = "/address/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AddressTO> getById(@PathVariable("id") int id) {
		LOG.info("Se invoca GET /address/" + id);
		AddressTO responseValue = new AddressTO();
        responseValue = AddressService.getAddressByaddressId(id);
		return new ResponseEntity<AddressTO>(responseValue, HttpStatus.OK);
	}
	        
	@PostMapping(value = "/Address", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTO> createUser(@RequestBody AddressTO request) {
		LOG.info("Se invoca POST /Address");
		ResponseTO responseValue = AddressService.createAddress(request);
		return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
	}

	@PutMapping(value = "/Address/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTO> updateUser(@PathVariable("id") int id, @RequestBody AddressTO request) {
		LOG.info("Se invoca PUT /Address/" + id);

		ResponseTO responseValue = AddressService.updateAddress(id, request);

		return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.OK);
	}

	@DeleteMapping(value = "/Addres/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTO> deleteUser(@PathVariable("id") int id) {
		ResponseTO responseValue = AddressService.deleteAddress(id);
		
		return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.OK);
	}

	@GetMapping(value = "/test", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTestTO> test() {
		LOG.info("Se invoca /test");
		ResponseTestTO returnResponse = new ResponseTestTO();
		returnResponse.setCode(200);
		returnResponse.setMesage("Servicio OK .. on port number --> " + env.getProperty("local.server.port")); 
		return new ResponseEntity<ResponseTestTO>(returnResponse, HttpStatus.OK);
	}

}
