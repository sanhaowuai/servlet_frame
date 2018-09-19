package com.jimengjie.service;


import com.jimengjie.helper.DatabaseHelper;
import com.jimengjie.model.Customer;
import com.jimengjie.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 提供客户数据服务
 */
public class CustomerService {
    //定义LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        Connection conn = null;
        try{
            List<Customer> list = new ArrayList<Customer>();
            String sql = "select * from customer";
            /*conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);*/
            //使用DatabaseHelper进行获取连接
            conn = DatabaseHelper.getConnection();
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
            LOGGER.error("execute sql failure",e);
        }finally {
            //使用DatabaseHelper关闭连接
            DatabaseHelper.closeConnection(conn);
        }
        return null;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        /*String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);*/
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        /*return DatabaseHelper.insertEntity(Customer.class, fieldMap);*/
        return false;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        /*return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);*/
        return false;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {

       /* return DatabaseHelper.deleteEntity(Customer.class, id);*/
        return false;
    }
}
