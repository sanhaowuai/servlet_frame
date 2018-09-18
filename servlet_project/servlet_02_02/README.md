# javaweb_frame

编写Java Web框架
### 1. 完善控制器_01

#### 1.1 增加控制器类及视图

增加CustomerServlet.java,customer.jsp，实现查看列表功能。

#### 1.2 不在service中读取config.properties文件，增加DatabaseHelper工具类。

修改CustomerService类，使用DatabaseHelper进行获取与关闭数据库连接。

#### 1.3 部署访问localhost:8080

#### 1.4 遗留问题：对于每个客户来说，增删改查都增加一个servlet来处理，答案是否定的。

