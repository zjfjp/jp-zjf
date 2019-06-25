package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Column;
import cn.javabs.cei.entity.News;

import java.util.List;

public interface ColumnDao {
    List<Column> getAllColumn();

    int findPageNewsNumber(String columnId);

    List<News> findPageNews(int startIndex, int pageSize, String columnId);

    int findAllNewsNumber();

    List<News> findAllNewsRecords(int startIndex, int pageSize);

    void updateColumn(Column column);

    void removeColumn(String columnId);

    void save(Column column);

    void getColumnById(String id);
}
