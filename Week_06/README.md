##笔记
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
        
##课参考材料

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


源码阅读

    dubbo 
    shardingsphere
        