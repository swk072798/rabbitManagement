package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.DatabaseInfoDao;
import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import com.nwafu.accountloginmanagement.jdbcActions.JdbcActions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: rabbitmanagement
 * @description: 普通用户登录操作service层
 * @author: liu qinchang
 * @create: 2019-12-09 17:18
 **/

@Service
@Slf4j
public class NormalUserLoginServiceImpl implements NormalUserLoginService {
    @Resource
    NormalUserDao normalUserDao;

    @Resource
    DatabaseInfoDao databaseInfoDao;
    JdbcActions jdbcActions;

    @Override
    public ResponseMessage<NormalUserInfo> normalUserLogin(String username, String password){
        log.info("{}",username);
        String securityPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        NormalUserInfo info = normalUserDao.getNormalUserInfoByUsername(username);
        log.info("查询结果:{}",info);
        if (info == null){
            throw new RuntimeException("未找到相关账号信息");
        }
        if(!info.getPassword().equals(securityPassword)){
            throw new RuntimeException("用户名或密码错误");
        }
        if(!info.getStatus().equals("未登录")){
            throw new RuntimeException("该账号已在其他地方登录");
        }
        normalUserDao.updataLoginStatus("正在登录", username);
        ResponseMessage result = new ResponseMessage("success", 1);
        return result;
    }


    /** 
    * @Description: 普通用户注册
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/1 
    */
    @Transactional(rollbackFor = Exception.class)       //出现任何错误都将进行回滚
    @Override
    public ResponseMessage<Integer> addUserAccount(String username, String password){
        int flag = 0;
        String securityPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        try{
            flag = normalUserDao.addAccount(username,securityPassword);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        if(flag == 0){
            throw new RuntimeException("添加账号失败,该账号已存在或传入的参数有误");
        }
        try {
            normalUserDao.createDatabase(username);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("创建账户数据库失败");
        }
        log.info("创建账号绑定数据库成功");
        try {
            jdbcActions = new JdbcActions(username);
            jdbcActions.runSqlScript();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }  catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        log.info("----数据库创建成功-----");
        String jdbcUrl = "jdbc:mysql://116.62.150.116:3306/" + username + "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=true&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true";
        int addDatabaseInfoFlag = databaseInfoDao.addDatabaseInfo(username,username, jdbcUrl,"root", "123456", "com.mysql.cj.jdbc.Driver");

        if(addDatabaseInfoFlag == 0){
            throw new RuntimeException("数据库信息添加失败");
        }
        log.info("数据库信息添加成功");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("jdbcUrl", jdbcUrl);
        paramMap.put("user", "root");
        paramMap.put("password", "123456");
        paramMap.put("driverClass", "com.mysql.cj.jdbc.Driver");
        log.info("jdbcUrl:  {}",jdbcUrl);
        restTemplate.getForObject("http://localhost:8412/addDatabaseLink" + "?username="+ username+"&jdbcUrl="+ jdbcUrl+"&user=root&password=123456&driverClass=com.mysql.cj.jdbc.Driver", String.class, String.class);
        ResponseMessage responseMessage = new ResponseMessage("注册成功",1);
        return responseMessage;
    }



    @Override
    public ResponseMessage exitNormalUserLogin(String username){
        int statusFlag = normalUserDao.updataLoginStatus("未登录", username);
        if(statusFlag == 0){
            throw new RuntimeException("修改普通用户登录状态失败");
        }
        ResponseMessage responseMessage = new ResponseMessage("success", 1);
        return responseMessage;
    }


}
