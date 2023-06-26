/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBconnection {
     public static  Connection getConnection(){
        Connection con=null;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            // con =DriverManager.getConnection("jdbc:mysql://localhost:3306/eventuserapplication", "root", "111111");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

             System.out.println("Connected Successfully");
        }
        catch(Exception e){
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
         return con;
        
    }
}
