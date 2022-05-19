package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.code.CodeListController;
import com.mes.controller.code.SystemCodeListController;

import java.util.HashMap;

public class CodeRouter {
    public CodeRouter(HashMap<String, Controller> router) {
        // 기초 자료 관리 > 시스템 코드 관리
        router.put("/admin/systemCodeList.do", new SystemCodeListController());

        // 기초 자료 관리 > 코드 리스트 조회
        router.put("/admin/codeList.do", new CodeListController());
    }
}
