package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.entity.Customers;

public class CustomerServiceImpl implements CustomerService{

  List<Customers> al = new ArrayList<>();
  private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
       return null;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
       return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'addCustomer'");
      return -1;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");

    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByName'");
      return null;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersFromArrayList'");
      return null;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'addCustomersToArrayList'");
      al.add(customers);
      return al;
    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByNameFromArrayList'");
       List<Customers> sortedl = al;
      Collections.sort(sortedl);
      return sortedl;
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'emptyArrayList'");
      al = new ArrayList<>();
    }

}