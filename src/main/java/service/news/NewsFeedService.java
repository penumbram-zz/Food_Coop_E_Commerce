package service.news;

import java.util.List;

import rest.News;
import rest.Producer;


public interface NewsFeedService {

	News findById(long id);

	News findByName(String name);

	void saveNews(News news);

	void updateNews(News news);

	void deleteNewsById(long id);

	List<News> getAllNews();

	void deleteAllNews();

	public boolean isNewsExist(News news);

}
