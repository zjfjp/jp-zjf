package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.NewsDao;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.util.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class NewsDaoImpl implements NewsDao {

    QueryRunner queryRunner = new QueryRunner(DbcpUtil.getDataSource());

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @Override
    public int addNews(News news) {
        try {
            return queryRunner.update("insert into news(id,title,description,author,content,createTime,column) values(?,?,?,?,?,?,?)",news.getId(),news.getTitle(),
                    news.getDescription(),news.getAuthor(),news.getContent(),news.getCreateTime(),news.getColumn()
                    );
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
        try {
            return queryRunner.update("update news set title = ? where id = ?",news.getTitle(),news.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 根据id查询新闻
     * @param news
     * @return
     */
    @Override
    public News findNewsById(int id) {
        try {
            News news = queryRunner.query("select * from news where id = ?",new BeanHandler<News>(News.class));
            return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有新闻
     * @param news
     * @return
     */
    @Override
    public List<News> findAllNews() {
        List<News> news = null;
        try {
            news = queryRunner.query("select * from news",new BeanListHandler<News>(News.class));
            return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除新闻
     * @param news
     * @return
     */
    @Override
    public int delNews(int id) {
        try {
            return queryRunner.update("delete from news where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
