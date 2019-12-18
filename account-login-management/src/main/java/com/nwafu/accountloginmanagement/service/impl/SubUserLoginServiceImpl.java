package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.SubUserDao;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import com.nwafu.accountloginmanagement.service.SubUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.rmi.ServerException;

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
    public ResponseMessage<Integer> subUserLogin(String subUsername, String subPassword) throws ServerException {
        SubAccountInfoPO subAccountInfoPO = subUserDao.subUserLogin(subUsername);
        if(!DigestUtils.md5DigestAsHex(subPassword.getBytes()).equals(subAccountInfoPO.getSubPassword())){
            throw new ServerException("账号密码错误");
        }
        subUserDao.updateSubUserStatus("正在登录", subUsername);
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success");
        return responseMessage;
    }
    
    /** 
    * @Description: 子用户退出登录实现类
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    public ResponseMessage<Integer> exitSubUserLogin(String subUsername) throws ServerException {
        int flag = 0;
        flag = subUserDao.updateSubUserStatus("未登录",subUsername);
        if(flag == 0){
            throw new ServerException("退出登录失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success", 1);
        return responseMessage;
    }

}
