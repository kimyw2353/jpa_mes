package com.mes.dao;

import com.mes.entity.Account;
import org.hibernate.engine.spi.SessionImplementor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.awt.print.Book;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountDao extends JpaDao<Account> {
    @Override
    public Account create(Account account) {
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());
        return super.create(account);
    }

    public Account find(Object accountId) {
        return super.find(Account.class, accountId);
    }

    @Override
    public Account update(Account account) {
        account.setUpdatedAt(new Date());
        return super.update(account);
    }
}
