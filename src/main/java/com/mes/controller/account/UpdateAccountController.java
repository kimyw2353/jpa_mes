package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UpdateAccountController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return UpdateAccountController.METHOD;
    }

    private void setNavigation(HttpServletRequest request) {
        List<String> navigation = new ArrayList<>();
        navigation.add("거래처 관리");
        navigation.add("거래처 정보 관리");
        navigation.add("거래처 수정하기");

        request.setAttribute("navigation", navigation);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setNavigation(request);

        Integer accountId = Integer.parseInt(request.getParameter("id"));

        AccountService accountService = new AccountService(request);
        boolean result = accountService.findAccountById(accountId);
        if (result) {
            return "/admin/account/account-input-form.jsp";
        }

        request.setAttribute("message", "등록된 거래처가 없습니다.");
        request.setAttribute("target", "/admin/accountList.do");
        return "/admin/script/redirect.jsp";
    }
}
