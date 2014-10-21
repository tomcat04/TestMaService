/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.aop.advice;

import com.wms.ma.bean.MaterialSrcBean;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author cgx1844568
 * @date 2014-10-21
 * @time 10:17:13
 * schema配置型aop,配合applicationContext-service-schema-aop使用
 */
public class AspectSchemaAdvice {

    public void doBefore(JoinPoint jp){
        System.out.println("before");
    }
    
    public void doAfter(JoinPoint jp, MaterialSrcBean bean){
        System.out.println("after");
    }
}
