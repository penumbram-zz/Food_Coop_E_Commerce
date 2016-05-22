package service.product;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.Member;
import rest.Producer;

@Service("producerService")
@Transactional
public class ProducerServiceImpl implements ProducerService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Producer> producers;

	static{
		//	producers= populateDummyProducers();
		Session session = Main.getSession();
		Query query = session.createQuery("from Producer").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		producers = query.list();

	}

	public List<Producer> getAllProducers() {
		return producers;
	}

	public Producer findById(long id) {
		for(Producer producer : producers){
			if(producer.getId() == id){
				return producer;
			}
		}
		return null;
	}

	public Producer findByName(String name) {
		for(Producer producer : producers){
			if(producer.getFirstName().equalsIgnoreCase(name)){
				return producer;
			}
		}
		return null;
	}

	public void saveProducer(Producer producer) {
		producer.setId(nextId());
		producers.add(producer);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.save(producer);
		tx.commit();
		session.close();

	}

	public void updateProducer(Producer producer) {
		Producer pProducer = findById(producer.getId());
		int index = producers.indexOf(pProducer);
		producers.set(index, producer);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.update(producer);
		tx.commit();
		session.close();
	}

	public void deleteProducerById(long id) {
		for (Iterator<Producer> iterator = producers.iterator(); iterator.hasNext(); ) {
			Producer producer = iterator.next();
			if (producer.getId() == id) {
				iterator.remove();
				Session session = Main.getSession();
				Transaction tx = session.beginTransaction();
				session.delete(producer);
				tx.commit();
				session.close();
				break;
			}
		}
	}

	public boolean isProducerExist(Producer producer) {
		return findByName(producer.getFirstName())!=null;
	}

	public void deleteAllProducers(){
		producers.clear();
	}

	private static int nextId() {
		return (int) counter.incrementAndGet();
	}

}
