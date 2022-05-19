package com.mes.controller.system;

import com.mes.controller.Controller;
import com.mes.dto.manager.ManagerListDto;
import com.mes.dto.system.UserListDto;
import com.mes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return UserListController.METHOD;
    }

    private UserListDto makeDto(HttpServletRequest request) {
        String userId = request.getParameter("user_id");
        String userName = request.getParameter("user_name");

        return new UserListDto(userId, userName);
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("시스템 관리");
        navigation.add("사용자 관리");

        request.setAttribute("navigation", navigation);
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        UserListDto dto = makeDto(request);

        UserService userService = new UserService(request);
        userService.userList(dto);

        return "/admin/system/user-list.jsp";
    }
}
