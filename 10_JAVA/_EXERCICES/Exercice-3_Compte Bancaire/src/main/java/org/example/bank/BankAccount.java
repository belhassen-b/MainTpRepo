package org.example.bank;

import org.example.customer.Customer;
import org.example.operations.Operation;
import org.example.utils.BaseJDBC;

import java.sql.SQLException;
import java.util.List;

public class BankAccount extends BaseJDBC {
    private int id;
    private int customerId;

    private List<Operation> operations;

    private double totalAmount;
    private Customer customer;

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public BankAccount(int customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public BankAccount(int id, int customerId, double totalAmount) {
        this(customerId, totalAmount);
        this.id = id;
    }

    public boolean save() {
        try {
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO bank_account (customer_id, totalAmount) VALUES (?, ?)");
            statement.setInt(1, this.customerId);
            statement.setDouble(2, this.totalAmount);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update() throws SQLException {
        connection = getConnection();
        statement = connection.prepareStatement("UPDATE bank_account SET total_amount = ? WHERE id = ?");
        statement.setDouble(1, this.totalAmount);
        statement.setInt(2, this.id);
        statement.executeUpdate();
        return false;
    }
    public boolean makeDeposit(Operation operation) throws SQLException {
        connection = getConnection();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE bank_account SET totalAmount = totalAmount + ? WHERE id = ?");
            statement.setDouble(1, operation.getAmount());
            statement.setInt(2, this.id);
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO operation (amount, status, account_id) VALUES (?, ?, ?)");
            statement.setDouble(1, operation.getAmount());
            statement.setString(2, operation.getStatus());
            statement.setInt(3, this.id);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    public boolean makeWithDrawl(Operation operation) throws SQLException {
        connection = getConnection();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE bank_account SET totalAmount = totalAmount - ? WHERE id = ?");
            statement.setDouble(1, operation.getAmount());
            statement.setInt(2, this.id);
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO operation (amount, status, account_id) VALUES (?, ?, ?)");
            statement.setDouble(1, operation.getAmount());
            statement.setString(2, operation.getStatus().toString());
            statement.setInt(3, this.id);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return false;
    }
    public static BankAccount getById(int id) throws SQLException {
        BankAccount bankAccount = null;
        connection = getConnection();
        try {
            statement = connection.prepareStatement("SELECT * FROM bank_account WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new BankAccount(resultSet.getInt("id"), resultSet.getInt("customer_id"), resultSet.getDouble("totalAmount"));
            }
            bankAccount.customer = Customer.getById(bankAccount.getId());
            bankAccount.operations = Operation.getAllByAccountId(bankAccount.getId());
            return bankAccount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
