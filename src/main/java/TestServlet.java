package main.java;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tolgacaner on 05/04/16.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Test Servlet</h1>");
        out.println("<h1>Test Servlet 2</h1>");
        Session session = Main.getSession();
        out.println("<h1>Test Servlet 3</h1>");
        Transaction tx = null;
        Integer userID = null;
        out.println("<h1>Test Servlet 4</h1>");
        try{
            out.println("<h2>Trying.. 1</h2>");
            tx = session.beginTransaction();
            out.println("<h2>Trying.. 2</h2>");
            FCUser user = new FCUser("Tolga", "Caner", "1234");
            out.println("<h2>Trying.. 3</h2>");
            userID = (Integer) session.save(user);
            out.println("<h2>Trying.. 4</h2>");
            tx.commit();
            out.println("<h2>"+ "Wrote:" + user.getFirstName() + "Lastname:" + user.getLastName() + "Password:" + user.getPassword() + "</h2>");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            out.println(e.getStackTrace().toString());
        }finally {
            session.close();
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }


}
