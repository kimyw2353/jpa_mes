package com.mes.controller.login;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return LogoutController.METHOD;
    }

    private void clearSession(HttpSession session) {
        session.removeAttribute("SESSION_USER");
        session.invalidate();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clearSession(request.getSession());

        request.setAttribute("target", "/login.do");
        return "/admin/script/redirect.jsp";
    }
}
