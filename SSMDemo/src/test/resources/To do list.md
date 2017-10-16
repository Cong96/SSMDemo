- Junit测试Controller

- 异常处理机制：继承RuntimeExcetpion

  尽早的抛出异常，把CheckedException传化为UncheckedException ，然后放到Controller中统一处理异常

  千万不要ctach异常（IO等资源操作除外）

  - 那么怎么分层次的包装这些异常呢

    1.按照MVC架构来分：DaoException ServiceException

    2.按照业务类型来区分，同样一种类型的操作或业务逻辑，公用一个包装异常


- 配置文件统一处理

  1.配置文件的定制

- 日志处理

- Learn From Work 

  1.关于在spring 容器初始化 bean 和销毁前所做的操作定义方式有三种： 第一种：通过@PostConstruct 和 @PreDestroy 方法

  实现初始化和销毁bean之前进行的操作 第二种是：通过 在xml中定义init-method 和 destory-method方法 第三种是：
    通过bean实现InitializingBean和 DisposableBean接口

  ​

  2. @Controller和@RestController的区别？
     官方文档：
     @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
     意思是：
     @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。

     1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。

     例如：本来应该到success.jsp页面的，则其显示success.

     2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
     3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

  3. 默认情况下Spring MVC将模型中的数据存储到request域中。当一个请求结束后，数据就失效了。如果要跨页面使用。那么需要使用到session。而@SessionAttributes注解就可以使得模型中的数据存储一份到session域中。

     @SessionAttributes参数

     　1、names：这是一个字符串数组。里面应写需要存储到session中数据的名称。

     　　2、types：根据指定参数的类型，将模型中对应类型的参数存储到session中

      　  3、value：其实和names是一样的。

     **@SessionAttributes注解只能在类上使用，不能在方法上使用**

  4.Spring 静态注入讲解（MethodInvokingFactoryBean）

  与其说是静态注入（[ IOC  ](http://www.sojson.com/tag_ioc.html)），不如讲是对`JavaBean` 的静态成员变量进行赋值。

  一般我们在使用依赖注入的时候，如果当前对象（`javaBean` ）创建（实例化）一次，那么非静态的成员变量也会实例化一次，用来支持当前对象的正常使用。而我们有的时候，一些对象是单例（`scope="singleton"` ）的，或者一些变量从项目启动从配置文件加载后不需要变化，那么这种情况下怎么处理呢？

  静态注入配置（[ XML  ](http://www.sojson.com/tag_xml.html)）：

  ```java

  <!-- 静态注入，相当于调用SecurityUtils.setSecurityManager(securityManager) -->
  <bean class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
      <property name="staticMethod" value="org.apache.shiro.SecurityUtils.setSecurityManager"/>
      <property name="arguments" ref="securityManager"/>
  </bean>
  ```

  相当于

  ```java
  SecurityUtils.setSecurityManager(securityManager)
  ```

  ​

  5.http://stamen.iteye.com/blog/1541732

  6 .lombokhttp://blog.csdn.net/arkblue/article/details/52608213

  http://blog.csdn.net/u011851478/article/details/52182694

  http://blog.csdn.net/ghsau/article/details/52334762

  7.Servlet不用手动关闭输出流http://bbs.csdn.net/topics/390801472