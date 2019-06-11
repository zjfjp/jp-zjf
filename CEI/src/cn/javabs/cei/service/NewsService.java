package cn.javabs.cei.service;

import cn.javabs.cei.entity.News;

public interface NewsService {
    //添加新闻
    int addNews(News news);
    //查找新闻
    int findAllNews(News news);
    //修改新闻
    int updateNews(News news);
    //删除新闻
    int delNews(News news);
}
