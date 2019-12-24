package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.SuperUserDao;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SuperAdminInfo;
import com.nwafu.accountloginmanagement.service.SuperAdminLoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 超级用户登录实现类
 * @author: liu qinchang
 * @create: 2019-12-19 11:53
 **/
@Service
public class SuperUserLoginServiceImpl implements SuperAdminLoginService {

    @Resource
    SuperUserDao superUserDao;

    /**
    * @Description: 超级用户登录
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/19
    */
    @Override
    public ResponseMessage<Integer> superUserLogin(String superUsername, String superPassword){
        SuperAdminInfo superAdminInfo = superUserDao.getSuperUserInfo(superUsername);
        if(superAdminInfo == null || !DigestUtils.md5DigestAsHex(superPassword.getBytes()).equals(superAdminInfo.getSuperPassword())){
            throw new RuntimeException("超级用户登录失败");
        }
        if(superAdminInfo.getStatus().equals("正在登录")){
            throw new RuntimeException("该账号正在登录");
        }
        int flag = 0;
        flag = superUserDao.updateSuperUserStatus("正在登录", superUsername);
        if(flag == 0){
            throw new RuntimeException("超级用户登陆失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

    /**
    * @Description: 超级用户退出登录
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/19
    */
    @Override
    public ResponseMessage<Integer> superUserExitLogin(String superUsername){
        int flag;
        flag = superUserDao.updateSuperUserStatus("未登录", superUsername);
        if(flag == 0){
            throw new RuntimeException("登陆失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

    /**
     * @Description: 创建超级用户
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2019/12/19
     */
    @Override
    public ResponseMessage<Integer> addSuperUserAccount(String superUsername, String superPassword){
        String securitySuperPassword = DigestUtils.md5DigestAsHex(superPassword.getBytes());
        int flag;
        flag = superUserDao.addSuperUserAccount(superUsername,securitySuperPassword);
        if(flag == 0){
            throw new RuntimeException("addSuperUserAccount  创建超级用户账号失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }



}
