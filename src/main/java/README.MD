服务类

添加spring Ansy异步执行,该异步与Controller异步差异

添加AOP拦截业务规定,AOP的异常抛出处理(doThrow会抛出方法和AOP的异常)

Schedule详情http://docs.spring.io/spring/docs/4.0.4.RELEASE/spring-framework-reference/html/scheduling.html 27.4节
1.@Configuration与配置文件存一即可
2.使用@Scheduled则不需要配置文件
注:tx:annotation-driven与task:annotation-driven存在冲突

使用AOP拦截操作的异常捕获,在service抛出对应异常即可
