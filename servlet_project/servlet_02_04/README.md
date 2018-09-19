# javaweb_frame

编写Java Web框架
### 1. 完善DatabaseHelper工具类

#### 1.1 增加ThreadLocal
1. 让Connection对于开发人员完全透明，也就是隐藏掉创建与关闭Connection的代码。
2. 为了确保一个线程中只有一个Connection,可以使用ThreadLocal来存放本地线程变量。
也就是说，将当前线程中的Connection放入ThreadLocal中存起来，这些Connection一定不会
出现线程不安全的问题，可以将ThreadLocal理解为一个隔离线程的容器。
3. 每次获取Connection时，首先在ThreadLocal中寻找，若不存在时，则创建一个新的
Connection,并将其放入ThreadLocal中。当Connection使用完毕后，需要移除ThreadLocal
中持有的Connection。

#### 1.2 DatabaseHelper增加中增加其他方法

增加如下方法：
+ queryEntity --查询实体
+ executeQuery --查询MapList
+ executeUpdate --执行更新、插入、删除提供共通方法
+ insertEntity --插入实体
+ updateEntity --更新实体
+ deleteEntity --删除实体
+ getTableName --得到表名（执行更新、插入、删除提供共通方法）

#### 1.4 完成测试代码

Junit测试CustomerService中所有方法。

#### 1.3 注意

**DatabaseHelper中：**

+ BeanListHandler 返回list对象
+ BeanHandler 返回Bean对象
+ BeanMapHandler 返回Map对象
+ ArrayHandler 返回Object[]对象
+ ArrayListHandler 返回List对象
+ MapHandler 返回Map对象
+ MapListHandler 返回List对象
+ ScalarHandler 返回某列的值
+ ColumnListHandler 返回某列的值列表

**以上Handler都实现了ResultSetHandler。**

