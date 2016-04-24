package service.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.Main;
import test.Member;

import java.util.List;

/**
 * Created by tolgacaner on 25/04/16.
 */

@Service("loginService")
@Transactional
public class LoginService {

    public void login(String username, String password) {
        Session session = Main.getSession();
        Query query = session.createQuery("from Member WHERE Member.email ==" + username);
        List<Member> members = query.list();

        if (members.size() == 1) {
            if (members.get(0).getPassword() == password) {
                //successful login
            }
        } else {

        }
    }
}
