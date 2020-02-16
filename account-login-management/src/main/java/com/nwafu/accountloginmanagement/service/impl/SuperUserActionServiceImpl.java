package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.SuperUserDao;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.NormalUserVO;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.SuperUserActionService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 超级用户操作实现类
 * @author: liu qinchang
 * @create: 2019-12-23 17:23
 **/

@Service
@Slf4j
public class SuperUserActionServiceImpl implements SuperUserActionService {

    @Resource
    SuperUserDao superUserDao;

    /** 
    * @Description: 超级用户修改普通用户信息 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/24 
    */
    @Override
    public ResponseMessage<Integer> updateNornalUserInfo(String oldUserName, String newUserName, String newPassword){
        if(oldUserName == null){
            throw new RuntimeException("updateNornalUserInfo  oldUserName不能为空");
        }
        String newSecurityPassword = null;
        if(newPassword != null){
            newSecurityPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        }
        int flag = superUserDao.updateNormalUserInfo(oldUserName,newUserName,newSecurityPassword);
        if(flag == 0){
            throw new RuntimeException("updateNornalUserInfo 修改失败");
        }
        log.info("updateNornalUserInfo  修改成功");
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

    /** 
    * @Description: 超级用户删除普通用户 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/24 
    */
    @Transactional
    @Override
    public ResponseMessage<Integer> deleteNormalUserInfo(String username) {
        int flagDeleteUser;
        flagDeleteUser = superUserDao.deleteNormalUserInfo(username);
        if(flagDeleteUser == 0){
            throw new RuntimeException("删除用户信息失败");
        }
        int flagDeleteDatabase;
        flagDeleteDatabase = superUserDao.deleteDatabase(username);
        if(flagDeleteDatabase == 0){
            throw new RuntimeException("删除数据库失败");
        }

        log.info("deleteNormalUserInfo  删除普通用户成功");
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }
    

    /** 
    * @Description: 超级用户获取所有用户信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/24 
    */
    @Override
    public ResponseMessage<List<NormalUserVO>> getAllNormalUserInfo() {
        List<NormalUserInfo> normalUserInfos = superUserDao.getAllNormalUserInfo();
        List<NormalUserVO> normalUserVOList = new ArrayList<>(normalUserInfos.size());
        if(normalUserInfos == null || normalUserInfos.size() == 0){
            throw new RuntimeException("getAllNormalUserInfo  没有查询到用户信息");
        }
        for(int i = 0; i < normalUserInfos.size(); i++){
            NormalUserVO normalUserVO = new NormalUserVO(normalUserInfos.get(i));
            normalUserVOList.add(normalUserVO);
        }
        ResponseMessage<List<NormalUserVO>> responseMessage = new ResponseMessage<>("success", normalUserVOList);
        return responseMessage;
    }
}
