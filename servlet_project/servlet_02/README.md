# javaweb_frame

编写Java Web框架
### 1. 搭建大致框架并测试连接数据库

#### 1.1 建立多级包目录

如想建立com下的jimengjie,则需要com/jimengjie即可。中间是/。

#### 1.2 增加内容
1. 创建数据库demo
2. 创建表（查看已创建表的建表语句：show create table customer）  
```
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
```
3. 增加数据
```
TRUNCATE customer;
INSERT INTO customer (name, contact, telephone, email, remark) VALUES ('customer1', 'Jack', '13512345678', 'jack@gmail.com', null);  
INSERT INTO customer (name, contact, telephone, email, remark) VALUES ('customer2', 'Rose', '13623456789', 'rose@gmail.com', null);
```
4. 增加controller（空文件夹）,service,model分层，增加jsp(空文件夹)，并增加resources(config.properties),test测试文件夹。  
测试 CustomerService 中的 getCustomerList 方法。


#### 1.3 出现连接sql错误（mysql5.7）
在sql的查询框执行  
set sql_mode=(select replace(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

