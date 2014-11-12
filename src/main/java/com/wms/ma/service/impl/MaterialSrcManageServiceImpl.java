/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service.impl;

import com.wms.core.mapper.MaterialMapper;
import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author cgx1844568
 * @date 2014-10-25
 * @time 11:35:46
 *
 */
@Service
public class MaterialSrcManageServiceImpl implements MaterialSrcManageService{

    @Autowired
    private MaterialMapper materialMapper;
    
    @Resource 
    PlatformTransactionManager platformTransactionManager;
    
    @Override
    public MaterialSrcBean querySingleMaterial(String materialCode) {
        MaterialSrcBean msb = new MaterialSrcBean();
        msb.setMaterialCode("123444-00");
        
        List<MaterialSrcBean> list = materialMapper.selectAll();
        msb.setMaterialDesc(list.get(0).getMaterialDesc());
        System.out.println("-----------------------list " + list.size());
        return msb;
    }

    @Transactional
    @Override
    public void addMaterial(List<MaterialSrcBean> list) {
//        this.addMaterialList(list);
        for(MaterialSrcBean msb:list){
            materialMapper.insetOne(msb);
        }
    }

    @Override
    public void addMaterialList(List<MaterialSrcBean> list) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = platformTransactionManager.getTransaction(def);
        /**
         * 编程式事务嵌套声明式事务时,事务不会提交
         * 声明式事务嵌套编程式事务时,事务也不会提交
         */
//        this.addMaterial(list);
        for(MaterialSrcBean msb:list){
            materialMapper.insetOne(msb);
        }
        
        platformTransactionManager.rollback(status);
    }

    @Override
    public MaterialSrcBean getMaterial(String materialCode) {
        return materialMapper.selectOne(materialCode);
    }
}
