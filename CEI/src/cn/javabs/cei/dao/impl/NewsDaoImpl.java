package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.NewsDao;
import cn.javabs.cei.entity.News;

import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @Override
    public int addNews(News news) {
        try {

            return qr.update("insert into news(id,author,createTime,title,content,click,columnid) values (?,?,?,?,?,?,?) "
                    ,news.getId(),news.getAuthor(),news.getCreateTime(),news.getTitle(),news.getContent(),news.getClick(),news.getColumnid());

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * 修改新闻
     * @param news
     * @return
     */
    @Override
    public int updateNews(News news) {
        System.out.println(
                "daoImpl:"+news
        );
        try {
            int rows = qr.update("update news set author = ? , createTime= ? ,title=? , content=? , click=? ,columnid = ? where id= ? "
                    , news.getAuthor(), news.getCreateTime(), news.getTitle(), news.getContent(), news.getClick(), news.getColumnid(), news.getId());
            System.out.println("rows:"+rows);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除新闻
     * @param id
     * @return
     */
    @Override
    public int delNews(int id) {
        try {
            return qr.update("delete from news where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public News getfindNewsById(int id) {
        try {
        News news = null;
        news = qr.query("select * from news where id = ? ", new BeanHandler<News>(News.class),id);
        return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}

    /**
     * 查询所有新闻
     * @return
     */
    @Override
    public List<News> getAllNews() {
        List<News> list =null;

        try {

            list = qr.query(" select * from  news ,columns where  news.columnid = columns.cid ", new BeanListHandler<News>(News.class));
            System.out.println("list"+list);
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getfindNewsByLike(String author) {
        try {
            String sql="select * from news where l= l";
            ArrayList<String> list=new ArrayList<>();
            if (author != null){
                sql+="and author like ? ";
                list.add("%"+author+"%");
            }
            Object[] params =list.toArray();
            return qr.query(sql, new BeanListHandler<News>(News.class),params);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
}

    @Override
    public News getfindNewsByName(String author) {
        try {
            News news = qr.query("select * from news where author= ? ", new BeanHandler<News>(News.class), author);
            return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
