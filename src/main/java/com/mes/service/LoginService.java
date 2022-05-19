package com.mes.service;

import com.mes.dao.UserDao;
import com.mes.dto.LoginDto;
import com.mes.entity.User;
import com.mes.util.HashGenerator;

import javax.servlet.http.HttpServletRequest;

public class LoginService {
    private final HttpServletRequest request;

    private final UserDao userDao = new UserDao();

    public LoginService(HttpServletRequest request) {
        this.request = request;
    }

    public boolean login(LoginDto dto) {
        User user = userDao.findByUserId(dto.getUserId());
        if (user == null) {
            request.setAttribute("message", "일치하는 회원 정보가 없습니다.");
            return false;
        }

        String encryptedPwd = HashGenerator.generateMD5(dto.getPassword());
        if (!user.getPassword().equals(encryptedPwd)) {
            request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
            return false;
        }

        request.getSession().setAttribute("SESSION_USER", user);
        return true;
    }
}
