package com.notes.user.control;

import com.notes.user.UserService;
import com.notes.user.common.BizException;
import com.notes.user.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserServerControl {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(HttpServletRequest request) throws BizException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            throw new BizException("401","用户名或密码不能为空！");
        }
        if (username.length() < 6 || password.length() < 6) {
            throw new BizException("401","用户名或密码不能低于6位数！");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.visitableUser(user);
    }

    @PostMapping("/register")
    public Integer register(HttpServletRequest request) throws BizException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            throw new BizException("401","用户名或密码不能为空！");
        }
        if (username.length() < 6 || password.length() < 6) {
            throw new BizException("401","用户名或密码不能低于6位数！");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        return userService.registerUser(user);
    }

    @GetMapping("/check-username")
    public Integer checkUsername(String username) throws BizException {
        if (StringUtil.isEmpty(username)) {
            throw new BizException("401","用户名不能为空！");
        }
        return userService.visitableUsername(username);
    }

}
