/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.aop.service;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author cgx1844568
 * @date 2014-10-20
 * @time 9:17:34
 * 环绕通知(around advice)：包围切入点，调用方法前后完成自定义行为。
 */
public class TestInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("enter around advice method...");
        Object[] args = mi.getArguments();
        Method method = mi.getMethod();
        Object target = mi.getThis();
        Object returnValue = mi.proceed();//执行被切入点的方法
        System.out.println("exit around advice method...");
        System.out.println("输出:" + args[0] + ";" + method + ";" + target + ";" + returnValue + "\n");
        return returnValue;
    }

}
