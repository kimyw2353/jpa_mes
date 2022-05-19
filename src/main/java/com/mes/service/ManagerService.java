package com.mes.service;

import com.mes.dao.ManagerDao;
import com.mes.dao.ManagerQueryDao;
import com.mes.dto.manager.ManagerInputDto;
import com.mes.dto.manager.ManagerListDto;
import com.mes.entity.Account;
import com.mes.entity.Manager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagerService {
    private final HttpServletRequest request;

    private final ManagerDao managerDao = new ManagerDao();
    private final ManagerQueryDao managerQueryDao = new ManagerQueryDao();

    public ManagerService(HttpServletRequest request) {
        this.request = request;
    }

    private void readManagerFields(Manager manager, ManagerInputDto dto) {
        Account account = new Account();
        account.setId(dto.getAccountId());

        manager.setAccount(account);
        manager.setName(dto.getName());
        manager.setGrade(dto.getGrade());
        manager.setTel(dto.getTel());
        manager.setEmail(dto.getEmail());
        manager.setEtc(dto.getEtc());
    }

    public boolean createManagerToAccount(ManagerInputDto dto) {
        try {
            Manager manager = new Manager();
            readManagerFields(manager, dto);
            managerDao.create(manager);

            return true;
        } catch (Exception e) {
            System.out.println("Error : ManagerService.createManagerToAccount");
            System.out.println(dto.toString());
            return false;
        }
    }

    public boolean getManagerById(Integer managerId) {
        Manager manager = managerDao.find(managerId);
        if (manager != null) {
            request.setAttribute("manager" , manager);
            return true;
        }

        return false;
    }

    public boolean updateManagerToAccount(ManagerInputDto dto) {
        Manager manager = managerDao.find(dto.getManagerId());
        if (manager == null) {
            return false;
        }

        try {
            readManagerFields(manager, dto);
            managerDao.update(manager);

            return true;
        } catch (Exception e) {
            System.out.println("Error : ManagerService.updateManagerToAccount");
            System.out.println(dto.toString());
            return false;
        }
    }

    public void managerList(ManagerListDto dto) {
        List<Manager> managers = managerQueryDao.searchManagers(dto);
        long countOfManagers = managerQueryDao.countOfSearchManagers(dto);

        request.setAttribute("managers", managers);
        request.setAttribute("count_of_manager", countOfManagers);
    }
}
