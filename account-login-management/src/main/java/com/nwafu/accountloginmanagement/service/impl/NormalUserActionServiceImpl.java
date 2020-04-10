package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.NormalUserDao;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import com.nwafu.accountloginmanagement.service.NormalUserActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 普通用户操作类
 * @author: liu qinchang
 * @create: 2019-12-17 15:48
 **/
@Service
@Slf4j
public class NormalUserActionServiceImpl implements NormalUserActionService {
    @Resource
    NormalUserDao normalUserDao;

    @Override
    public ResponseMessage<Integer> addSubAccount(String subUsername, String subPassword, String parentUser, String permissions, String employeeNo) {
        String newPermissions = permissions.substring(1, permissions.length() - 1);
        int flag = 0;
        try{
            flag = normalUserDao.addSubAccount(subUsername,subPassword,parentUser, newPermissions, employeeNo);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(flag == 0){
            throw new RuntimeException("分配子用户失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("添加子用户成功",1);
        return responseMessage;
    }

    /** 
    * @Description: 删除子用户 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @Override
    public ResponseMessage<Integer> deleteSubAccount(String subUsername, String parentUser){
        int flag = 0;
        try {
            flag = normalUserDao.deleteSubAccount(subUsername,parentUser);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(flag == 0){
            throw new RuntimeException("删除账号失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage("success",1);
        return responseMessage;
    }

    /** 
    * @Description: 修改子用户权限
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @Override
    public ResponseMessage<Integer> updateSubUserPermissions(String permissions, String subUsername){
        int flag = 0;
        flag = normalUserDao.updateSubUserPermissions(permissions,subUsername);
        if(flag == 0){
            throw new RuntimeException("修改权限失败");
        }
        ResponseMessage responseMessage = new ResponseMessage("success", 1);
        return responseMessage;
    }

    /** 
    * @Description:
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @Override
    public ResponseMessage<List<SubAccountInfoPO>> getAllSubUserInfo(String parentUsername) {
        List<SubAccountInfoPO> subUserInfoList = normalUserDao.getAllSubUserInfo(parentUsername);
        ResponseMessage<List<SubAccountInfoPO>> result = new ResponseMessage<>("seccess",subUserInfoList);
        return result;
    }

}
