/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tipu
 */
public class MySQL {

    Connection con = null;
    String username = "root";
    String password = "12345678";

    public Connection getCon(){
        
        try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud",username,password);
        } catch(Exception e){
        }
        return con;
     
    }
    
    
}
