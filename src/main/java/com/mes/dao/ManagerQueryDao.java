package com.mes.dao;

import com.mes.dto.manager.ManagerListDto;
import com.mes.entity.Account;
import com.mes.entity.Manager;
import com.mes.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerQueryDao extends QueryDao {
    private Manager newManager(ResultSet result) throws SQLException {
        Manager manager = new Manager();
        manager.setId(result.getInt("id"));
        manager.setName(result.getString("name"));
        manager.setGrade(result.getString("grade"));
        manager.setTel(result.getString("tel"));
        manager.setEmail(result.getString("email"));
        manager.setEtc(result.getString("etc"));
        manager.setCreatedAt(result.getDate("created_at"));
        manager.setUpdatedAt(result.getDate("updated_at"));

        try {
            Account account = new Account();
            account.setId(result.getInt("account_id"));
            account.setName(result.getString("account_name"));
            manager.setAccount(account);
        } catch (SQLException e) {
            System.out.println("Column 'account_id', 'account_name' not found");
        }

        return manager;
    }

    public List<Manager> findAllByAccountId(Integer accountId) {
        List<Manager> managers = new ArrayList<>();

        String sql = "select * from accounts_manager where accounts_id = " + accountId + " order by created_at desc";

        System.out.println(sql);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                Manager manager = newManager(result);
                managers.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return managers;
    }

    private String makeManagerSearchQuery(String type, ManagerListDto dto) {
        String sql = "select ";
        sql += type.equals("list") ?
                "accounts_manager.*, accounts.id as account_id, accounts.name as account_name " :
                "count(accounts_manager.id) as cnt ";
        sql += "from accounts_manager ";
        sql += "inner join accounts on accounts_manager.accounts_id = accounts.id ";
        sql += "where 1 = 1 ";
        sql += whereLike("accounts.name", dto.getAccountName());
        sql += whereLike("accounts_manager.name", dto.getManagerName());
        if (type.equals("list")) {
            sql += orderBy("accounts_manager.created_at", "desc");
        }

        System.out.println(type + " query");
        System.out.println(sql);
        return sql;
    }

    public List<Manager> searchManagers(ManagerListDto dto) {
        List<Manager> managers = new ArrayList<>();

        String sql = makeManagerSearchQuery("list", dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                Manager manager = newManager(result);
                managers.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return managers;
    }

    public long countOfSearchManagers(ManagerListDto dto) {
        long count = 0;

        String sql = makeManagerSearchQuery("count", dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            if (result.next()) {
                count = result.getLong("cnt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
