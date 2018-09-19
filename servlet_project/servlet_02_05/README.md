# javaweb_frame

### 1. 数据库连接池Apache DBCP

#### 1.1 数据库连接池

每次需要数据库连接时，就调用getConnection方法，在数据库操作完毕后，还需要
调用closeConnection方法关闭数据库连接。虽然关闭这件事情已经被DatabaseHelper类给
封装了，但考虑到如果频繁使用getConnection方式就会频繁创建数据库连接，这样做一定
会造成大量的系统开销，毕竟数据库的连接数是有限的。因此，需要考虑一种解决方案，
将这些数据库连接进行“池化”，也就是说，我们需要弄一个“数据库连接池”出来。
Apache DBCP则是解决方案之一。

#### 1.2 添加Apache DBCP

1. 添加如下依赖   
```
<!-- Apache DBCP -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.0.1</version>
</dependency>
```
2. 修改DatabaseHelper类

+ 通过DRIVER，URL ，USERNAME，PASSWORD初始化BasicDataSource，并调用其getConnetion
方法即可获取数据库连接。删除之前的Class.forName(DRIVER)和DriverManager获取数据库的代码。
+ 删除closeConnection方法，同时去掉所有closeConnection的finally代码块。

