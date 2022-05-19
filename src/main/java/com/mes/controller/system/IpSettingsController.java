package com.mes.controller.system;

import com.mes.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IpSettingsController implements Controller {
    private static final String METHOD = "GET";

    @Override
    public String getMethod() {
        return IpSettingsController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/admin/system/popup-ip-settings.jsp";
    }
}
