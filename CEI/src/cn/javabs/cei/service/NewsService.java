package cn.javabs.cei.service;

import cn.javabs.cei.entity.News;

import java.util.List;

public interface NewsService {


    //添加新闻
    int addNews(News news);
    //查询所有新闻
    List<News> findAllNews();
    //查询单个新闻
    News findNewsById(int id);
    //修改新闻
    int updateNews(News news);
    //删除新闻
     int delNews(int newsId) ;


}
