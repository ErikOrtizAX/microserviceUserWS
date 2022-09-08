package mx.com.axity.users.services;

import java.util.List;

import mx.com.axity.users.commons.to.ResponseTO;
import mx.com.axity.users.commons.to.UserTO;

public interface IUserService {
	
	/**
	 * obtiene el usuario por id
	 * @param userId
	 * @return
	 */
	UserTO getUserById(int userId);
	/**
	 * obtiene todos los usuarios de la base
	 * @return
	 */
	List<UserTO> getAllUsers();
	ResponseTO createUser(UserTO user);
	ResponseTO updateUser(int usrId, UserTO user);
	ResponseTO deleteUser(int usrId, UserTO user);

}
