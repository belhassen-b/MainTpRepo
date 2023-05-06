package org.example.operations;

import org.example.utils.BaseJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Operation extends BaseJDBC {

    private int id;
    private double amount;
    private OperationStatus status;

    private int accountId;

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {

        return status.toString();
    }

    public Operation(double amount, int accountId) {
        this.amount = amount;
        this.accountId = accountId;
        this.status = (this.amount >= 0) ? OperationStatus.DEPOSIT : OperationStatus.WITHDRAWL;
    }

    public Operation(int id, double amount, int accountId) {
        this(amount, accountId);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO operation (amount, status, account_id) VALUES (?, ?, ?)";
        connection = getConnection();
        try {
            statement = connection.prepareStatement(request);
            statement.setDouble(1, getAmount());
            statement.setString(2, this.status.toString());
            statement.setInt(3, getId());
            int affactedRows = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
            return affactedRows == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static List<Operation> getAllByAccountId(int account_Id) throws SQLException {
       List<Operation> operations = new ArrayList<>();
         request = "SELECT * FROM operation WHERE account_id = ?";
         connection = new BaseJDBC().getConnection();
         statement = connection.prepareStatement(request);
         statement.setInt(1, account_Id);
         resultSet = statement.executeQuery();
         while (resultSet.next()) {
             Operation o = new Operation(
                     resultSet.getInt("id"),
                     resultSet.getDouble("amount"),
                     resultSet.getInt("account_id")
             );
                operations.add(o);
         }
            return operations;
    }
}
enum OperationStatus {
    DEPOSIT,
    WITHDRAWL
}