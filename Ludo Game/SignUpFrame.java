import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



class SignUpFrame extends JFrame implements ActionListener{


private JLabel createLabel,logInLabel,imageLabel;
private JTextField nameTf,ignTf,countryTf,emailTf,passTf;
private JButton signUpButton,logInButton2;
private Container c3;
private ImageIcon signUpImage;

	SignUpFrame(){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(600,200,600,800);
              this.setTitle("SignUpFrame");
			  setResizable(false);
			  
			  c3=this.getContentPane();
	          c3.setLayout(null);
	          c3.setBackground(new Color(255,255,0));
			  
			  signUpImage=new ImageIcon("signUp.png");
			  imageLabel=new JLabel("",signUpImage,JLabel.CENTER);
			  imageLabel.setBounds(236,10,130,130);
			  c3.add(imageLabel);
			  
			  createLabel=new JLabel("-------------------------------- Create New Account --------------------------------");
			  createLabel.setBounds(105,140,400,50);
			  c3.add(createLabel);
			  
			  nameTf=new JTextField("Name...");
			  nameTf.setBounds(190,200,200,50);
			  c3.add(nameTf);
			  
			  ignTf=new JTextField("IGN...");
			  ignTf.setBounds(190,270,200,50);
			  c3.add(ignTf);
			  
			  countryTf=new JTextField("Country...");
			  countryTf.setBounds(190,340,200,50);
			  c3.add(countryTf);
			  			  
			  emailTf=new JTextField("Email...");
			  emailTf.setBounds(100,410,380,50);
			  c3.add(emailTf);
			  
			  passTf=new JTextField("Password...");
			  passTf.setBounds(100,480,380,50);
			  c3.add(passTf);
			  
              signUpButton=new JButton("Sign Up");
			  signUpButton.setBounds(190,550,200,50);
              c3.add(signUpButton);
			  
			  createLabel=new JLabel("Already have an Account?");
			  createLabel.setBounds(190,620,200,50);
			  c3.add(createLabel);
			  
			  logInButton2=new JButton("LogIn");
			  logInButton2.setBounds(360,625,75,40);
              c3.add(logInButton2);
		
		      signUpButton.addActionListener(this);
              logInButton2.addActionListener(this);
			  
              setVisible(true);			 			  
  }
  

  public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command == "Sign Up"){
			try {
            Class.forName("com.mysql.jdbc.Driver");
            
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fp", "root", "");
			
            Statement stmt = con.createStatement();
            
            
            String Name = nameTf.getText();
            String Ign = ignTf.getText();
			String Country = countryTf.getText();
			String Email = emailTf.getText();
			String Password = passTf.getText();
			
            


            if(Name==null||Name.isEmpty()||Ign==null||Ign.isEmpty()|| Country==null||Country.isEmpty()|| Email==null||Email.isEmpty()|| Password==null||Password.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Sign Up Unsuccessfull !!!");
			}
			else 
			{
			 String query = "INSERT INTO admin (Name,Ign,Country,Email,Password) VALUES ('"+Name+"', '"+Ign+"', '"+Country+"','"+Email+"','"+Password+"')";            
            //System.out.println(query);
            if(stmt.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(this, "Sign Up Successfull !!!");
            } 
			}
			
			
          
		     
          } 
		catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sign Up Unsuccessfull !!!");
              }
			
		}
		if(command == "LogIn"){
			System.out.println("LogIn Button pressed");
			new LoginFrame().setVisible(true);
			this.dispose();
		}
	}

}

