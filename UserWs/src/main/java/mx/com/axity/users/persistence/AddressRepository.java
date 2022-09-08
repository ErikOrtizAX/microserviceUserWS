package mx.com.axity.users.persistence;

import java.util.List;
import mx.com.axity.users.model.AddressDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressDO, Long>{
	
		AddressDO findByAddressId(int addressId);
        List<AddressDO> findAllByUserid(int userid);
        AddressDO findByUserid(int userid);
        void deleteByAddressId(int addressId);
        
}
