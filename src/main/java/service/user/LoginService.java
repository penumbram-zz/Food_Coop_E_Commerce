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

    public Member login(String username, String password) {
        Session session = Main.getSession();
        String loginQuery = "FROM Member M WHERE M.email = '" + username + "' AND M.password = '" + password + "'";
        Query query = session.createQuery(loginQuery);
        List<Member> member = query.list();

        if (member.size() == 1) {
            return member.get(0);
        }
        return null;
    }
}
