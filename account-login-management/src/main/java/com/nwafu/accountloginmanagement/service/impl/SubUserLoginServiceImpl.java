package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.config.RedisUtils;
import com.nwafu.accountloginmanagement.dao.SubUserDao;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import com.nwafu.accountloginmanagement.entity.UserCacheInfo;
import com.nwafu.accountloginmanagement.service.SubUserLoginService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @program: rabbitmanagement
 * @description: 子用户登录实现类
 * @author: liu qinchang
 * @create: 2019-12-17 16:13
 **/
@Service
@Slf4j
public class SubUserLoginServiceImpl implements SubUserLoginService {

    @Resource
    SubUserDao subUserDao;

    /** 
    * @Description: 子用户登录实现类 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @Override
    public ResponseMessage<Integer> subUserLogin(String subUsername, String subPassword){
        SubAccountInfoPO subAccountInfoPO = subUserDao.subUserLogin(subUsername);
        if (subAccountInfoPO == null){
            throw new RuntimeException("未找到相关账号信息");
        }
        if(!DigestUtils.md5DigestAsHex(subPassword.getBytes()).equals(subAccountInfoPO.getSubPassword())){
            throw new RuntimeException("账号密码错误");
        }
        if(!subAccountInfoPO.getStatus().equals("未登录")){
            throw new RuntimeException("该账号已在其他地方登录");
        }
        subUserDao.updateSubUserStatus("正在登录", subUsername);
        UserCacheInfo userCacheInfo = new UserCacheInfo(subUsername, subAccountInfoPO.getPermissions(), subAccountInfoPO.getParentUser());
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.addObject(subUsername, userCacheInfo);
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }
    
    /** 
    * @Description: 子用户退出登录实现类
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    public ResponseMessage<Integer> exitSubUserLogin(String subUsername){
        int flag = 0;
        flag = subUserDao.updateSubUserStatus("未登录",subUsername);
        if(flag == 0){
            throw new RuntimeException("退出登录失败");
        }
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.delete(subUsername);
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

}
