package com.mes.controller.code;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SystemCodeListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return SystemCodeListController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("기초 자료 관리");
        navigation.add("시스템 코드 관리");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        return "/admin/code/system-code-list.jsp";
    }
}
