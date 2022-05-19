package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.account.AccountInputDto;
import com.mes.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountProcController implements Controller {
    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return CreateAccountProcController.METHOD;
    }

    private AccountInputDto makeDto(HttpServletRequest request) {
        String accountCode = request.getParameter("account_code");
        String accountName = request.getParameter("account_name");
        String businessNumber = request.getParameter("business_number");
        String businessType = request.getParameter("business_type");
        String businessCategory = request.getParameter("business_category");
        String ceo = request.getParameter("ceo");
        String tel = request.getParameter("tel");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");
        String zipCode1 = request.getParameter("zip_code_1");
        String address1 = request.getParameter("address_1");
        String addressDetail1 = request.getParameter("address_detail_1");
        String zipCode2 = request.getParameter("zip_code_2");
        String address2 = request.getParameter("address_2");
        String addressDetail2 = request.getParameter("address_detail_2");

        return AccountInputDto.builder()
                .accountCode(accountCode)
                .accountName(accountName)
                .businessNumber(businessNumber)
                .businessType(businessType)
                .businessCategory(businessCategory)
                .ceo(ceo)
                .tel(tel)
                .fax(fax)
                .email(email)
                .zipCode1(zipCode1)
                .address1(address1)
                .addressDetail1(addressDetail1)
                .zipCode2(zipCode2)
                .address2(address2)
                .addressDetail2(addressDetail2)
                .build();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountInputDto dto = makeDto(request);

        AccountService accountService = new AccountService(request);
        boolean result = accountService.createAccount(dto);
        if (result) {
            request.setAttribute("target", "/admin/accountList.do");
            return "/admin/script/redirect.jsp";
        }

        request.setAttribute("message", "거래처 등록에 오류가 발생 하였습니다.");
        request.setAttribute("target", "/admin/createAccount.do");
        return "/admin/script/redirect.jsp";
    }
}
