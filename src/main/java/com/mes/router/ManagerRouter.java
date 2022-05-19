package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.manager.ManagerListController;

import java.util.HashMap;

public class ManagerRouter {
    public ManagerRouter(HashMap<String, Controller> router) {
        // 거래처 관리 > 거래처 정보 관리
        router.put("/admin/managerList.do", new ManagerListController());
    }
}
