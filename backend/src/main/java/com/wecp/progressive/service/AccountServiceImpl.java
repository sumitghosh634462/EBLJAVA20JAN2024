package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;

//import net.bytebuddy.implementation.InvokeDynamic.InvocationProvider.ReturnTypeProvider;

public class AccountServiceImpl  implements AccountService{

    private static List<Accounts> al = new ArrayList<>();
    private AccountDAO accountDAO;
    

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllAccounts'");
      
       return null;
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAccountsByUser'");
        return null;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAccountById'");
       return null;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'addAccount'");
       return -1;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");

    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllAccountsSortedByBalance'");
       return null;
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllAccountsFromArrayList'");
       return null;
    }

    @Override
    public List<Accounts> addAccountToArrayList(Accounts accounts) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'addAccountToArrayList'");
       al.add(accounts);
       return al;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'getAllAccountsSortedByBalanceFromArrayList'");
      List<Accounts> sortedl = al;
      Collections.sort(sortedl);
      return sortedl;
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'emptyArrayList'");
        al = new ArrayList<>();
    }

}