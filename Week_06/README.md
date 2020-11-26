## 第6周


### 第6周作业
2.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。

DDL: <https://github.com/duhaiying2504/java-training/blob/master/user-goods-order-ddl.sql>


### 作业内容

> Week06 作业题目（周四）：

1.（选做）尝试使用 Lambda/Stream/Guava 优化之前作业的代码。

2.（选做）尝试使用 Lambda/Stream/Guava 优化工作中编码的代码。

3.（选做）根据课上提供的材料，系统性学习一遍设计模式，并在工作学习中思考如何用设计模式解决问题。

4.（选做）根据课上提供的材料，深入了解 Google 和 Alibaba 编码规范，并根据这些规范，检查自己写代码是否符合规范，有什么可以改进的。

> Week06 作业题目（周六）：

1.（选做）基于课程中的设计原则和最佳实践，分析是否可以将自己负责的业务系统进行数据库设计或是数据库服务器方面的优化

2.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。

3.（选做）尽可能多的从“常见关系数据库”中列的清单，安装运行，并使用上一题的 SQL 测试简单的增删改查。

4.（选做）基于上一题，尝试对各个数据库测试 100 万订单数据的增删改查性能。

5.（选做）尝试对 MySQL 不同引擎下测试 100 万订单数据的增删改查性能。

6.（选做）模拟 1000 万订单数据，测试不同方式下导入导出（数据备份还原）MySQL 的速度，包括 jdbc 程序处理和命令行处理。思考和实践，如何提升处理效率。

7.（选做）对 MySQL 配置不同的数据库连接池（DBCP、C3P0、Druid、Hikari），测试增删改查 100 万次，对比性能，生成报告。

###笔记-周四
Lambda表达式   [Demo]
    
    简化匿名类的定义方式
    从动态引用到动态定义，简化写法    
    函数签名：返回类型\函数名\参数类型列表
    单抽象方法接口 
    面向对象与面向函数
    面向接口 --> 内部匿名类
    作为参数
    类型推断
    
函数式编程

    @FunctionalInterface
    Predicate   断言  boolean表达式
    Function    有参数 有返回值
    Consumer    有参数 无返回值
    Supplier    无参数 有返回值    
    BiFunction  两个参数
    BiConsumer  两个参数

方法引用

    静态方法  ::
    构造方法  ::new 
    实例方法  this:: 
    
lambda表达式里外部参数final，否则破坏闭包   

git命令

    git提交 回退版本    
        git reset --hard head~2
        git reset--soft head~2
        
    查看最近commit信息    
        git log -10 --oneline
        git log -n20 --graph --all --decorate --oneline
    发生了什么    
        git filter -branch xxxx
    学习网站    
        https://learngitbranching.js.org/
        
java集合和泛型
    
    简化编程、约束类型
    什么是泛型？
        伪泛型，擦除法        
    运行期怎么拿到泛型
        反射
    多泛型继承 -- 黑魔法
        <T extends Serializable&Comparable>
    Type类型，区别Class
        
Stream
    
    什么是流？
        流是来自数据源的元素队列并支持聚合操作
        管道+操作
    元素
    数据源
    聚合操作
        filter
        map
        reduce
        find
        match
        sorted 
    pipelining
    内部迭代
        相较于iterator or foreach的方式
        通过访问者模式Visitor实现
    创建Stream的方式
        collection.stream
        Stream.of
        
闭包的特性，不能影响外部变量    
        
Stream操作
    
    简化了集合操作
    中间操作
        选择和过滤
            filter 
            distinct
            limit
            skip
        映射（变形转化）            
            map
        排序
            sorted
    终止操作 (终止返回值，闭包的特性)
        查找匹配
            allMatch
            anyMatch
            noneMatch
            findFirst
            findAny
            count
            max
            min
        归约
            reduce
                需要初始值（类比Map-Reduce）
                所有元素参与方法执行
        收集(转化)
            collect
                toList
                toSet
                toCollection
                count
                summaryStatistics
        迭代
            foreach 
        
    Optional
        元素类型允许null，避免所谓的null，pipelining的中断  
        orElse
    Collectors.toMap 四个参数的含义
    parallerStream 并行流
        在什么地方并行？
        
