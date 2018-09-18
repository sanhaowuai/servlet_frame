package com.jimengjie.helper;

import com.jimengjie.service.CustomerService;
import com.jimengjie.util.PropsUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
/**
 * 数据库助手类
 */
public final class DatabaseHelper {

    //定义LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER;

    static {
        //使用PropsUtil读取配置文件
        Properties props = PropsUtil.loadProps("config.properties");
        DRIVER = props.getProperty("jdbc.driver");
        URL = props.getProperty("jdbc.url");
        USERNAME = props.getProperty("jdbc.username");
        PASSWORD = props.getProperty("jdbc.password");

        QUERY_RUNNER = new QueryRunner();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can't load jdbc driver",e);
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure",e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure",e);
            }
        }
    }

    /**
     * 查询实体列表，Object... params可变长参数,<T> List<T>,前面的<T>定义该方法所拥有的泛型标识符（包含返回与入参），个数可以是多个
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass,Connection conn, String sql, Object... params) {
        List<T> entityList;
        try {
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity list failure", e);
            throw new RuntimeException(e);
        }
        return entityList;
    }
}
