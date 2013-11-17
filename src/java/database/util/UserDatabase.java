/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import storage.StorageUnit;
import storage.Supplier;
import storage.products.ProductType;
import storage.users.User;
import storage.users.UserRole;

/**
 *
 * @author zbs
 */
public class UserDatabase {

    private static String connectionUrl = "jdbc:mysql://localhost:3306/teddatabase?zeroDateTimeBehavior=convertToNull";
    private static String connectionUser = "root";
    private static String connectionPassword = "test";

    public static Connection initiateConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(UserDatabase.connectionUrl, UserDatabase.connectionUser, UserDatabase.connectionPassword);
            return con;
        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
            return null;
        } catch (ClassNotFoundException exep) {
            System.out.println(exep.getMessage());
            return null;
        }
    }

    public static User getUser(String key, String value) throws SQLException {

        UserRole role = null;
        User user;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM users WHERE " + key + "=\"" + value + "\";");
            if (resultSet.next()) {

                user = new User(resultSet.getString("username"), UserDatabase.getRole(resultSet.getString("role")), resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("email"), resultSet.getBoolean("full_user"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException exep) {
            return null;
        }
    }

    public static List<User> getAllUsers() throws SQLException {


        List<User> User_List = new ArrayList<User>();
        UserRole role = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();

        try {

            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"), role, resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("email"), resultSet.getBoolean("full_user"));
                User_List.add(user);
            }

            return User_List;
        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
            return null;
        }
    }

    public static void insertUser(String username, UserRole Role, String password, String name, String surname, String email) {

        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        try {
            User user = UserDatabase.getUser("username", username);
            if (user == null) {
                statement = con.createStatement();

                String insertTableSQL = "insert users"
                        + "(password, name, surname, email, username) " + "values"
                        + "(\"" + password + "\",\"" + name + "\",\"" + surname + "\",\"" + email + "\",\"" + username + "\")";
                statement.executeUpdate(insertTableSQL);
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static void updateUser(String username, String role, String name, String surname, Boolean full_user) {

        Statement statement;
        Connection con;
        con = UserDatabase.initiateConnection();
        try {
            statement = con.createStatement();
            if (UserDatabase.getUser("username", username) != null) {
                statement.executeUpdate("update users set role=\"" + role + "\", name=\""
                        + name + "\", surname=\"" + surname + "\", full_user="
                        + (full_user ? 1 : 0) + " where username=\"" + username + "\"");
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static void deleteUser(String username) {
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();

        try {
            statement = con.createStatement();

            if (UserDatabase.getUser("username", username) != null) {
                String deleteTableSQL = "delete from users where username=\"" + username + "\";";
                statement.execute(deleteTableSQL);
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static UserRole getRole(String name) throws SQLException {

        Connection con = UserDatabase.initiateConnection();
        ResultSet resultSet;
        try {
            Statement s = con.createStatement();
            resultSet = s.executeQuery("select * from roles where name=\"" + name + "\";");
            if (resultSet.next()) {
                UserRole role = new UserRole(resultSet.getString("name"), resultSet.getBoolean("storage_read"), resultSet.getBoolean("storage_write"), resultSet.getBoolean("product_read"), resultSet.getBoolean("product_write"), resultSet.getBoolean("supplier_read"), resultSet.getBoolean("supplier_write"));
                return role;
            } else {
                return null;
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
            return null;
        }

    }

    public static List<UserRole> getAllRoles() throws SQLException {

        List<UserRole> Role_List = new ArrayList<UserRole>();
        UserRole role;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        try {


            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM roles");

            while (resultSet.next()) {
                role = new UserRole(resultSet.getString("name"), resultSet.getBoolean("storage_read"), resultSet.getBoolean("storage_write"), resultSet.getBoolean("product_read"), resultSet.getBoolean("product_write"), resultSet.getBoolean("supplier_read"), resultSet.getBoolean("supplier_write"));
                Role_List.add(role);
            }

            return Role_List;

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
            return null;
        }
    }

    public static void updateRole(String name, Boolean storage_read, Boolean storage_write, Boolean product_read, Boolean product_write, Boolean supplier_read, Boolean supplier_write) {

        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        try {

            statement = con.createStatement();
            statement.executeUpdate("update roles set name=\"" + name
                    + "\", storage_read=" + (storage_read ? 1 : 0)
                    + ", storage_write=" + (storage_write ? 1 : 0)
                    + ", product_read=" + (product_read ? 1 : 0)
                    + ", product_write=" + (product_write ? 1 : 0)
                    + ", supplier_read=" + (supplier_read ? 1 : 0)
                    + ", supplier_write=" + (supplier_write ? 1 : 0)
                    + " where name=\"" + name + "\"");


        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static void insertRole(String name, Boolean storage_read, Boolean storage_write, Boolean product_read, Boolean product_write, Boolean supplier_read, Boolean supplier_write) throws SQLException {
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();

        try {
            UserRole role = UserDatabase.getRole(name);
            if (role == null) {

                statement = con.createStatement();

                String insertTableSQL = "insert roles"
                        + "(name, storage_read, storage_write, product_read, product_write, supplier_read, supplier_write) " + "values"
                        + "(\"" + name + "\"," + storage_read + "," + storage_write + "," + product_read + "," + product_write + "," + supplier_read + "," + supplier_write + ")";

                statement.executeUpdate(insertTableSQL);
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }

    }

    public static void deleteRole(String name) {
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();

        try {
            UserRole role = UserDatabase.getRole(name);

            statement = con.createStatement();

            String deleteTableSQL = "delete from roles where name=\"" + name + "\";";

            statement.execute(deleteTableSQL);

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static ProductType getProduct(String name, String serialNum) throws SQLException {

        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM products WHERE name=\'" + name + "\' AND serialNum=\'" + serialNum + "\'");
            if (resultSet.next()) {

                product = new ProductType(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("serialNum"), resultSet.getString("producttype"), resultSet.getString("size"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getFloat("weight"), resultSet.getBoolean("availability"), resultSet.getString("nameOfUnit"), resultSet.getString("supplierName"), resultSet.getString("supplierSurname"));

                return product;

            } else {
                return null;
            }
        } catch (SQLException exep) {
            return null;
        }
    }

    public static void deleteProduct(String name, String serialNum) throws SQLException {

        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {

            statement.execute("DELETE FROM products where name=\'" + name + "\' AND serialNum=\'" + serialNum + "\'");
            statement = con.createStatement();
            statement.execute("DELETE FROM units_has_products where products_name=\'" + name + "\' AND products_serialNum=\'" + serialNum + "\'");

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }
    }

    public static List<ProductType> searchProduct(String value) throws SQLException {

        List<ProductType> Related_Products = new ArrayList<ProductType>();
        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM products WHERE name LIKE \'" + value + "\' OR description LIKE \'" + value + "\' OR serialNum LIKE \'" + value + "\' OR supplierName LIKE \'" + value + "\' OR supplierSurname LIKE \'" + value + "\'");
            while (resultSet.next()) {
                
                product = new ProductType(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("serialNum"), resultSet.getString("producttype"), resultSet.getString("size"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getFloat("weight"), resultSet.getBoolean("availability"), resultSet.getString("nameOfUnit"), resultSet.getString("supplierName"), resultSet.getString("supplierSurname"));
                Related_Products.add(product);

            }


            return Related_Products;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static List<ProductType> getAllProducts() throws SQLException {


        List<ProductType> Product_List = new ArrayList<ProductType>();
        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM products");

        while (resultSet.next()) {
            product = new ProductType(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("serialNum"), resultSet.getString("producttype"), resultSet.getString("size"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getFloat("weight"), resultSet.getBoolean("availability"), resultSet.getString("nameOfUnit"), resultSet.getString("supplierName"), resultSet.getString("supplierSurname"));

            Product_List.add(product);
        }

        return Product_List;
    }

    public static List<ProductType> getAllProducts(String storageName) throws SQLException {

        List<ProductType> Product_List = new ArrayList<ProductType>();
        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        try {

            con = UserDatabase.initiateConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT p.name,p.description,p.serialNum,p.productType,p.size,p.quantity,p.price,p.availability,p.weight,p.nameOfUnit,p.supplierName,p.supplierSurname FROM products p,units_has_products u WHERE u.products_name=p.name AND u.products_serialNum= p.serialNum AND u.units_name=\'" + storageName + "\'");


            while (resultSet.next()) {
                product = new ProductType(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("serialNum"), resultSet.getString("producttype"), resultSet.getString("size"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getFloat("weight"), resultSet.getBoolean("availability"), resultSet.getString("nameOfUnit"), resultSet.getString("supplierName"), resultSet.getString("supplierSurname"));

                Product_List.add(product);
            }

            return Product_List;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static List<ProductType> getAllProducts(String name, String surname) throws SQLException {

        List<ProductType> Product_List = new ArrayList<ProductType>();
        ProductType product = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        try {

            con = UserDatabase.initiateConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products WHERE supplierName=\'" + name + "\' AND supplierSurname=\'" + surname + "\'");


            while (resultSet.next()) {
                product = new ProductType(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("serialNum"), resultSet.getString("producttype"), resultSet.getString("size"), resultSet.getInt("quantity"), resultSet.getInt("price"), resultSet.getFloat("weight"), resultSet.getBoolean("availability"), resultSet.getString("nameOfUnit"), resultSet.getString("supplierName"), resultSet.getString("supplierSurname"));

                Product_List.add(product);
            }

            return Product_List;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static void insertProduct(ProductType Product) throws SQLException {

        ProductType product = Product;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {

            statement.executeUpdate("INSERT INTO products (name, description, serialNum, producttype, size, quantity, price, availability, weight, nameOfUnit, supplierName, supplierSurname) \n"
                    + "VALUES (\'" + Product.getName() + "\',\'" + Product.getDescription() + "\',\'" + Product.getSerialNum() + "\',\'" + Product.getProductType() + "\',\'\n"
                    + Product.getSize() + "\'," + Product.getQuantity() + "," + Product.getPrice() + "," + (Product.getAvailability() == true ? 1 : 0)
                    + "," + Product.getWeight() + ",\'" + Product.getNameOfUnit() + "\',\'" + Product.getSupplierName() + "\',\'" + Product.getSupplierSurname() + "\')");

            statement = con.createStatement();
            statement.executeUpdate("INSERT INTO units_has_products (units_name, products_name, products_serialNum) \n"
                    + "VALUES (\'" + Product.getNameOfUnit() + "\', \'" + Product.getName() + "\', \'" + product.getSerialNum() + "\')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateProduct(String Name, String Description, String Producttype, String Size, int Quantity, float Price, float Weight, Boolean Availability, String NameOfUnit, String SupplierName, String SupplierSurname, String SerialNum) throws SQLException {


        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            statement.executeUpdate("update products set name=\""
                    + Name + "\", description=\"" + Description + "\",productType=\"" + Producttype + "\",size=\"" + Size + "\", quantity=" + Quantity + ", price=" + Price + ",weight=" + Weight + ",availability=" + (Availability == true ? 1 : 0) + ",nameOfUnit =\"" + NameOfUnit + "\",supplierName =\"" + SupplierName + "\" where serialNum =\"" + SerialNum + "\"");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static StorageUnit getStorage(String Name) throws SQLException {

        StorageUnit unit = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            resultSet = statement.executeQuery("SELECT * FROM units WHERE name =\"" + Name + "\";");
            if (resultSet.next()) {

                unit = new StorageUnit(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("location"), resultSet.getBoolean("open"));

                return unit;

            } else {
                return null;
            }
        } catch (SQLException exep) {
            return null;
        }
    }

    public static List<StorageUnit> getAllStorages() throws SQLException {


        List<StorageUnit> Unit_List = new ArrayList<StorageUnit>();
        StorageUnit unit = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM units");
        try {
            while (resultSet.next()) {
                unit = new StorageUnit(resultSet.getString("name"), resultSet.getString("description"), resultSet.getString("location"), resultSet.getBoolean("open"));

                Unit_List.add(unit);
            }
            return Unit_List;
        } catch (SQLException exep) {
            return null;
        }
    }

    public static void insertStorage(StorageUnit Unit) throws SQLException {

        StorageUnit unit = Unit;
        Statement statement;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            statement.executeUpdate("INSERT INTO units (name, description, location, open) \n"
                    + "VALUES (\'" + unit.getName() + "\',\'" + unit.getDescription() + "\',\'" + unit.getLocation() + "\'," + (unit.getOpen() == true ? 1 : 0) + ")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateStorage(String Description, String Location, Boolean Open, String Name) throws SQLException {

        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {

            statement.executeUpdate("update units set description=\"" + Description + "\",location =\"" + Location + "\",open=" + (Open == true ? 1 : 0) + " where name =\"" + Name + "\"");

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
        }

    }

    public static void deleteStorage(String Name) throws SQLException {
        ProductType product = null;
        StorageUnit unit = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();

        resultSet = statement.executeQuery("SELECT * FROM units_has_products WHERE units_name = \'" + Name + "\'");
        if (!resultSet.next()) {
            statement.execute("DELETE FROM units WHERE name=\'" + Name + "\'");
        }



    }

    public static Supplier getSupplier(String Name, String Surname) throws SQLException {


        List<Supplier> Supplier_List = new ArrayList<Supplier>();
        Supplier supplier = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();

        try {
            resultSet = statement.executeQuery("SELECT * FROM suppliers where name=\"" + Name + "\" and surname=\"" + Surname + "\"");
            if (resultSet.next()) {

                supplier = new Supplier(resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("address"), resultSet.getString("SSN"));

                return supplier;

            } else {
                return null;
            }
        } catch (SQLException exep) {
            return null;
        }
    }

    public static List<Supplier> getAllSuppliers() throws SQLException {


        List<Supplier> Supplier_List = new ArrayList<Supplier>();
        Supplier supplier = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM suppliers");
        try {
            while (resultSet.next()) {
                supplier = new Supplier(resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("address"), resultSet.getString("SSN"));

                Supplier_List.add(supplier);
            }
            return Supplier_List;
        } catch (SQLException exep) {
            return null;
        }
    }

    public static void insertSupplier(Supplier Supplier) throws SQLException {

        Supplier supplier = Supplier;
        Statement statement;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            statement.executeUpdate("INSERT INTO suppliers (name,surname, address, SSN) \n"
                    + "VALUES(\'" + supplier.getName() + "\',\'" + supplier.getSurname() + "\',\'" + supplier.getAddress() + "\',\'" + supplier.getSSN() + "\')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateSupplier(String Address, String SSN, String Name, String Surname) throws SQLException {

        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            statement.executeUpdate("update suppliers set address=\"" + Address + "\",SSN=\"" + SSN + "\" where name=\"" + Name + "\" and surname=\"" + Surname + "\"");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }



    }

    public static void deleteSupplier(String Name, String Surname) throws SQLException {
        ProductType product = null;
        StorageUnit unit = null;
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();
        statement = con.createStatement();
        try {
            statement.executeUpdate("UPDATE products set supplierName=NULL, supplierSurname=NULL WHERE supplierName =\'" + Name + "\' AND supplierSurname=\'" + Surname + "\'");
            statement.executeUpdate("DELETE FROM suppliers WHERE name =\'" + Name + "\' AND surname=\'" + Surname + "\'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}