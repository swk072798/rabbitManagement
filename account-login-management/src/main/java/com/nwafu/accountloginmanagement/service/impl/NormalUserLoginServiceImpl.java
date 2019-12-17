package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.DatabaseInfoDao;
import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import jdbcActions.JdbcActions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.rmi.ServerException;
import java.sql.SQLException;


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
    public ResponseMessage<NormalUserInfo> normalUserLogin(String username, String password) throws ServerException {
        log.info("{}",username);
        String securityPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        NormalUserInfo info = normalUserDao.getNormalUserInfoByUsername(username);
        log.info("查询结果:{}",info);
        if (info == null){
            throw new ServerException("未找到相关账号信息");
        }
        if(!info.getPassword().equals(securityPassword)){
            throw new ServerException("用户名或密码错误");
        }
        if(!info.getStatus().equals("未登录")){
            throw new ServerException("该账号已在其他地方登录");
        }
        normalUserDao.updataLoginStatus("正在登录", username);
        ResponseMessage result = new ResponseMessage();
        result.setData(info);
        return result;
    }



    @Transactional(rollbackFor = Exception.class)       //出现任何错误都将进行回滚
    @Override
    public ResponseMessage<Integer> addUserAccount(String username, String password) throws ServerException {
        int flag = 0;
        String securityPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        try{
            flag = normalUserDao.addAccount(username,securityPassword);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        if(flag == 0){
            throw new ServerException("添加账号失败,该账号已存在或传入的参数有误");
        }
        try {
            normalUserDao.createDatabase(username);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServerException("创建账户数据库失败");
        }
        log.info("创建账号绑定数据库成功");
        try {
            jdbcActions = new JdbcActions(username);
            jdbcActions.runSqlScript();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ServerException(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            throw new ServerException(e.getMessage());
        } catch (FileNotFoundException e) {
            log.error("脚本文件没找到, {}", e.getMessage());
            throw new ServerException(e.getMessage());
        }
        log.info("----数据库创建成功-----");
        String jdbcUrl = "jdbc:mysql://116.62.150.116:3306/" + username + "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=true&verifyServerCertificate=false&autoReconnct=true&autoReconnectForPools=true&allowMultiQueries=true";
        int addDatabaseInfoFlag = databaseInfoDao.addDatabaseInfo(username,username, jdbcUrl,"root", "123456", "com.mysql.cj.jdbc.Driver");
        if(addDatabaseInfoFlag == 0){
            throw new ServerException("数据库信息添加失败");
        }
        log.info("数据库信息添加成功");
        ResponseMessage responseMessage = new ResponseMessage("注册成功",1);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addSubAccount(String subUsername, String subPassword, String parentUser) throws ServerException {
        int flag = 0;
        try{
            flag = normalUserDao.addSubAccount(subUsername,subPassword,parentUser);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(flag == 0){
            throw new ServerException("分配子用户失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("添加子用户成功",1);
        return responseMessage;
    }

    @Override
    public ResponseMessage exitNormalUserLogin(String username) throws ServerException {
        int statusFlag = normalUserDao.updataLoginStatus("未登录", username);
        if(statusFlag == 0){
            throw new ServerException("修改普通用户登录状态失败");
        }

        return null;
    }


}
