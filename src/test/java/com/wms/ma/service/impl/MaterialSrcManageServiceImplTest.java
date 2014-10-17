/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service.impl;

import com.wms.ma.bean.MaterialSrcBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cgx1844568
 */
public class MaterialSrcManageServiceImplTest {
    
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
    @org.junit.Test
    public void testQuerySingleMaterial() {
        System.out.println("querySingleMaterial");
        String materialCode = "";
        MaterialSrcManageServiceImpl instance = new MaterialSrcManageServiceImpl();
        MaterialSrcBean expResult = null;
        MaterialSrcBean result = instance.querySingleMaterial(materialCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
