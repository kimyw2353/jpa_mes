package com.mes.controller.manager;

import com.mes.controller.Controller;
import com.mes.dto.account.AccountListDto;
import com.mes.dto.manager.ManagerListDto;
import com.mes.service.AccountService;
import com.mes.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ManagerListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return ManagerListController.METHOD;
    }

    private ManagerListDto makeDto(HttpServletRequest request) {
        String accountName = request.getParameter("account_name");
        String accountKind = request.getParameter("manager_name");

        return new ManagerListDto(accountName, accountKind);
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 담당 관리");

        request.setAttribute("navigation", navigation);
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        ManagerListDto dto = makeDto(request);

        ManagerService managerService = new ManagerService(request);
        managerService.managerList(dto);

        return "/admin/manager/manager-list.jsp";
    }
}
