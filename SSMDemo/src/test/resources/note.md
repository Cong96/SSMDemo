####ERROR
- org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class com.wangcc.ssm.entity.Team with invalid types () or values (). Cause: java.lang.NoSuchMethodException: com.wangcc.ssm.entity.Team.<init>()

这个错误是由于JavaBean中没有无参数的构造方法引起的，原因个人猜想是因为如果没有无参构造方法，无法通过反射来得到对象，class.newInstance();报错，因为没有无参构造方法，
我们能够通过loadClass得到Class<?>对象，而得到对象实例的时候，我们是通过newInstance();得到的，MyBatis中肯定是直接调用了newInstance()方法，因为框架无法事先知道我们到底用了什么参数来构造构造方法，所以需要有一个默认的无参构造方法。
- Result Maps collection already contains value for 
很有可能是因为你有两个相同的Mapper配置文件
我是怎么出现两个相同的Mapper配置文件的呢
是因为

 <!-- spring和MyBatis完美整合，不需要mybatis的配置映射文件
        在定义SqlSessionFactoryBean的时候，dataSource属性是必须指定的，它表示用于连接数据库的数据源。当然，我们也可以指定一些其他的属性，下面简单列举几个：

 mapperLocations：它表示我们的Mapper文件存放的位置，当我们的Mapper文件跟对应的Mapper接口处于同一位置的时候可以不用指定该属性的值。
configLocation：用于指定Mybatis的配置文件位置。如果指定了该属性，那么会以该配置文件的内容作为配置信息构建对应的SqlSessionFactoryBuilder，但是后续属性指定的内容会覆盖该配置文件里面指定的对应内容。
 typeAliasesPackage：它一般对应我们的实体类所在的包，这个时候会自动取对应包中不包括包名的简单类名作为包括包名的别名。多个package之间可以用逗号或者分号等来进行分隔。
 typeAliases：数组类型，用来指定别名的。指定了这个属性后，Mybatis会把这个类型的短名称作为这个类型的别名，前提是该类上没有标注@Alias注解，否则将使用该注解对应的值作为此种类型的别名。
     -->  
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">  
        <property name="dataSource" ref="dataSource" />  
        <!-- 自动扫描mapping.xml文件 -->  
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="mapperLocations" value="classpath:mapper/*.xml"></property>  
    	<property name="typeAliasesPackage" value="com.wangcc.ssm.entity"></property>
    </bean>

它表示我们的Mapper文件存放的位置，当我们的Mapper文件跟对应的Mapper接口处于同一位置的时候可以不用指定该属性的值。
这句话到底是什么意思呢。
我们知道配置文件我们一般都放在Resources下面,如果Resoures下面的路径与Java代码中Mapper接口的路径是一致的，那么就不用显式指定。（虽然很早就知道这个，但是以前居然会认为是要把Mapper文件放在Java代码的同一路径下，真的太二笔了）
不过由于Java中Mapper接口路径一般会比较长，所以没必要去新建那么多文件目录
今天就是在测试这个之后，忘记把这个路径下的文件删了，再重新再配置文件里面配置mapperLocations属性时，再运行程序，直接打出GG，报错，因为检测到了两份一样的Mapper文件。
-org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
1：检查xml文件所在的package名称是否和interface对应的package名称一一对应

2：检查xml文件的namespace是否和xml文件的package名称一一对应

3：检查函数名称能否对应上

4：去掉xml文件中的中文注释

5：随意在xml文件中加一个空格或者空行然后保存

- Mapped Statements collection does not contain value for
与上面相反，是找不到Mapper文件



####classpath*: classpath:
区别
这里也是个坑
今天配置  mapperLocations，使用通配符来配置mapper文件下所有的xml文件用做和Java接口一一对应的Mapper文件。      <property name="mapperLocations" value="classpath:mapper/*.xml"></property>  
我以为这样是very ok的，但是很遗憾，报错，Invalid bound statement (not found),一脸蒙蔽。
查资料，说的基本是上述的问题造成的。
然后我也就以为是我写Mapper文件的时候出错了，之前也没有单独一个一个Mapper文件来调试。
我先把最复杂的Mapper给注释了，重新试了一次，然并软，还是报错，好吧，放弃这种差错方法。
然后我就开始用单个Mapper文件来代替统配符，反正也是没有对单个Mapper接口进行单元 测试的，
好，开始对单个Mapper进行测试，反正还是得对每个Mapper接口进行单元测试，测试了5,6个，全都没有问题。
这个时候我开始想着把其他没测的Mapper文件先注释掉，再开始使用统配符配置mapperLocations。
继续试，发现依然GG,这时候就证明了，不是Mapper文件有问题（事实证明，除了最复杂的那个Mapper文件有一处问题之外，其他的都没有问题）。这个时候很明显，其他的都试过了，那只能是通配符的问题了，ok，这个时候开始百度，直到看到classpath*:和classpath:的区别，才知道问题所在。
哎，这连个的区别我以前看过的呀，看过？呵呵，看过有毛用呀，放在书签里有毛用，除了当时看了一下之外，你再也不会去看了，所以呀，
少年郎，以后要把所有的开发中的错误，所有不知道的东西都写在博客里，加深映像，也方便以后查找资料，至少不会再出现这个问题其实已经躺在你的书签里很久了这种尴尬的事情出现了把，少年郎，说的直接点，你还是太懒了，所以呀，多写博客，多总结，别犯懒，虽然咱刚失恋，但是呀，还是要积极向上，好好学习，好好工作。加油！
好了，说了一堆废话:
开始进入正题：
classpath:和classpath*:在spring加载资源的时候是不同的
classpath:只能加载找到的第一个资源文件
classpath*:能加载多个路径下的资源文件
http://blog.csdn.net/kkdelta/article/details/5507799

