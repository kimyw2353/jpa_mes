package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.account.AccountListDto;
import com.mes.service.AccountService;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountListController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return AccountListController.METHOD;
    }

    private AccountListDto makeDto(HttpServletRequest request) {
        String accountCode = request.getParameter("account_code");
        String accountName = request.getParameter("account_name");
        String accountKind = request.getParameter("account_kind");

        return new AccountListDto(accountCode, accountName, accountKind);
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 정보 관리");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        AccountListDto dto = makeDto(request);

        AccountService accountService = new AccountService(request);
        accountService.accountList(dto);

        return "/admin/account/account-list.jsp";
    }
}
