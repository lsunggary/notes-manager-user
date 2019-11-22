package com.notes.user.impl;

import com.notes.user.CryptoUtil;
import com.notes.user.UserService;
import com.notes.user.common.BizException;
import com.notes.user.dao.User;
import com.notes.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer visitableUsername(String username) {
        Condition condition = new Condition(User.class);
        StringBuffer sb = new StringBuffer();
        sb.append("username = '");
        sb.append(username);
        sb.append("'");
        condition.createCriteria().andCondition(sb.toString());
        return userMapper.selectCountByCondition(condition);
    }

    @Override
    public User visitableUser(User user) throws BizException {
        user.setPassword(CryptoUtil.encode(user.getPassword()));
        User tempUser = userMapper.findUserByUsername(user);
        if (tempUser != null) {
            tempUser.setPassword("");
            return tempUser;
        }
        throw new BizException("401", "用户名或密码错误！");
    }

    @Override
    public User getDetail(Integer id) throws BizException {
        if (id == 0) {
            throw new BizException("500","用户信息获取失败!");
        }
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer registerUser(User user) throws BizException {
        if (visitableUsername(user.getUsername()) >= 1) {
            throw new BizException("500","已存在该用户!");
        }
        user.setRole("member");
        user.setStatus(1);
        user.setPassword(CryptoUtil.encode(user.getPassword()));
        return userMapper.insert(user);
    }
}
