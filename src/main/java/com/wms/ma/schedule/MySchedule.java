/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.schedule;

import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author cgx1844568
 * @date 2014-11-14
 * @time 17:07:51
 *
 */
public class MySchedule {

    @Scheduled(fixedDelay = 5000)  
    void doSomethingWithDelay(){  
        System.out.println("I'm doing with delay now!");  
    }  
      
    @Scheduled(fixedRate = 5000)  
    void doSomethingWithRate(){  
        System.out.println("I'm doing with rate now!");  
    }  
      
    @Scheduled(cron = "0/5 * * * * *")  
    void doSomethingWith(){  
        System.out.println("I'm doing with cron now!");  
    }  
}
