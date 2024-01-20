package com.wecp.progressive.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Accounts;

public class AccountDAOImpl implements AccountDAO {

    private int rowsAdded;
    private static Connection connection;

    public AccountDAOImpl() {
        try {
            connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addAccount(Accounts accounts) {
        // TODO Auto-generated method stub

        String sql = "insert into accounts(customer_id,balance) values (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, accounts.getCustomer_id());
            ps.setDouble(2, accounts.getBalance());

            rowsAdded = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                accounts.setAccount_id(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rowsAdded;

    }

    @Override
    public Accounts getAccountById(int accountId) {
        // TODO Auto-generated method stub

        String sql = "select * from accounts where account_id = ?";
        Accounts a = new Accounts();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                a.setAccount_id(rs.getInt(1));
                a.setCustomer_id(rs.getInt(2));
                a.setBalance(rs.getDouble(3));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return a;

    }

    @Override
    public void updateAccount(Accounts accounts) {
        // TODO Auto-generated method stub
        String sql = "update accounts set customer_id = ?, balance =? where account_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accounts.getCustomer_id());
            ps.setDouble(2, accounts.getBalance());
            ps.setInt(3, accounts.getAccount_id());

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int accountId) {
        // TODO Auto-generated method stub
        String sql = "delete from accounts where account_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, accountId);

            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public List<Accounts> getAllAccounts() {
        // TODO Auto-generated method stub
        String sql = "select * from accounts";

        List<Accounts> li = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Accounts a = new Accounts();
                a.setAccount_id(rs.getInt(1));
                a.setCustomer_id(rs.getInt(2));
                a.setBalance(rs.getDouble(3));
                li.add(a);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return li;
    }

}
