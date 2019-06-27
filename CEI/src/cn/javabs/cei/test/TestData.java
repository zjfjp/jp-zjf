package cn.javabs.cei.test;
import cn.javabs.cei.entity.News;

import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestData {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
    @Test
    public void fun() throws SQLException {

        News news = new News();
        List<News> newss = qr.query("select * from news ",new BeanListHandler<News>(News.class));

        System.out.println(newss);
    }
}
