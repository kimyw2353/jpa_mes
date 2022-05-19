package com.mes.dao;

import com.mes.entity.Manager;

import java.util.Date;
import java.util.List;

public class ManagerDao extends JpaDao<Manager> {
    @Override
    public Manager create(Manager manager) {
        manager.setCreatedAt(new Date());
        manager.setUpdatedAt(new Date());
        return super.create(manager);
    }

    public Manager find(Object managerId) {
        return super.find(Manager.class, managerId);
    }

    @Override
    public Manager update(Manager manager) {
        manager.setUpdatedAt(new Date());
        return super.update(manager);
    }
}
