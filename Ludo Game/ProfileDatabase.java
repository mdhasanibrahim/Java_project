import java.sql.*;
import javax.swing.JOptionPane;


public class ProfileDatabase {
    Connection con;
	Statement stat;
	ResultSet rs;
        Save s;
	public ProfileDatabase(Save s){
            this.s=s;
            String user= s.getuser();
        String pwd= s.getpwd(); 
			ResultSet rs;
       
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fp","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
	
    
        try {        
			 
	       String sql= "select * from admin where Email='"+user+"' and Password='"+pwd+"'"; 	
    
            rs=stat.executeQuery(sql);
            while(rs.next()){
             String name = rs.getString("Name");
             String ign = rs.getString("Ign");
			 String country = rs.getString("country");
             String email = rs.getString("Email");
             int totalgameplayed = rs.getInt("TotalGameplayed");
			 int totalwinning = rs.getInt("TotalWinning");
			 int totalkill = rs.getInt("TotalKill");
             
             Profile p = new Profile(name, ign,country,email,totalgameplayed,totalwinning,totalkill);
             ProfileFrame sp = new ProfileFrame(s,p);
            }
            
        } catch (Exception e) {
          
            System.out.println("error while validating: "+e);
        }
}
        
    
}

