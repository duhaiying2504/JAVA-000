# 第5周作业

## 周六作业 4.（必做）给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

1.starter: <https://github.com/duhaiying2504/java-training/tree/master/spring-boot-school-starter>

2.test for starter: [https://github.com/duhaiying2504/java-training/tree/master/school-starter-test](school-starter-test)

## 周六作业 6.（必做）研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法
0. 完整项目： [https://github.com/duhaiying2504/java-training/tree/master/jdbcs](jdbcs)
1. 最基础的实现：[https://github.com/duhaiying2504/java-training/blob/master/jdbcs/src/main/java/indi/haiying/jdbcs/dao/JdbcBadDao.java](JdbcBadDao.java)
2. 改进后的实现：[https://github.com/duhaiying2504/java-training/blob/master/jdbcs/src/main/java/indi/haiying/jdbcs/dao/JdbcDao.java](JdbcDao.java)
3. test: [https://github.com/duhaiying2504/java-training/blob/master/jdbcs/src/main/java/indi/haiying/jdbcs/service/SiteServiceTest.java](SiteServiceTest.java)


### 作业内容
> Week05 作业题目（周四）：

1.（选做）使 Java 里的动态代理，实现一个简单的 AOP。

2.（必做）写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 Github。

3.（选做）实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School。

4.（选做，会添加到高手附加题）

4.1 （挑战）讲网关的 frontend/backend/filter/router 线程池都改造成 Spring 配置方式；

4.2 （挑战）基于 AOP 改造 Netty 网关，filter 和 router 使用 AOP 方式实现；

4.3 （中级挑战）基于前述改造，将网关请求前后端分离，中级使用 JMS 传递消息；

4.4 （中级挑战）尝试使用 ByteBuddy 实现一个简单的基于类的 AOP；

4.5 （超级挑战）尝试使用 ByteBuddy 与 Instrument 实现一个简单 JavaAgent 实现无侵入下的 AOP。

> Week05 作业题目（周六）：

1.（选做）总结一下，单例的各种写法，比较它们的优劣。

2.（选做）maven/spring 的 profile 机制，都有什么用法？

3.（选做）总结 Hibernate 与 MyBatis 的各方面异同点。

4.（必做）给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

5.（选做）学习 MyBatis-generator 的用法和原理，学会自定义 TypeHandler 处理复杂类型。

6.（必做）研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：

1）使用 JDBC 原生接口，实现数据库的增删改查操作。

2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。

3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。

附加题（可以后面上完数据库的课再考虑做）：

(挑战) 基于 AOP 和自定义注解，实现 @MyCache(60) 对于指定方法返回值缓存 60 秒。

(挑战) 自定义实现一个数据库连接池，并整合 Hibernate/Mybatis/Spring/SpringBoot。

(挑战) 基于 MyBatis 实现一个简单的分库分表 + 读写分离 + 分布式 ID 生成方案。


#### 笔记
1. 空杯心态
2. 积极提意见，积极参与、不做沉默的大多数
3. 完成作业，合理安排时间，每周20小时学习
4. 课程是梳理脉络不是深度挖掘

尝试使用jdk11

什么是框架、组件、架构？

    业务组件、技术组件
    架构图纸
    
怎么理解spring框架？

spring6大模块

    常用模块    
    Integration -- 
    Languages:Kotlin/Groovy 混合语言编程 趋势？
    
spring框架设计

    更是一种研发协作的模式--MVC 分层思想 横向    
    不同业务组件  纵向划分，统计模块、分配任务等
    
spring为什么还使用Bean这个名字？（Java中pojo的bean）

Spring AOP

    AOP
    JAVA 是面向接口的语言
    运行时（启动）装配对象，IoC控制反转、依赖注入
    依赖于抽象，而不是具体
    两个依赖的业务模块jar包可以分离，打破直接依赖，运行时放在一起。解耦
    处理循环依赖，放在bean初始化之后。（构造函数上的循环依赖，处理不了）
    循环依赖（死锁）的业务场景
    
    实现AOP等方式
        接口：jdkProxy 动态代理
        非接口：cglib   字节码增强 （运行期生成）    
        around before -> before -> method -> around after -> after
    [DEMO]      
    一个对象的代理有哪些种类？用在什么场景？
    字节码增强有哪些类似CGlib的工具？
        
    字节码增加和反射的区别？
        基因操作和CT照B超的区别，字节码更改字节码的结构
        
    AOP  
        cglib  
        asm  
        aspectj  很古老的包
        java proxy  
        javassist 
        instrumentation    
        ByteBuddy字节码增强工具，更友好的api
        
Spring Bean生命周期

    context上下文 （传递多量参数）
    bean的加载过程---类比classloader过程  【源码】
        过程复杂---通用的基础框架（为了更通用）
    由spring容器来管理bean，改变了编程和协作方式
    
spring xml配置原理

    xml规范-定义xml的格式
        xsd
        dtd
    从xml到bean的整个过程
    XmlBeans -> spring-xbean
    
spring bean配置方式演化
    
spring messaging

    MQ,同步转异步、依赖关系简单（都依赖mq）
    JMS规范
    怎么理解JMS，查看老师之前的连接？
    两种方式：点对点和发布订阅

    onMessage 重试机制需要自己实现
    

springboot的出发点

    越来越复杂，spring发展的必然选择；
    一切都是为了简化
    开发、配置、运行变简单    
    限定性框架和非限定性框架
    太灵活了不是好事 --> 约定大于配置
    
springboot如何做到简化？

    成熟
    去web容器化
    maven 

springboot本身是一套脚手架（解决方案、最佳实践），关注自动配置、配置驱动

springboot两大核心原理，各自如何实现？

    自动化配置
    spring-boot-starter
    
为什么要约定大于配置

    开箱即用
    profile机制，区分不同环境下参数配置
    starter

什么是脚手架？

Spring Boot自动配置注解有哪些？

    启动类注解
    条件化配置注解 --> 自动化配置
    
核心启动入口 

Starter的实现原理？

    Configuration
    spring.factories
    spring.provides
    additional-spring-configuration-metadata.json

JDBC主要接口？

    JDBC的具体不同实现，看做是对JDBC的增强（池化、事务、计算sql执行时间、熔断...）
    简单封装 -->  AOP  -->  字节码增强，都可以实现上者效果
    
数据库连接池化，为什么要池化？

池化实现的机制思路?

    getConnecton  从池中获取
    close         还给池
    
事务Connection

数据库连接池

    C3P0
    DBCP
    Druid
    Hikari
    
连接池需要哪些功能，如何实现？   

    池性能一般影响都不大
    连接池 
    字节码工具 类初始化阶段
    json系列化 时间度量很小，整体占比太小，抓重点
    
Hibernate

    ORM
    二级缓存
    
Mybatis

    半自动化ORM
    MyBatis-generator
    MyBatis-Plus插件
    
SQL的光芒不是可以被掩盖的

JPA,Java Persistence API

    接口和抽象类
    EntityManager

Spring JDBC -- MyBatis

Spring ORM -- JPA的实现

Spring Data with NoSQL

Spring管理事务 【回看】

    事务管理接口 
        TransactionDefinition -> 
        PlatformTransactionManager -> 
        TransactionStatus
    AOP增强
    事务传播级别 依赖spring容器
    JDBC编程式事务
    spring声明式事务
        配置 
            事务传播性
            事务的隔离级别
            只读事务
                减小事务粒度
                Service层不要嵌套
                    只调用DAO
                    新加Biz层或者Controller处理
事务怎么理解？

Nicefish项目Demo

    运行方式 main、maven、jar    
    swagger
    mybatis-generator
    shiro
    
shardingsphare-example

    git clone ... -depth=1
    maven clean install
    
ORM使用经验

    事务
    多数据源
    连接池
        大小
            误区：连接数不要太多，几十个就OK        
        重连 
            心跳机制，网络异常恢复后，自动重连
        超时
    避免复杂SQL
    ORM辅助工具和插件
        MyBatis 分页插件 
            额，select count(*) from (select * from ...)的坑
