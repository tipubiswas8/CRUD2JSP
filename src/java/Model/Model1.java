/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Beans.UsersBeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tipu
 */
public class Model1 {
   
    public static Connection getCon(){
        
    Connection con = null;
    String username = "root";
    String password = "12345678";
        try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud2",username,password);
        } catch(Exception e){
            System.out.println(e);
        }
        return con;   
    }
    public static int save(UsersBeans aaa){
        int status =0;
        try {
        String quary = "insert into crud2.user2 (name, password, email, country) values (?,?,?,?)";
        Connection connection = Model1.getCon();
        PreparedStatement prestmt = connection.prepareStatement(quary);
        prestmt.setString(1, aaa.getName());
        prestmt.setString(2, aaa.getPassword());
        prestmt.setString(3, aaa.getEmail());
        prestmt.setString(4, aaa.getCountry());
        status=prestmt.executeUpdate();
			
        connection.close();
	}catch(Exception ex)
        {ex.printStackTrace();}
		
	return status;
    }
    
    public static int update(){
        int status = 0;
        
        return status;
        
    }
    public static void read(UsersBeans ub){
        
        try {
        Connection connec = Model1.getCon();
        PreparedStatement ps = connec.prepareStatement("select* from crud2.user2");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            ub.setId(rs.getInt(1));
            ub.setName(rs.getString(2));
            ub.setPassword(rs.getString(3));
            ub.setEmail(rs.getString(4));
            ub.setCountry(rs.getString(5));
        }
        }
        catch (Exception ee) {
        ee.printStackTrace();
        }
    }
}
