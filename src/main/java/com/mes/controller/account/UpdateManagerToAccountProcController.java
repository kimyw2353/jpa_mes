package com.mes.controller.account;

import com.mes.controller.Controller;
import com.mes.dto.manager.ManagerInputDto;
import com.mes.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateManagerToAccountProcController implements Controller {
    private static final String METHOD = "POST";

    @Override
    public String getMethod() {
        return UpdateManagerToAccountProcController.METHOD;
    }

    private ManagerInputDto makeDto(HttpServletRequest request) {
        Integer managerId = Integer.parseInt(request.getParameter("id"));
        Integer accountId = Integer.parseInt(request.getParameter("account_id"));
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String etc = request.getParameter("etc");

        return ManagerInputDto.builder()
                .managerId(managerId)
                .accountId(accountId)
                .name(name)
                .grade(grade)
                .tel(tel)
                .email(email)
                .etc(etc)
                .build();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerInputDto dto = makeDto(request);

        ManagerService managerService = new ManagerService(request);
        boolean result = managerService.updateManagerToAccount(dto);
        if (result) {
            return "/admin/script/popup-close.jsp";
        }

        request.setAttribute("message", "담당자 수정에 오류가 발생 하였습니다.");
        return "/admin/script/popup-close.jsp";
    }
}
