package com.notes.user.mapper;

import com.notes.user.base.CrudMapper;
import com.notes.user.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends CrudMapper<User> {
    User findUserByUsername(User user);
}
