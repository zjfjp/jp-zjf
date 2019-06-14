package cn.javabs.cei.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类全都用static
 */

public class DbcpUtil {
    public static DataSource dataSource;


        static{
        try {
            InputStream inputStream = DbcpUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
             //核心类         数据源工厂的       创建数据资源
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
       //                          获取数据源
        public static DataSource getDataSource () {

            return dataSource;
    }
    public static Connection getConnection () {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    }


