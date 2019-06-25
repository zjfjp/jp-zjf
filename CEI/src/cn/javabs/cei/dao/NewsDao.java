package cn.javabs.cei.dao;

import cn.javabs.cei.entity.News;

import java.util.List;

public interface NewsDao {
    int addNews(News news);

    int updateNews(News news);

    int delNews(int id);

    News getfindNewsById(int id);

    List<News> getAllNews();

    Object getfindNewsByLike(String author);

    News getfindNewsByName(String author);
}
