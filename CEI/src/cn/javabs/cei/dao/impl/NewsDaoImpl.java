package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.NewsDao;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.util.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class NewsDaoImpl implements NewsDao {
    QueryRunner queryRunner = new QueryRunner(DbcpUtil.getDataSource());
    @Override
    public int addNews(News news) {
        try {
            return queryRunner.update("insert into news(title,description,author,content,createTime,column) values(?,?,?,?,?,?)",news.getTitle(),
                    news.getDescription(),news.getAuthor(),news.getContent(),news.getCreateTime(),news.getColumn()
                    );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
