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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tipu
 */
public class Model {
   
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
    public static int create(UsersBeans aaa){
        int status =0;
        try {
        String quary = "insert into crud2.user2 (name, password, email, country) values (?,?,?,?)";
        Connection connection = Model.getCon();
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
    
    public static int update(UsersBeans user){
        int status = 0;
        
        try {
            Connection conn = Model.getCon();
            PreparedStatement st = conn.prepareStatement("update crud2.user2 set name=?,password=?,email=?,country=? where id=?");
            
            st.setString(1, user.getName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setString(4, user.getCountry());
            st.setInt(5, user.getId());
            status = st.executeUpdate();
            
            conn.close();
        }
        catch (Exception e) {
            
        }
        return status;
    }
    public static int delete(int userid){
        
        try {
            String quary = "delete from crud2.user2 where id=?";
            Connection con = Model.getCon();
            PreparedStatement pres = con.prepareStatement(quary);
            pres.setInt(1, userid);
            pres.executeUpdate();
        }
        catch (Exception e)
        {
        }
        return userid;
            }
        
        
    public static List<UsersBeans> read(){
        
        List<UsersBeans> userlist = new ArrayList<UsersBeans>();
        
        try {
        Connection connec = Model.getCon();
        PreparedStatement ps = connec.prepareStatement("select* from crud2.user2");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            UsersBeans ub = new UsersBeans();
            ub.setId(rs.getInt(1));
            ub.setName(rs.getString(2));
            ub.setPassword(rs.getString(3));
            ub.setEmail(rs.getString(4));
            ub.setCountry(rs.getString(5));
            userlist.add(ub);
            
        }
        connec.close();
        }
        catch (Exception ee) {
        ee.printStackTrace();
        }
        return userlist;
    }
    public static UsersBeans updateById(int i){
       
        UsersBeans ub = new UsersBeans();
        try { 
        Connection con = Model.getCon();
        String quary = "select * from crud2.user2 where id=?"; 
        PreparedStatement ps = con.prepareStatement(quary);
        ps.setInt(1, i);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        ub.setId(rs.getInt(1));
        ub.setName(rs.getString(2));
        ub.setPassword(rs.getString(3));
        ub.setEmail(rs.getString(4));
        ub.setCountry(rs.getString(5));
        }
        con.close();
    }
        catch (Exception e) {
            
        }
        return ub;
}
}