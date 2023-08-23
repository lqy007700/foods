package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {
    boolean queryUserNameIsExist(String username);

    Users createUser(UserBO userbo);

    Users queryUserForLogin(String username, String password);
}
