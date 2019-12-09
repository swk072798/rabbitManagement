package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;

public interface NormalUserLoginService {
    NormalUserInfo getUserInfo(String username);
}
