package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Login;

public class LoginDAO {
      public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException {
    	  
    	  // 1.get the details from Login file
    	  String username=l.getUsername();
    	  String password=l.getpassword();
    	  // 2.JDBC connection
    	  ConnectionManager cm=new ConnectionManager();
    	  Connection con=cm.establishConnection();
    	  // 3. create the statement   create class create statement execute query
    	   Statement st=con.createStatement();
    	   // 4. write and Execute the query
    	  ResultSet rt= st.executeQuery("select * from login_table"); //it will store all the return rows from login_table
    	   // 5. check the Username and password
    	  while(rt.next()) {
    		  if(username.equals(rt.getString("username")) && password.equals(rt.getString("password"))) {
    		  		cm.connectionClose();;
    		  		return true;
    		  		
    			  }
    	       
    	  
    	  }
    	  cm.connectionClose();
    	  return false;
    }
}
