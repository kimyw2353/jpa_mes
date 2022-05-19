package com.mes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return MainController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/main.jsp";
    }
}
