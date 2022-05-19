package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.system.IpSettingsController;
import com.mes.controller.system.UserListController;

import java.util.HashMap;

public class SystemRouter {
    public SystemRouter(HashMap<String, Controller> router) {
        // 시스템 관리 > 사용자 관리
        router.put("/admin/userList.do", new UserListController());

        // 시스템 관리 > IP 설정
        router.put("/admin/ipSettings.do", new IpSettingsController());
    }
}
