package com.wecp.progressive.dao;

import java.util.ArrayList;
import java.util.*;

import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

//FOR JDBC

// public class CustomerDAOImpl implements CustomerDAO {

//     public Connection connection;

//     public CustomerDAOImpl() {
//         try {
//             connection = DatabaseConnectionManager.getConnection();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public int addCustomer(Customers customers) throws SQLException {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method
//         // 'addCustomer'");

//         int rowsAdded;
//         String sql = "INSERT INTO customers(customer_id,name,email,username,password,role) VALUES(?,?,?,?,?,?)";
//         try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//             ps.setString(1, customers.getName());
//             ps.setString(2, customers.getEmail());
//             ps.setString(3, customers.getUsername());
//             ps.setString(4, customers.getPassword());
//             ps.setString(5, customers.getRole());

//             rowsAdded = ps.executeUpdate();

//             ResultSet rs = ps.getGeneratedKeys();
//             while (rs.next()) {
//                 customers.setCustomer_id(rs.getInt(1));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 0;
//         }
//         return rowsAdded;
//     }

//     @Override
//     public Customers getCustomerById(int customerId) throws UnsupportedOperationException {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method
//         // 'getCustomerById'");
//         // int rowsEffect;
//         String sql = "SELECT * FROM customers WHERE customer_id = ?";
//         try (PreparedStatement ps = connection.prepareStatement(sql)) {
//             ps.setInt(1, customerId);

//             ResultSet rs = ps.executeQuery();

//             if (rs.next()) {
//                 Customers c = new Customers();
//                 c.setCustomer_id(rs.getInt(1));
//                 c.setName(rs.getString(2));
//                 c.setEmail(rs.getString(3));
//                 c.setUsername(rs.getString(4));
//                 c.setPassword(rs.getString(5));
//                 c.setRole(rs.getString(6));
//                 return c;
//             } else {
//                 return null;
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

//     @Override
//     public void updateCustomer(Customers customers) {
//         int rowsAdded;
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method
//         // 'updateCustomer'");
//         String sql = "UPDATE customers SET name = ?,email = ?,username = ?,password = ?, role = ? WHERE customer_id = ?";
//         try (PreparedStatement ps = connection.prepareStatement(sql)) {
//             ps.setString(1, customers.getName());
//             ps.setString(2, customers.getEmail());
//             ps.setString(3, customers.getUsername());
//             ps.setString(4, customers.getPassword());
//             ps.setString(5, customers.getRole());
//             ps.setInt(6, customers.getCustomer_id());

//             rowsAdded = ps.executeUpdate();
//             if (rowsAdded > 0) {
//                 System.out.println(rowsAdded + " rows updated");
//             } else {
//                 System.out.println("!!No customer found with given CustomerID!!");
//             }

//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public void deleteCustomer(int customerId) {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method
//         // 'deleteCustomer'");
//         String sql = "DELETE FROM customers WHERE customer_id = ?";
//         try (PreparedStatement ps = connection.prepareStatement(sql)) {
//             ps.setInt(1, customerId);
//             ps.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public List<Customers> getAllCustomers() {
//         // TODO Auto-generated method stub
//         // throw new UnsupportedOperationException("Unimplemented method
//         // 'getAllCustomers'");

//         String sql = "select * from accounts";

//         List<Customers> li = new ArrayList<>();

//         try (PreparedStatement ps = connection.prepareStatement(sql)) {
//             ResultSet rs = ps.executeQuery();

//             while (rs.next()) {
//                 Customers c = new Customers();
//                 c.setCustomer_id(rs.getInt(1));
//                 c.setName(rs.getString(2));
//                 c.setEmail(rs.getString(3));
//                 c.setUsername(rs.getString(4));
//                 c.setPassword(rs.getString(5));
//                 c.setRole(rs.getString(6));
//                 li.add(c);

//             }
//         } catch (Exception e) {
//             // TODO: handle exception
//             e.printStackTrace();
//         }
//         return li;
//     }

//     @Override
//     public CustomerAccountInfo getCustomerAccountInfo(int customerId) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getCustomerAccountInfo'");
//     }
// }

public class CustomerDAOImpl implements CustomerDAO {
    ArrayList<Customers> al = new ArrayList<>();

    public int addCustomer(Customers customers) {

        for (Customers c : al) {
            if (c.getCustomer_id() == customers.getCustomer_id()) {
                return -1;
            }
        }
        al.add(customers);
        return 1;
    }

    @Override
    public void deleteCustomer(int customerId) {
        // for(int i =0;i<al.size();i++){
        // if(al.get(i).getCustomer_id() == customerId){
        // al.remove(i);
        // }
        // }

        // TODO Auto-generated method stub
        ListIterator<Customers> itr = al.listIterator();
        while (itr.hasNext()) {
            Customers cus = itr.next();
            if (cus.getCustomer_id() == customerId) {
                itr.remove();
                System.out.println("Customer with ID " + customerId + " DELETED!!");
            }
        }
        System.out.println("Customer with ID " + customerId + " not FOUND");

    }

    @Override
    public List<Customers> getAllCustomers() {
        // TODO Auto-generated method stub
        return al;
    }

    @Override
    public CustomerAccountInfo getCustomerAccountInfo(int customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Customers getCustomerById(int customerId) {
        // TODO Auto-generated method stub
        for (Customers c : al) {
            if (c.getCustomer_id() == customerId) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Customers customers) {
        // TODO Auto-generated method stub

    }
}
