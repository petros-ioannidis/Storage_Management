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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import storage.users.User;
import storage.users.UserRole;

/**
 *
 * @author zbs
 */
public class RoleDatabase {
    
    private static String connectionUrl = "jdbc:mysql://localhost:3306/storagewarsrolessdb?zeroDateTimeBehavior=convertToNull";
    private static String connectionUser = "root";
    private static String connectionPassword = "test";

    public static Connection initiateConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(RoleDatabase.connectionUrl, RoleDatabase.connectionUser, RoleDatabase.connectionPassword);
            return con;
        } catch (SQLException exep) {
            exep.printStackTrace();
            return null;
        } catch (ClassNotFoundException exep) {
            exep.printStackTrace();
            return null;
        }
    }
    
   
}
