package com.mes.controller.code;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CodeListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return CodeListController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("기초 자료 관리");
        navigation.add("코드 리스트 조회");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        return "/admin/code/code-list.jsp";
    }
}
