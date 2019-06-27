package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.ColumnDao;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ColumnDaoImpl implements ColumnDao {
    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    public void save(Column column) {

        try {
            qr.update("insert into columns(name) values(?)", column.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getColumnById(String id) {

    }

    @Override
    public List<Column> getAllColumn() {
        try {
            return qr.query("select * from columns", new BeanListHandler<Column>(Column.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findPageNewsNumber(String columnId) {
        try {
        Object obj = null;
        obj = qr.query("select count(*)  from news where columnId = ?",new ScalarHandler(1),columnId);
        Long num =  (Long) obj;
        return num.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<News> findPageNews(int startIndex, int pageSize, String columnId) {
        try {
            return qr.query("select *  from news where columnId = ? limit ?,?",new BeanListHandler<News>(News.class),columnId,startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findAllNewsNumber() {
        try {
        Object obj = null;
        obj = qr.query("select count(*) from news",new ScalarHandler(1));
        Long num =(Long) obj;
        return num.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<News> findAllNewsRecords(int startIndex, int pageSize) {
        try {
        List<News> news = qr.query("select * from news limit ? , ? " ,new BeanListHandler<>(News.class),startIndex,pageSize);

        System.out.println("news:"+news);
        return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateColumn(Column column) {

        try {
            qr.update("update columns set name = ? where cid = ? ", column.getName(), column.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeColumn(String columnId) {

        try {
            qr.update("delete from columns where cid = ? ",columnId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
