package cn.javabs.cei.test;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.util.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestData {

    QueryRunner queryRunner = new QueryRunner(DbcpUtil.getDataSource());
    @Test
    public void fun() throws SQLException {
        News news = new News();
        List<News> news1 = (List<News>) queryRunner.query("select * from news", new BeanHandler<News>(News.class));

    }

}
