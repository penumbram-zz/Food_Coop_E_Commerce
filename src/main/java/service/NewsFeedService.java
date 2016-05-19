package service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.News;
import rest.Product;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tolgacaner on 26/04/16.
 */
@Service("newsFeedService")
@Transactional
public class NewsFeedService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<News> news;

    static{
        //	members= populateDummyUsers();
        Session session = Main.getSession();
        Query query = session.createQuery("from News ");
        news = query.list();
    }

    public List<News> getAllNews() {
        return news;
    }
}
