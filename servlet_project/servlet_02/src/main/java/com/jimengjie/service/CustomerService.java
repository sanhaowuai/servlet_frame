package com.jimengjie.service;


import com.jimengjie.model.Customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *@author:zh
 *@description:提供客户数据服务
 *@date:2018/9/18
 */
public class CustomerService {

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties props = null;
        InputStream is = null;
        String fileName = "config.properties";
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        DRIVER = props.getProperty("jdbc.driver");
        URL = props.getProperty("jdbc.url");
        USERNAME = props.getProperty("jdbc.username");
        PASSWORD = props.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            /*LOGGER.error("can't load jdbc driver",e);*/
            e.printStackTrace();
        }
    }

    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList() {
        Connection conn = null;
        try{
            List<Customer> list = new ArrayList<Customer>();
            String sql = "select * from customer";
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement ptst = conn.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                list.add(customer);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
