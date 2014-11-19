/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.aop.advice;

import com.wms.util.exception.CustomException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 *
 * @author cgx1844568
 * @date 2014-10-21
 * @time 9:04:53
 * 定义一个切面
 */
@Aspect//aop注解模式的切面
@Component//配合xml包扫描配置
public class AspectAdvice {
    
    private static final Logger logger = Logger.getLogger(AspectAdvice.class);
    /**
     * 指定切入点匹配表达式，注意它是以方法的形式进行声明的。
     */
//    @Pointcut("execution(* com.wms.ma.service.*.*(..))")
//    public void anyMethod() {
//    }

    /**
     * 前置通知
     * 
     * @param jp
     * @throws java.lang.Exception
     */
//    @Before(value = "execution(* com.wms.ma.service.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        System.out.println("===========进入before advice============ \n");

        System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");
        System.out.print(jp.getSignature().getName() + "方法进行对 '");
        System.out.print(jp.getArgs()[0] + "'进行删除！\n\n");

        System.out.println("要进入切入点方法了 \n");
    }

    /**
     * 后置通知
     * 
     * @param jp
     *            连接点
     * @param result
     *            返回值
     */
//    @AfterReturning(value = "anyMethod()", returning = "result")
    public void doAfter(JoinPoint jp, String result) {
        System.out.println("==========进入after advice=========== \n");
        System.out.println("切入点方法执行完了 \n");

        System.out.print(jp.getArgs()[0] + "在");
        System.out.print(jp.getTarget().getClass() + "对象上被");
        System.out.print(jp.getSignature().getName() + "方法删除了");
        System.out.print("只留下：" + result + "\n\n");
    }

    /**
     * 环绕通知
     * 
     * @param pjp
     *            连接点
     * @return 
     * @throws java.lang.Throwable
     */
    @Around(value = "execution(* com.wms.ma.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========进入around环绕方法！=========== \n");

        logger.info("llll");
        // 调用目标方法之前执行的动作
        System.out.println("调用方法之前: 执行！\n");

        // 调用方法的参数
        Object[] args = pjp.getArgs();
        String param;
//        this.xxx(args[0]);
        // 调用的方法名
        String method = pjp.getSignature().getName();
        // 获取目标对象
        Object target = pjp.getTarget();
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        StopWatch ws = new StopWatch();
        ws.start();
        Object result = pjp.proceed();
        ws.stop();
        System.out.println("方法执行时间:" + ws.getTotalTimeMillis());

        System.out.println("输出：" + args[0] + ";" + method + ";" + target + ";" + result + "\n");
        System.out.println("调用方法结束：之后执行！\n");
//        this.xxx(result);
        return result;
    }

    /**
     * 异常通知
     * 
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "execution(* com.wms.ma.service.*.*(..))", throwing = "e")
    public void doThrow(JoinPoint jp, Throwable e) {
        System.out.println("删除出错啦");
        logger.error(e.getMessage(), e);
    }
    
    
    /**
     * logger记录切入点方法的参数和返回值
     * @param obj 
     */
    public void xxx(Object obj){
        
        Object param = obj;
        //判断是否是基础数据类型
        if (param instanceof Integer || param instanceof String || param instanceof Double
                || param instanceof Float || param instanceof Long || param instanceof Boolean || param instanceof Date) {
            System.out.println("::::::::" + param);
            return;
        }
        
        Class obj1 = obj.getClass();
        Method[] methods = obj1.getMethods();

        //将以get开头的方法得到的参数进行记录
        for (Method method : methods) {
            String methodName = ((Member) method).getName();
            //过滤掉不以get开头的方法，并且过滤掉以get开头的getClass方法。
            if (methodName.indexOf("get", 0) < 0 || methodName.indexOf("getCla", 0) >= 0) {
                continue;
            }
            Method getMethod;
            try {
                getMethod = obj1.getMethod(methodName);
                System.out.println("::::::::::" + methodName + "=" + getMethod.invoke(obj) + "::::::::::");
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                java.util.logging.Logger.getLogger(AspectAdvice.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
