package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.NewsDao;
import cn.javabs.cei.dao.impl.NewsDaoImpl;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public int addNews(News news) {

        return newsDao.addNews(news);
    }

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();
    }

    @Override
    public News findNewsById(int id) {
        return newsDao.findNewsById(id);

    }

    @Override
    public int updateNews(News news) {
        return newsDao.updateNews(news);
    }

    @Override
    public int delNews(int id) {
        return newsDao.delNews(id);
    }
}
