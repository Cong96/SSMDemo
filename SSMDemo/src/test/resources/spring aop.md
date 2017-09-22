http://www.cnblogs.com/jianjianyang/p/4910851.html
http://www.cnblogs.com/hongwz/p/5764917.html


- Maven 依赖
``` 
         <aspectj.version>1.6.11</aspectj.version>  

<!--使用AspectJ方式注解需要相应的包-->  
      <dependency>  
            <groupId>org.aspectj</groupId>  
            <artifactId>aspectjrt</artifactId>  
            <version>${aspectj.version}</version>  
        </dependency>  
         <!--使用AspectJ方式注解需要相应的包-->  
        <dependency>  
            <groupId>org.aspectj</groupId>  
            <artifactId>aspectjweaver</artifactId>  
            <version>${aspectj.version}</version>  
        </dependency> ```
     
     
 ####Q1:
 为什么经过AOP得到的result之后，JSON.toJSONString()失效 ，返回的会是null
 如果是动态代理的话，那么Mybatis也用了动态代理呀   
     
 