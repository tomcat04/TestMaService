/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service.impl;

import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import com.wms.util.test.WmsSpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author cgx1844568
 */
@RunWith(WmsSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"})
//@ContextConfiguration(locations={"file:src/main/java/applicationContext-core.xml"})
@TransactionConfiguration(defaultRollback = false)
public class MaterialSrcManageServiceImplTest {
    
    @Resource
    private MaterialSrcManageService materialSrcManageService;
    
    public MaterialSrcManageServiceImplTest() {
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
     * Test of querySingleMaterial method, of class MaterialSrcManageServiceImpl.
     */
    @Test
    public void testQuerySingleMaterial() {
        System.out.println("querySingleMaterial");
        MaterialSrcBean result = materialSrcManageService.querySingleMaterial("");
//        fail("The test case is a prototype.");
        System.out.println(" test over ");
    }
    
}
