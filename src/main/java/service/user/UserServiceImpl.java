package service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.Member;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Member> members;
	
	static{
	//	members= populateDummyUsers();
		Session session = Main.getSession();
		Query query = session.createQuery("from Member");
		members = query.list();
	}

	public List<Member> findAllUsers() {
		return members;
	}
	
	public Member findById(long id) {
		for(Member member : members){
			if(member.getId() == id){
				return member;
			}
		}
		return null;
	}
	
	public Member findByName(String name) {
		for(Member member : members){
			if(member.getFirstName().equalsIgnoreCase(name)){
				return member;
			}
		}
		return null;
	}
	
	public void saveUser(Member member) {
		member.setId(nextId());
		members.add(member);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.save(member);
		tx.commit();
		session.close();

	}

	public void updateUser(Member member) {
		int index = members.indexOf(member);
		members.set(index, member);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.update(member);
		tx.commit();
		session.close();
	}

	public void deleteUserById(long id) {
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext(); ) {
			Member member = iterator.next();
		    if (member.getId() == id) {
		        iterator.remove();
				Session session = Main.getSession();
				Transaction tx = session.beginTransaction();
				session.delete(member);
				tx.commit();
				session.close();
				break;
		    }
		}
	}

	public boolean isUserExist(Member member) {
		return findByName(member.getFirstName())!=null;
	}
	
	public void deleteAllUsers(){
		members.clear();
	}

	private static List<Member> populateDummyUsers(){
		List<Member> members = new ArrayList<Member>();
		Member member1 = new Member("Sam", "Wise", "123456","Banana Av. Onion Street","24 SmallVille 10018");
		member1.setId(nextId());
		Member member2 = new Member("Bilbo", "Baggins", "mineonlymine","Banana Av. Monkey Street","57 SmallVille 10018");
		member2.setId(nextId());
		Member member3 = new Member("Franz", "Ferdinand", "niceshot1914","Pear Av. Seed Street","109 SmallVille 10018");
		member3.setId(nextId());
		members.add(member1);
		members.add(member2);
		members.add(member3);
		return members;
	}

	private static int nextId() {
		return (int) counter.incrementAndGet();
	}

}
