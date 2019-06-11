package cn.javabs.cei.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DbcpUtil {
    public static DataSource dataSource;


        static{
        try {
            InputStream inputStream = DbcpUtil.class.getClassLoader().getResourceAsStream("jdcp.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public static DataSource getDataSource () {
        return null;
    }
    }

