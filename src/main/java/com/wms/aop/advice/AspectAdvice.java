/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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

    @Before("execution(* com.wms.ma.service.*.*(..))")
    public void doBefore(){
        System.out.println("before");
    }
}
