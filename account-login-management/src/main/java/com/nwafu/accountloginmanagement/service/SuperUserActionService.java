package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.NormalUserVO;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;


import java.util.List;

public interface SuperUserActionService {
    ResponseMessage<Integer> updateNornalUserInfo(String oldUserName, String newUserName, String newPassword);
    ResponseMessage<Integer> deleteNormalUserInfo(String username);
    ResponseMessage<List<NormalUserVO>> getAllNormalUserInfo();
}
