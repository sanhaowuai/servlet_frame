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
 *@author:zh
 *@description:提供客户数据服务
 *@date:2018/9/19
 */
public class CustomerService {
    //定义LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "select * from customer where contact=? or contact=?";
        String[] paramArr = {"Jack","Rose"};
        //使用ThreadLocal后，不需要再用service写连接了
        //conn = DatabaseHelper.getConnection();
        //若无参数，即paramArr为空时，参数可不传。
        return DatabaseHelper.queryEntityList(Customer.class,sql,paramArr);
    }

    /**
     * 测试返回值为List<Map<String,Object>>
     * @return
     */
    /*public List<Map<String,Object>> getCustomerList() {
        String sql = "select * from customer where contact=? or contact=?";
        String[] paramArr = {"Jack","Rose"};
        //使用ThreadLocal后，不需要再用service写连接了
        //conn = DatabaseHelper.getConnection();
        //若无参数，即paramArr为空时，参数可不传。
        return DatabaseHelper.executeQuery(sql,paramArr);
    }*/

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
       return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
