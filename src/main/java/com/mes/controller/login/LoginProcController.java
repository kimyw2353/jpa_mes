package com.mes.controller.login;

import com.mes.controller.Controller;
import com.mes.dto.LoginDto;
import com.mes.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcController implements Controller {
    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return LoginProcController.METHOD;
    }

    private LoginDto makeDto(HttpServletRequest request) {
        String userId = request.getParameter("user_id");
        String password = request.getParameter("password");

        return new LoginDto(userId, password);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LoginDto dto = makeDto(request);

        LoginService loginService = new LoginService(request);
        boolean result = loginService.login(dto);
        if (result) {
            request.setAttribute("target", "/admin/main.do");
            return "/admin/script/redirect.jsp";
        }

        return "/admin/login.jsp";
    }
}
