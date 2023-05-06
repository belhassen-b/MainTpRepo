package tpJDBC.dao;

import tpJDBC.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO extends BaseDAO<Product> {
    public ProductDAO(Connection connection) {
        super(connection);
    }


    public boolean create(Product product) throws SQLException {
        request = "INSERT INTO product (name, price, quantity, description) VALUES (?,?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getQuantity());
        statement.setString(4, product.getDescription());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            product.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }


    public void findAll() throws SQLException {
        request = "SELECT * FROM product";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id : " + resultSet.getInt("id"));
            System.out.println("name : " + resultSet.getString("name"));
            System.out.println("price : " + resultSet.getInt("price"));
            System.out.println("quantity : " + resultSet.getInt("quantity"));
            System.out.println("description : " + resultSet.getString("description"));
        }
    }

    public Product findById(int id) throws SQLException {
        Product product = null;
        request = "SELECT * FROM product WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("price"), resultSet.getInt("quantity"), resultSet.getString("description"));
            System.out.println("id : " + resultSet.getInt("id"));
            System.out.println("name : " + resultSet.getString("name"));
            System.out.println("price : " + resultSet.getInt("price"));
            System.out.println("quantity : " + resultSet.getInt("quantity"));
            System.out.println("description : " + resultSet.getString("description"));
            return product;
        } else {
            System.out.println("Le produit n'existe pas");
            return null;
        }
    }

    public boolean update(Product product) throws SQLException {
        request = "UPDATE product SET name = ?, price = ?, quantity = ?, description = ? WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getQuantity());
        statement.setString(4, product.getDescription());
        statement.setInt(5, product.getIdProduct());
        int nbRows = statement.executeUpdate();
        if (nbRows == 1) {
            System.out.println("Le produit a bien été modifié");
        } else {
            System.out.println("Le produit n'a pas été modifié");
        }
        return false;
    }

    public boolean delete(int id) throws SQLException {
        request = "DELETE FROM product WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);

        int nbRows = statement.executeUpdate();
        if (nbRows == 1) {
            System.out.println("Le produit a bien été supprimé");
        } else {
            System.out.println("Le produit n'a pas été supprimé");
        }
        return false;

    }
}


