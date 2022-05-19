package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.login.LoginController;
import com.mes.controller.login.LoginProcController;
import com.mes.controller.login.LogoutController;

import java.util.HashMap;

public class LoginRouter {
    public LoginRouter(HashMap<String, Controller> router) {
        // 로그인
        router.put("/login.do", new LoginController());
        router.put("/loginProc.do", new LoginProcController());
        
        // 로그아웃
        router.put("/logout.do", new LogoutController());
    }
}
