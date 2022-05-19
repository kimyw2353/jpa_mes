package com.mes.dao;

import com.mes.dto.account.AccountListDto;
import com.mes.entity.Account;
import com.mes.model.Address;
import com.mes.model.Business;
import com.mes.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC 를 이용한 AccountDao
 */
public class AccountQueryDao extends QueryDao {
    private Account newAccount(ResultSet result) throws SQLException {
        Business business = new Business(result.getString("business_number"), result.getString("business_type"), result.getString("business_category"));
        Address addressMain = new Address(result.getString("zip_code1"), result.getString("address1"), result.getString("address_detail1"));
        Address addressSub = new Address(result.getString("zip_code2"), result.getString("address2"), result.getString("address_detail2"));

        Account account = new Account();
        account.setId(result.getInt("id"));
        account.setCode(result.getString("accounts_code"));
        account.setName(result.getString("name"));
        account.setCeo(result.getString("ceo"));
        account.setTel(result.getString("tel"));
        account.setFax(result.getString("fax"));
        account.setEmail(result.getString("email"));
        account.setBusiness(business);
        account.setAddress1(addressMain);
        account.setAddress2(addressSub);
        account.setCreatedAt(result.getDate("created_at"));
        account.setUpdatedAt(result.getDate("updated_at"));

        return account;
    }

    private String makeAccountSearchQuery(String type, AccountListDto dto) {
        String sql = "select ";
        sql += type.equals("list") ? "* " : "count(*) as cnt ";
        sql += "from accounts where 1 = 1 ";
        sql += where("accounts_code", dto.getAccountCode());
        sql += whereLike("name", dto.getAccountName());
        if (type.equals("list")) {
            sql += orderBy("created_at", "desc");
        }

        System.out.println(type + " query");
        System.out.println(sql);
        return sql;
    }

    public List<Account> searchAccounts(AccountListDto dto) {
        List<Account> accounts = new ArrayList<>();

        String sql = makeAccountSearchQuery("list", dto);

        try (Connection connection = DBUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                Account account = newAccount(result);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public long countOfSearchAccounts(AccountListDto dto) {
        long count = 0;

        String sql = makeAccountSearchQuery("count", dto);

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
