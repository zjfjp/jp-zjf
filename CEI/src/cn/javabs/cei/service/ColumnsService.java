package cn.javabs.cei.service;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.entity.Columns;


import java.util.List;

public interface ColumnsService {

    //    查询所有新闻
    Page findAllNews(String pagenumber);
    //    查询所有栏目
    List<Columns> findAllColumns();
    //    按新闻分类的id及分页当前页码进行查询
    Page findAllNewsPageRecords(String pagenumber, String columnId);
    //    添加栏目
    void addColumns(Columns column);
    //    栏目修改
    void editColumns(Columns column);
    //    通过id查找栏目
    Columns findColumnsById(String columnId);
    //   根据id 删除栏目
    void delColumns(String columnId);

}
