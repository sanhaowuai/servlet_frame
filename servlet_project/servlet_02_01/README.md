# javaweb_frame

编写Java Web框架
### 1. 完善框架

#### 1.1 增加工具类

pom文件中添加如下依赖
```
<!--log4j-->
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>1.7.7</version>
</dependency>
<!--apache.commons-->
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.7</version>
</dependency>
<!--apache.commons-->
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-collections4</artifactId>
  <version>4.0</version>
</dependency>
```
1. 增加PropsUtil（读配置文件）,CastUtil(数据转型)，StringUtil(字符串操作)，CollectionUtil(操作集合)四个工具类。
2. 增加log4j.properties配置文件
3. 使用PropsUtil读取配置文件类

