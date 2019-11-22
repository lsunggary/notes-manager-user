package com.notes.user;

import com.notes.user.common.BizException;
import com.notes.user.dao.User;

public interface UserService {
    Integer visitableUsername(String username);

    User visitableUser(User user) throws BizException;

    User getDetail(Integer id) throws BizException;

    Integer registerUser(User user) throws BizException;
}
