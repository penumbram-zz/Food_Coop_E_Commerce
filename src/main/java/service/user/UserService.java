package service.user;

import java.util.List;
import test.Member;


public interface UserService {
	
	Member findById(long id);

	Member findByName(String name);
	
	void saveUser(Member user);
	
	void updateUser(Member user);
	
	void deleteUserById(long id);

	List<Member> findAllUsers();
	
	void deleteAllUsers();
	
	public boolean isUserExist(Member user);
	
}
