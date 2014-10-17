/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service.impl;

import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import com.wms.util.test.WmsSpringJUnit4ClassRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author cgx1844568
 */
@RunWith(WmsSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
@TransactionConfiguration(defaultRollback = false)
public class NewMainTest {
    
    @Autowired
    private MaterialSrcManageService materialSrcManageService;
    
    public NewMainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class NewMain.
     */
    @org.junit.Test
    public void testQuerySingleMaterial() {
        MaterialSrcBean list = materialSrcManageService.querySingleMaterial("");
        System.out.println("*** " + list.getMaterialDesc());
    }
    
}
