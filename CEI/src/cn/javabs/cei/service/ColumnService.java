package cn.javabs.cei.service;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.entity.Column;

import java.util.List;

public interface ColumnService {

    //    查询所有新闻
    Page findAllNews(String pagenumber);
    //    查询所有栏目
    List<Column> findAllColumn();
    //    按新闻分类的id及分页当前页码进行查询
    Page findAllNewsPageRecords(String pagenumber, String columnId);
    //    添加栏目
    void addColumn(Column column);
    //    栏目修改
    void editColumn(Column column);
    //    通过id查找栏目
    Column findColumnById(String columnId);
    //   根据id 删除栏目
    void delColumn(String columnId);

}
