package com.casestudy.service.user;

import com.casestudy.model.user.Role;
import com.casestudy.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String roleName);
}
