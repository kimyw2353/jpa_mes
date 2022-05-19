package com.mes.controller;

import com.mes.router.*;
import com.mes.util.HibernateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontController", value = "*.do")
public class FrontController extends HttpServlet {
    HashMap<String, Controller> router = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        if (router.containsKey(path)) {
            Controller frontController = router.get(path);
            String method = req.getMethod();
            if (frontController.getMethod().equals(method)) {
                String viewFilePath = frontController.execute(req, resp);
                if (viewFilePath != null) {
                    req.getRequestDispatcher(viewFilePath).forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/admin/error/403.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.closeFactory();
    }

    @Override
    public void init(ServletConfig config) {
        new LoginRouter(router);
        new CodeRouter(router);
        new AccountRouter(router);
        new ManagerRouter(router);
        new SystemRouter(router);

        router.put("/admin/main.do", new MainController());
    }
}
