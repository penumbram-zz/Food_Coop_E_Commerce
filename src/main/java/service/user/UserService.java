package service.user;

import java.util.List;
import rest.Member;


public interface UserService {
	
	Member findById(long id);

	Member findByName(String name);
	
	void saveUser(Member member);
	
	void updateUser(Member member);
	
	void deleteUserById(long id);

	List<Member> findAllUsers();
	
	void deleteAllUsers();
	
	public boolean isUserExist(Member member);
	
}
