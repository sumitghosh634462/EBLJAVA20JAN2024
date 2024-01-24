package com.wecp.progressive.dao;
import java.util.*;

import com.wecp.progressive.entity.Transactions;

// import com.wecp.progressive.dto.CustomerAccountInfo;
// import com.wecp.progressive.entity.Transactions;

// public class TransactionDAOImpl implements TransactionDAO{


// import java.util.ArrayList;
// import java.util.List;

// import org.hibernate.loader.custom.Return;

// import com.wecp.progressive.entity.Transactions;

// public class TransactionDAOImpl implements TransactionDAO {

//   private int rowsAdded;
//   private static Connection connection;

//   public TransactionDAOImpl() {
//     try {
//       connection = DatabaseConnectionManager.getConnection();
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//   }

//   @Override
//   public int addTransaction(Transactions transaction) throws UnsupportedOperationException {
//     // TODO Auto-generated method stub
//     // throw new UnsupportedOperationException("Unimplemented method
//     // 'addTransaction'");

//     String sql = "INSERT INTO transaction(account_id,amount,transaction_date,transaction_type) VALUES(?,?,?,?) WHERE transaction_id = ?";
//     try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//       ps.setInt(1, transaction.getAccount_id());
//       ps.setDouble(2, transaction.getAmount());
//       ps.setDate(3, transaction.getTransaction_date());
//       ps.setString(4, transaction.getTransaction_type());

//       rowsAdded = ps.executeUpdate();

//       ResultSet rs = ps.getGeneratedKeys();
//       while (rs.next()) {
//         transaction.setTransaction_id(rs.getInt(1));
//       }

//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return rowsAdded;
//   }

//   @Override
//   public Transactions getTransactionById(int transactionId) throws UnsupportedOperationException {
//     // TODO Auto-generated method stub
//     // throw new UnsupportedOperationException("Unimplemented method
//     // 'getTransactionById'");
//     String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
//     Transactions t = new Transactions();
//     try (PreparedStatement ps = connection.prepareStatement(sql)) {
//       ps.setInt(1, transactionId);

//       ResultSet rs = ps.executeQuery();
//       if (rs.next()) {
//         t.setTransaction_id(rs.getInt(1));
//         t.setAccount_id(rs.getInt(2));
//         t.setAmount(rs.getDouble(3));
//         t.setTransaction_date(rs.getDate(4));
//         t.setTransaction_type(rs.getString(5));

//       } else {
//         return null;
//       }

//     } catch (SQLException e) {
//       e.printStackTrace();
//       return null;
//     }
//     return t;
//   }

//   @Override
//   public void updateTransaction(Transactions transaction) {
//     // TODO Auto-generated method stub
//     // throw new UnsupportedOperationException("Unimplemented method
//     // 'updateTransaction'");
//     String sql = "UPDATE transaction SET account_id = ?, amount = ?, transaction_date = ?, transaction_type = ? WHERE transaction_id = ?";
//     try (PreparedStatement ps = connection.prepareStatement(sql)) {
//       ps.setInt(1, transaction.getAccount_id());
//       ps.setDouble(2, transaction.getAmount());
//       ps.setDate(3, transaction.getTransaction_date());
//       ps.setString(4, transaction.getTransaction_type());
//       ps.setInt(5, transaction.getTransaction_id());

//       ps.executeUpdate();
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//   }

//   @Override
//   public void deleteTransaction(int transactionId) {
//     // TODO Auto-generated method stub
//     // throw new UnsupportedOperationException("Unimplemented method
//     // 'deleteTransaction'");
//     String sql = "DELETE FROM transactions WHERE transaction_id = ?";
//     try (PreparedStatement ps = connection.prepareStatement(sql)) {
//       ps.setInt(1, transactionId);
//       ps.executeUpdate();
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//   }

//   @Override
//   public List<Transactions> getAllTransactions() throws UnsupportedOperationException {
//     // TODO Auto-generated method stub
//     // throw new UnsupportedOperationException("Unimplemented method
//     // 'getAllTransactions'");
//     String sql = "SELECT * FROM transactions";
//     List<Transactions> li = new ArrayList<>();
//     try (PreparedStatement ps = connection.prepareStatement(sql)) {
//       ResultSet rs = ps.executeQuery();

//       while (rs.next()) {
//         Transactions t = new Transactions();
//         t.setTransaction_id(rs.getInt(1));
//         t.setAccount_id(rs.getInt(2));
//         t.setAmount(rs.getDouble(3));
//         t.setTransaction_date(rs.getDate(4));
//         t.setTransaction_type(rs.getString(5));
//         li.add(t);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return li;

//   }

// }

public class TransactionDAOImpl implements TransactionDAO {
   ArrayList<Transactions> al = new ArrayList<Transactions>();

  @Override
  public int addTransaction(Transactions transaction) {
    // TODO Auto-generated method stub
    for (Transactions t : al) {
      if (t.getTransaction_id() == transaction.getTransaction_id()) {
        return -1;
      }
    }
    al.add(transaction);
    return 1;
  }

  @Override
  public void deleteTransaction(int transactionId) {
    // TODO Auto-generated method stub
    for (Transactions t : al) {
      if (t.getTransaction_id() == transactionId) {
        al.remove(transactionId);
        System.out.println("Transaction Id--> " + transactionId + " DELETED");
      }
    }
    System.out.println("Transaction Id " + transactionId + " Not Found!!");

  }

  @Override
  public List<Transactions> getAllTransactions() {
    // TODO Auto-generated method stub
    return al;
  }

  @Override
  public Transactions getTransactionById(int transactionId) {
    // TODO Auto-generated method stub
    for (Transactions t : al) {
      if (t.getTransaction_id() == transactionId) {
        return t;
      }
    }
    return null;
  }

  @Override
  public void updateTransaction(Transactions transaction) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateTransaction'");
  }

}
