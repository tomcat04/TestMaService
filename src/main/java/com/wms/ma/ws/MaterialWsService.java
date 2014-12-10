/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.ws;

import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import com.wms.util.exception.CustomException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author cgx1844568
 * @date 2014-11-19
 * @time 14:41:54
 *
 */
@WebService
public class MaterialWsService {

    @Resource
    private MaterialSrcManageService materialSrcManageService;
    
    @WebMethod
    public MaterialSrcBean getMaterial(String materialCode) throws CustomException{
        return materialSrcManageService.getMaterial(materialCode);
    }
}
