package com.mes.controller.login;

import com.mes.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return LoginController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/login.jsp";
    }
}
