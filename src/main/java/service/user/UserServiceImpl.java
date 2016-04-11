package service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import test.Member;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Member> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<Member> findAllUsers() {
		return users;
	}
	
	public Member findById(long id) {
		for(Member user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public Member findByName(String name) {
		for(Member user : users){
			if(user.getFirstName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(Member user) {
		user.setId((int) counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(Member user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<Member> iterator = users.iterator(); iterator.hasNext(); ) {
			Member user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(Member user) {
		return findByName(user.getFirstName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<Member> populateDummyUsers(){
		List<Member> users = new ArrayList<Member>();
		users.add(new Member("Sam", "NY", "sam@abc.com"));
		users.add(new Member("Tomy", "ALBAMA", "tomy@abc.com"));
		users.add(new Member("Kelly", "NEBRASKA", "kelly@abc.com"));
		return users;
	}

}
