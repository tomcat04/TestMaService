/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.schedule;

import com.wms.util.DateUtil;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author cgx1844568
 * @date 2014-11-14
 * @time 17:07:51
 *
 */
//@Configuration
//@EnableAsync
//@EnableScheduling
@Component
public class MySchedule {
    /**
     * fixedDelay上一任务完成到下一任务开始
     * fixedRate上一任务开始到下一任务开始
     * cron具体任务周期执行时间点
     */
    @Scheduled(fixedDelay = 5000)  
    void doSomethingWithDelay(){  
        
        System.out.println("I'm doing with delay now!" + DateUtil.format(new Date(), "yyyy-MM-dd hh:mm:ss"));  
    }  
      
    @Scheduled(fixedRate = 5000)  
    void doSomethingWithRate(){  
        System.out.println("I'm doing with rate now!");  
    }  
      
    @Scheduled(cron = "0/5 * * * * *")  
    void doSomethingWith(){  
        System.out.println("I'm doing with cron now!" + new Date().getTime());  
    }  
}