Lombok

    基于jsr269的类库
    简化编程，
    字节码增强，编译期处理
    @Data
    @Setter @Getter
    @ToString
    @XXXConstructor
    @Builder
    @Slf4j
    
    debug怎么办？
        不需要调试    
    编译期增强跟前面讲的字节码工具异同点？
    
Guava
    
    开源java库，简化编码
    
    集合
        不可变集合
        新集合类型
            多值map
            双向map
            tables
        强大的工具类
        扩展工具类
        
    缓存
        本地缓存实现，支持多种缓存过期策略
        未变更前，本地读取，减轻分布式缓存的压力
        
    并发Concurrency
        ListenableFuture，完成后出发回调Futrue
        
    字符串处理Strings
        增强的分割、拼接..
        
    事件总线EventBus
        发布订阅模式的组件通信，进程内模块间解耦
        
        spi service loader [demo ServiceLoader]            
        callback / listener
        EventBus
            
面向对象设计原则SOLID

    代码给人看的，机器只看机器码，便于维护 
    有层次，不相互影响

    单一职责 SRP
    开闭原则 OCP
    里氏替换 LSP
    接口分离 ISP
    依赖倒置 DIP
    最小知识原则  
        对象之间是线性依赖，避免互相依赖
        增加一层，提升抽象新概念
    KISS   
    继承封装多态 
    高内聚低耦合
    
编码

    避免沟通协调成本，避免常见错误    
    Google
    阿里
    VIP    
    checkstyle
    
    设计规范、调研规范、数据库规范
    
设计模式
    
    特定场景的通用解决方案

    创建型   
    
    结构型
        Adapter
        Bridge
        Composite
        Decorator
        Facade
        Flyweight
        Proxy
        
        代理和装饰有什么不同？
    
    行为型
    
设计模式与反模式
    
    解决方案层面 --> 架构模式
        
    组件层面    --> 框架模式
    
    代码层面
        GoF设计模式
        
    集成模式
    事务模式
    IO模式
    Context模式
    状态机FSM
    规则引擎RE
    workflow
    
    模式都是经验
    反模式，死用模式，都是反模式
    1、会用模式
    2、使用模式，改进优化    
    3、忘掉模式，怎么面向对象怎么来，无招胜有招
    
单元测试
    
    发现缺陷越提前，修复成本越小
    大幅降低上线紧张指数
    代码重构、功能拓展，代码质量的有力保证
    自动化测试
    
    如何做单元测试？
        JUnit ->  TestCase, TestSuite, Runner
        SpringTest
        Mock技术
            单元测试完成的有力保证，模拟各种不同场景
            Mockito
            easyMock
        
        应该是每一个方法是一个case，不同条件，断言充分，提示明确
        要覆盖所有的corner case
        充分使用mock(一切皆可mock)
        不好测试，说明业务代码设计存在问题，反向优化代码
        批量测试用例--参数化单元测试
        单元测试是单线程执行
        [回看]        
        合理使用before、after、setup准备环境
        合理使用通用测试基类
        配合checkstyle，coverage等工具
        制定单元测试覆盖率基线
            pom中指定
            核心模块、非核心区别对待
    
    单元测试常见陷阱和经验
        1. 尽量不要访问外部数据库等外部资源
        2. 如果必须用数据库考虑用嵌入式DB+事务自动回滚
        3. 防止静态变量污染导致测试无效
        4. 小心测试方法的顺序导致的不同环境测试失败
            不同操作系统环境的问题
        5. 单元测试总时间特别长的问题
            不是问题
        
    阅读fastjson的单元测试

        
    emma 
    coberuta
    sonar
    checkstyle 
    findbugs
    jacoco 
       
    单元测试覆盖率
    mvn emma:emma
    mvn coberuta:coberuta
    
    github
        travis
        coveralls
        codecov
        
####课参考材料

FunctionInterface的用法

https://www.cnblogs.com/bigbaby/p/12116886.html

Lambda 表达式如何演化，简化代码用法

https://www.zhihu.com/question/20125256/answer/324121308
https://www.cnblogs.com/bigbaby/p/12113741.html

Steam操作

https://www.jianshu.com/p/932ef18941fb
https://www.jianshu.com/p/633f691f9afb
https://developer.ibm.com/zh/articles/j-lo-java8streamapi/

