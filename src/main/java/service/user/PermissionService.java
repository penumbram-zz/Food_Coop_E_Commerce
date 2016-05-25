package service.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.Member;

import java.util.List;


/**
 * Created by tolgacaner on 18/05/16.
 */

@Service("permissionService")
@Transactional
@Controller
public class PermissionService {

    public String getUserPermissionLevel() {
        /*
        Session session = Main.getSession();
        String loginQuery = "FROM Member M WHERE M.email = '" + username + "' AND M.password = '" + password + "'";
        Query query = session.createQuery(loginQuery);
        List<Member> member = query.list();

        if (member.size() == 1) {
            return member.get(0);
        }
        return null;
        */
        if (true)
            return "GUEST";
        else if (false)
            return "MEMBER";
        else if (false && false)
            return "ADMIN";

        return "GUEST";
    }
}
