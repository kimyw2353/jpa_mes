package com.mes.router;

import com.mes.controller.Controller;
import com.mes.controller.account.*;

import java.util.HashMap;

public class AccountRouter {
    public AccountRouter(HashMap<String, Controller> router) {
        // 거래처 관리 > 거래처 정보 관리
        router.put("/admin/accountList.do", new AccountListController());

        // 거래처 관리 > 거래처 정보 관리 > 등록하기
        router.put("/admin/createAccount.do", new CreateAccountController());
        router.put("/admin/createAccountProc.do", new CreateAccountProcController());

        // 거래처 관리 > 거래처 정보 관리 > 수정하기
        router.put("/admin/updateAccount.do", new UpdateAccountController());
        router.put("/admin/updateAccountProc.do", new UpdateAccountProcController());

        // 거래처 관리 > 거래처 정보 관리 > 상세보기 > 담당자 등록하기
        router.put("/admin/account/createManager.do", new CreateManagerToAccountController());
        router.put("/admin/account/createManagerProc.do", new CreateManagerToAccountProcController());

        // 거래처 관리 > 거래처 정보 관리 > 상세보기 > 담당자 수정하기
        router.put("/admin/account/updateManager.do", new UpdateManagerToAccountController());
        router.put("/admin/account/updateManagerProc.do", new UpdateManagerToAccountProcController());
    }
}
