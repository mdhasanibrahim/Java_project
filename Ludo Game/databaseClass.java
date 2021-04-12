import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



 class databaseClass
{
    Connection con;
    Statement stat;
    ResultSet rs;
    databaseClass()
    {
		
        try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fp","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
    }
        //return boolean
    public Boolean checkLogin(String uname,String pwd)
    {
        try {        
			 
			String sql= "select * from admin where Email='"+uname+"' and Password='"+pwd+"'"; 	
    
            rs=stat.executeQuery(sql);
            if(rs.next())
            {
                //TRUE if the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating: "+e);
            return false;
        }
		
    }
 
}

