package com.mes.service;

import com.mes.dao.ManagerQueryDao;
import com.mes.dao.UserQueryDao;
import com.mes.dto.system.UserListDto;
import com.mes.entity.Manager;
import com.mes.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService {
    private final HttpServletRequest request;

    private final UserQueryDao userQueryDao = new UserQueryDao();

    public UserService(HttpServletRequest request) {
        this.request = request;
    }

    public void userList(UserListDto dto) {
        List<User> users = userQueryDao.searchUsers(dto);
        long countOfUsers = userQueryDao.countOfSearchUsers(dto);

        request.setAttribute("users", users);
        request.setAttribute("count_of_users", countOfUsers);

    }
}