Guava中文教程

http://ifeve.com/google-guava/

编码规范

https://www.sohu.com/a/215755759_820120
https://zhuanlan.zhihu.com/p/87352004

设计模式

https://github.com/me115/design_patterns
https://github.com/quanke/design-pattern-java

单元测试

https://www.zhihu.com/question/27313846/answer/36132954


###笔记-周六

什么是性能？

    吞吐量和延迟
       延迟大就一定吞吐量低吗？ 密云水库引流的例子
        
    没有量化就没有改进
        监控和度量指标
        业务性的指标，比技术的越来越重要
        类似B超、化验..手段，否则就是感性，老中医望闻心切
        
    80/20原则
        先优化性能瓶颈问题
          一般情况下 --> 数据库sql、缓存
          
    过早优化是万恶之源
        优化时机
        没有直接受益
        
    性能是一个综合性问题
    
    脱离场景谈性能都是耍流氓
    
    高吞吐、高并发
        
    高可用
        容错、恢复
    稳定性
        不轻易宕机
    可维护性
  
DB/SQL优化是业务系统性能优化的核心

    业务系统分类：计算密集型、数据密集型    
    业务处理本身无状态，数据状态最终要保存到数据库中  
    一般来说，DB/SQL操作的消耗在一次处理中占比最大
        
    例子：传统CS软件改成SaaS软件 
        单机环境、数据量小、sql和表设计随意，数据量一天100
        SaaS环境，数据量一天1000 * 1000
        这是一个认识问题，说服决策层 --> 20人半年、小半年试用推广改进调整

SaaS  功能软件从单机版变成web多租户
Paas GAE  SAE，基础设施都是共享的，自己去部署应用
IaaS openstack，看起来你拿到的就是机器，自己按任何东西
FaaS Serverless，函数即服务 ===》》 headless===！！！！ 趋势
DaaS Data  数据即服务

什么是关系数据库           
    
    以关系代数理论为数学基础
    tuple 元组
    
    现实世界的映射
    E-R图 
        实体、属性、实体间关系
  
 数据库设计范式
    
    1NF 原子项
        每一列都是不可再分的基本数据项
    2NF 
        每一行都有主键、唯一标识，消除部分依赖
    3NF            
        没有列是与主键不相关的，消除传递性依赖
        每列都和主键相关
    BCNF
        拆分、消除重复
    4NF
    5NF
    https://www.zhihu.com/question/24696366
    
    设计表不完全依赖范式，实际都需要冗余设计
    
 常见数据库
 
    开源：mysql、PostgreSQL
    商业：Oracle、DB2,SQLServer
    
    内存：Redis(缓存)、VoltDB（一枝独秀、一致性、数据可靠）
    图：Neo4j、Nebul  --> 图论
    嵌入：Sqlite、H2(java,基于内存的)、Derby(java)
    时序：InfluxDB、openTSDB  打点    -->  离散 按时间打点、取一个时间窗口
    NoSQL: MongoDB、Hbase、Cassandra、CouchDB  （不严格的事务一致性保证）
    NewSQL/分布式数据库：TiDB
    
 SQL语言
    
    DQL    DML    TCL    DCL    DDL    CCL
    SQL语言解析器
        手写 druid, mycat
        antlr4，sharingsphere
        javacc
        
 MySQL数据库
 
    Apacha  对商业友好，可以随意改，带协议声明
    GPL 对商业不友好
    
    MariaDB 社区版本
    
    95年成立，4.0版本InnoDB,事务；2003， 5.0。
    5.6 使用最多；5.7 近期使用最多；8.0 最新和功能完善的版本。
    
    选择学习哪个版本？   5.7

    5.6/5.7的差异
        多主
        MGR高可用
        分区表
        json
        性能提升
        修复XA等
    5.7/8.0的差异
        通用表达式 CTE
        窗口函数
        持久化参数
        自增列持久化
        默认编码utf8mb4
        DDL原子性
        JSON增强
        不再对group by进行隐式排序？
 
 MySQL架构图
 
 MySQL存储
 
    logfile
    bin
    ibdata1   
    information_schema
        整个数据库的元数据  
    database dir
        table dir 
        .frm    表结构
        .idb    数据
