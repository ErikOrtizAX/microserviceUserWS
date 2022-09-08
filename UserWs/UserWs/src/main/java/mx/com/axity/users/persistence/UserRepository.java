package mx.com.axity.users.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.axity.users.model.UserDO;

@Repository
public interface UserRepository extends CrudRepository<UserDO, Long>{
	
	UserDO findByUserId(int userId);

}
