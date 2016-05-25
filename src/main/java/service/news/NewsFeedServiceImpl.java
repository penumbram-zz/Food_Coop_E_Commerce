package service.news;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.News;

@Service("newFeedService")
@Transactional
@Controller
public class NewsFeedServiceImpl implements NewsFeedService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<News> news;

    static{
        Session session = Main.getSession();
        Query query = session.createQuery("from News").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        news = query.list();

    }

    public List<News> getAllNews() {
        return news;
    }

    public News findById(long id) {
        for(News aNew : news){
            if(aNew.getId() == id){
                return aNew;
            }
        }
        return null;
    }

    public News findByName(String name) {
        for(News aNew : news){
            if(aNew.getName().equalsIgnoreCase(name)){
                return aNew;
            }
        }
        return null;
    }

    public void saveNews(News aNew) {
        aNew.setId(nextId());
        news.add(aNew);
        Session session = Main.getSession();
        Transaction tx = session.beginTransaction();
        session.save(aNew);
        tx.commit();
        session.close();

    }

    public void updateNews(News aNew) {
        News pNews = findById(aNew.getId());
        int index = news.indexOf(pNews);
        news.set(index, aNew);
        Session session = Main.getSession();
        Transaction tx = session.beginTransaction();
        session.update(aNew);
        tx.commit();
        session.close();
    }

    public void deleteNewsById(long id) {
        for (Iterator<News> iterator = news.iterator(); iterator.hasNext(); ) {
            News aNew = iterator.next();
            if (aNew.getId() == id) {
                iterator.remove();
                Session session = Main.getSession();
                Transaction tx = session.beginTransaction();
                session.delete(aNew);
                tx.commit();
                session.close();
                break;
            }
        }
    }

    public boolean isNewsExist(News aNew) {
        return findByName(aNew.getName())!=null;
    }

    public void deleteAllNews(){
        news.clear();
    }

    private static int nextId() {
        return (int) counter.incrementAndGet();
    }

}