MySQL命令 
   
    show database;
    show tables;
    show colums from test;
    show create table test;

MySQL简化执行流程

    SQL
        查询缓存
            查询执行引擎
                执行结果
        解析器
            预处理器
                查询优化器
                    执行计划
                        查询执行引擎
                            执行结果

MySQL执行引擎和状态

    
MySQL对sql执行顺序

    from
        on
            join
                where
                    group by
                        having + 聚合函数
                            select
                                order by 
                                    limit    
    表 --> 条件 --> 列 --> 数据
    
MySQL索引原理
    
    数据是按页来分块的(相邻的数据)
    
    默认使用B+树实现聚集索引
        B树（B-tree）的改良版
        按照主键关系直接存储到文件里的
        https://www.cs.usfca.edu/~galles/visualization/BPlusTree.html
        https://www.kancloud.cn/kancloud/theory-of-mysql-index/41850
    索引设计原则
        
    单表数据不超2000万
        B+树不超过3层 （多一层多一次IO？？）
        
        一个页是 16K，根节点 只能放 16个 key（一个 BigInt 占 一个字节）
        指针+bigint = 6+8=14
        16k/14=1170
        1170 * 1170 * 16 = 2190
        
        主键越复杂（长度越大），峰值越小（单位内存储数据越小）
        
mysql 命令

    非windows环境，不指定-h参数会有问题(连接问题...？)    
    -h localhost
    -P 3306
    -u root
    -p root
    mysql -h -P -u -e "select * from test.test"
    
MySQL配置优化

    my.cnf
        mysqld
            server
        mysql
            client
    连接请求
        max_connections
            几千
        back_log
        wait_timeout  
             
    缓冲区变量   
        query_cache_size 查询缓存QC
        thread_cache_size
    Innodb
        innodb_buffer_pool_size
        innodb
        
    CPU越多、内存越大 --> 性能越好    
    MySQL刚启动后 和 经过充分运行一段时间后，性能完全是两回事  
    
    《MySQL技术内幕》《数据库全书》《数据密集型应用设计》
    中文版：https://vonng.gitbooks.io/ddia-cn/content/
    
数据库设计优化
  
    如何恰当选择引擎？
        事务和行锁    
    库表如何命名？
    如何合理拆分宽表？
    如何选择恰当数据类型？
        明确、尽量小
        text\blob\clob 文件图片 存储到分布式文件系统里
        时间日期的存储问题
            int long 时间戳
        数值精度问题
            字符串 bigdecimal 
    是否使用外键、触发器？
    
    唯一约束和索引的关系？
        唯一约束 --- 索引
    是否可以冗余字段？
        为业务服务    
    自增主键问题？
        分布式环境有问题
    在线修改表结构 DDL？
        锁表，低峰期
    逻辑删除还是物理删除？
        建议逻辑
    要不要加createtime updatetime？
        建议    
    如何快速导入导出、备份数据？
        要备份数据
   
   
   
#### 参考资料

如何理解关系型数据库的常见设计范式？ - 刘慰的回答 - 知乎 
https://www.zhihu.com/question/24696366/answer/29189700

SQL92与SQL99 
https://zhuanlan.zhihu.com/p/295071589

精通SQL的30张简图 - 侠者的文章 - 知乎 https://zhuanlan.zhihu.com/p/94190004


事务中的redolog和undolog 

https://www.jianshu.com/p/20e10ed721d0

https://mp.weixin.qq.com/s/MDb0IVBUThM7XYpownclQw

http://mysql.taobao.org/monthly/2015/05/01/


MySQL执行过程

https://www.cnblogs.com/wyq178/p/11576065.html


深入理解 Mysql 索引底层原理 - 腾讯技术工程的文章 - 知乎 https://zhuanlan.zhihu.com/p/113917726

MySQL索引实现原理 

https://cloud.tencent.com/developer/article/1125452

https://www.jianshu.com/p/d90f6b028d0e


参数配置详解：

https://www.jb51.net/article/144039.htm

https://www.cnblogs.com/angryprogrammer/p/6667741.html


数据库设计和优化

https://blog.csdn.net/glycsdn/article/details/102563444
         