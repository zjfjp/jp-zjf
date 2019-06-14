package cn.javabs.cei.dao;

import cn.javabs.cei.entity.News;

import java.util.List;

public interface NewsDao {
    int addNews(News news);

    int updateNews(News news);

    News findNewsById(int id);

    List<News> findAllNews();

    int delNews(int id);
}
