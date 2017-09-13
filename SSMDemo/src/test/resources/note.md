####ERROR
- org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class com.wangcc.ssm.entity.Team with invalid types () or values (). Cause: java.lang.NoSuchMethodException: com.wangcc.ssm.entity.Team.<init>()

这个错误是由于JavaBean中没有无参数的构造方法引起的，原因个人猜想是因为如果没有无参构造方法，无法通过反射来得到对象，class.newInstance();报错，因为没有无参构造方法，
我们能够通过loadClass得到Class<?>对象，而得到对象实例的时候，我们是通过newInstance();得到的，MyBatis中肯定是直接调用了newInstance()方法，因为框架无法事先知道我们到底用了什么参数来构造构造方法，所以需要有一个默认的无参构造方法。

