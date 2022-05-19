package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateManagerToAccountController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return UpdateManagerToAccountController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer managerId = Integer.parseInt(request.getParameter("id"));

        ManagerService managerService = new ManagerService(request);
        boolean result = managerService.getManagerById(managerId);
        if (result) {
            return "/admin/account/popup-manager-input-form.jsp";
        }

        request.setAttribute("message", "등록된 담당자가 없습니다.");
        return "/admin/script/popup-close.jsp";
    }
}
