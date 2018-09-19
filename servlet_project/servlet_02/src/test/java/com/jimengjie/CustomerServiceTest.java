package com.jimengjie;
/**
 * @author:zh
 * @description:
 * @date:2018/9/11
 */

import com.jimengjie.model.Customer;
import com.jimengjie.service.CustomerService;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerService 单元测试
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    /*@Before
    public void init() throws Exception {
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }*/

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

}
