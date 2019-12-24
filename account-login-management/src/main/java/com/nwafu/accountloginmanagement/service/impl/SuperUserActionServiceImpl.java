package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.dao.SuperUserDao;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.SuperUserActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.rmi.ServerException;

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

    @Resource
    NormalUserDao normalUserDao;

    @Override
    public ResponseMessage<Integer> updateNornalUserInfo(String oldUserName, String newUserName, String newPassword) throws ServerException {
        if(oldUserName == null){
            throw new ServerException("updateNornalUserInfo  oldUserName不能为空");
        }
        String newSecurityPassword = null;
        if(newPassword != null){
            newSecurityPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        }
        int flag = superUserDao.updateNormalUserInfo(oldUserName,newUserName,newSecurityPassword);
        if(flag == 0){
            throw new ServerException("updateNornalUserInfo 修改失败");
        }
        log.info("updateNornalUserInfo  修改成功");
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

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
}
