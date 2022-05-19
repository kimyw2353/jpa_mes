package com.mes.dao;

import com.mes.entity.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDaoTest {
    private final ManagerDao managerDao = new ManagerDao();

    @Test
    void find() {
        Manager manager = managerDao.find(8);

        System.out.println(manager.getName());
        System.out.println(manager.getAccount().getName());
    }
}