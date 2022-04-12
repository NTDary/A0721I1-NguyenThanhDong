package com.casestudy.service.user;

import com.casestudy.model.user.User;
import com.casestudy.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {
    User findByName(String username);
//    Integer getUserIdByName(String username);
////    Boolean existsUsersByName(String username);
}
