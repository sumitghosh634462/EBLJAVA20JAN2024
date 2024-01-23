package com.wecp.progressive.dao;


import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

<<<<<<< HEAD
import java.util.List;

public interface CustomerDAO {
    int addCustomer(Customers customers);
=======
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    int addCustomer(Customers customers) throws SQLException;
>>>>>>> 7a35078e25d407a92afa99fb156b1faea3380993
    Customers getCustomerById(int customerId);
    void updateCustomer(Customers customers);
    void deleteCustomer(int customerId);
    List<Customers> getAllCustomers();
    CustomerAccountInfo getCustomerAccountInfo(int customerId);
}