package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Columns;

import cn.javabs.cei.entity.News;

import java.util.List;

public interface ColumnsDao {
    List<Columns> getAllColumns();

    int findPageNewsNumber(String columnId);

    List<News> findPageNews(int startIndex, int pageSize, String columnId);

    int findAllNewsNumber();

    List<News> findAllNewsRecords(int startIndex, int pageSize);

    void updateColumns(Columns column);



    void removeColumns(String columnId);

    void save(Columns column);

    void getColumnsById(String id);
}
