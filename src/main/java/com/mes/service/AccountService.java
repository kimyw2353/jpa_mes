package com.mes.service;

import com.mes.dao.AccountDao;
import com.mes.dao.AccountQueryDao;
import com.mes.dao.ManagerQueryDao;
import com.mes.dto.account.AccountInputDto;
import com.mes.dto.account.AccountListDto;
import com.mes.entity.Account;
import com.mes.entity.Manager;
import com.mes.model.Address;
import com.mes.model.Business;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AccountService {
    private final HttpServletRequest request;

    private final AccountDao accountDao = new AccountDao();
    private final AccountQueryDao accountQueryDao = new AccountQueryDao();
    private final ManagerQueryDao managerQueryDao = new ManagerQueryDao();

    public AccountService(HttpServletRequest request) {
        this.request = request;
    }

    public void accountList(AccountListDto dto) {
        List<Account> accounts = accountQueryDao.searchAccounts(dto);
        long countOfAccount = accountQueryDao.countOfSearchAccounts(dto);

        request.setAttribute("accounts", accounts);
        request.setAttribute("count_of_account", countOfAccount);
    }

    private void readAccountFields(Account account, AccountInputDto dto) {
        account.setName(dto.getAccountName());
        account.setCode(dto.getAccountCode());
        account.setCeo(dto.getCeo());
        account.setTel(dto.getTel());
        account.setFax(dto.getFax());
        account.setEmail(dto.getEmail());

        Business business = new Business(dto.getBusinessNumber(), dto.getBusinessType(), dto.getBusinessCategory());
        account.setBusiness(business);

        Address address1 = new Address(dto.getZipCode1(), dto.getAddress1(), dto.getAddressDetail1());
        account.setAddress1(address1);

        Address address2 = new Address(dto.getZipCode2(), dto.getAddress2(), dto.getAddressDetail2());
        account.setAddress2(address2);
    }

    public boolean createAccount(AccountInputDto dto) {
        try {
            Account account = new Account();
            readAccountFields(account, dto);
            accountDao.create(account);

            return true;
        } catch (Exception e) {
            System.out.println("Error : AccountService.createAccount");
            System.out.println(dto.toString());

            return false;
        }
    }

    public boolean findAccountById(Integer accountId) {
        Account account = accountDao.find(accountId);
        if (account != null) {
            List<Manager> managers = managerQueryDao.findAllByAccountId(accountId);

            request.setAttribute("account" , account);
            request.setAttribute("managers", managers);
            return true;
        }

        return false;
    }

    public boolean updateAccount(AccountInputDto dto) {
        Account account = accountDao.find(dto.getAccountId());
        if (account == null) {
            return false;
        }

        try {
            readAccountFields(account, dto);
            accountDao.update(account);

            return true;
        } catch (Exception e) {
            System.out.println("Error : AccountService.updateAccount");
            System.out.println(dto.toString());
            return false;
        }
    }
}
