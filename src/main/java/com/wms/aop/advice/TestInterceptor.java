/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.aop.advice;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author cgx1844568
 * @date 2014-10-20
 * @time 9:17:34
 * 环绕通知(around advice)：包围切入点，调用方法前后完成自定义行为。
 * 基本的aop配置,配合applicationContext-service-aop使用
 */
@Component
public class TestInterceptor implements MethodInterceptor{

    private static final Logger logger = Logger.getLogger(TestInterceptor.class);
    
    private static final Logger traceLogger = Logger.getLogger("traceLogger");
    
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        traceLogger.info("traceLogger日志记录");
        logger.debug("logger debug");
        logger.error("logger error");
        logger.fatal("logger fatal");
        logger.info("logger info");
        logger.trace("logger trace");
        logger.warn("logger warn");
        System.out.println("enter around advice method...");
        Object[] args = mi.getArguments();
        Method method = mi.getMethod();
        Object target = mi.getThis();
        
        StopWatch sw = new StopWatch();
        sw.start();
        Object returnValue = mi.proceed();//执行被切入点的方法
        sw.stop();
        System.out.println("exit around advice method...");
        System.out.println("输出:[" + sw.getTime() + "ms]" + args[0] + ";" + method + ";" + target + ";" + returnValue + "\n");
        return returnValue;
    }

}
