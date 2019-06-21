package cn.javabs.cei.service;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.entity.Column;

import java.util.List;

public interface ColumnService {
    Page findAllNews(String pagenumber);

    List<Column> findAllColumn();

    Page findAllNewsPageRecords(String pagenumber, String columnId);

    void addColumn(Column column);
}
