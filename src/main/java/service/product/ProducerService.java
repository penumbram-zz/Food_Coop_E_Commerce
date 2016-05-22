package service.product;

import java.util.List;
import rest.Producer;


public interface ProducerService {

	Producer findById(long id);

	Producer findByName(String name);

	void saveProducer(Producer producer);

	void updateProducer(Producer producer);

	void deleteProducerById(long id);

	List<Producer> getAllProducers();

	void deleteAllProducers();

	public boolean isProducerExist(Producer member);

}
