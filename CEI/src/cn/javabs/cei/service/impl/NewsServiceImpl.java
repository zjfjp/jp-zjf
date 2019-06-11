package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.NewsDao;
import cn.javabs.cei.dao.impl.NewsDaoImpl;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.NewsService;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();
    @Override
    public int addNews(News news) {

        return newsDao.addNews(news);
    }
}
