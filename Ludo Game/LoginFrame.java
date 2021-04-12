import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



class LoginFrame extends JFrame implements ActionListener{


private JLabel orLabel;
private JTextField tf;
private JPasswordField pf;
private JButton logInButton,createButton;
private Container c2;

	LoginFrame(){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(600,200,600,800);
              this.setTitle("LoginFrame");
			  setResizable(false);
			  
			  c2=this.getContentPane();
	          c2.setLayout(null);
	          c2.setBackground(new Color(51,204,255));
			  
			  
			  tf=new JTextField("Email.....");
			  tf.setBounds(190,200,200,50);
			  c2.add(tf);
			  
			  
			  pf=new JPasswordField("Password.....");
			  pf.setBounds(190,270,200,50);
			  pf.setEchoChar('*');
			  c2.add(pf);
			  
			  logInButton=new JButton("LogIn");
			  logInButton.setBounds(190,340,200,50);
              c2.add(logInButton);	

              orLabel=new JLabel("---------------------- OR ----------------------");
			  orLabel.setBounds(190,450,200,50);
			  c2.add(orLabel);
			  
              createButton=new JButton("Create an Account");
			  createButton.setBounds(190,550,200,50);
              c2.add(createButton);
		
		      logInButton.addActionListener(this);
              createButton.addActionListener(this);
			  
              setVisible(true);			 			  
  }
  

    public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command == "LogIn"){
			databaseClass dbObj=new databaseClass();
 
                String pwd=new String(pf.getPassword());
				String user=new String(tf.getText());
               
                System.out.println("Email,Pwd:"+user+","+pwd);
 
                //The entered username and password are sent via "checkLogin()" which return boolean
                if(dbObj.checkLogin(user, pwd))
                {
                   Save s=new Save(user,pwd);
				   MainFrame m=new MainFrame(s);
                   m.setVisible(true);
			       this.dispose();
                }
                else
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password!!!","LogIn Failed!!",
                                        JOptionPane.ERROR_MESSAGE);
                }
		}
		if(command == "Create an Account"){
			System.out.println("Create an Account Button pressed");
			new SignUpFrame().setVisible(true);
			this.dispose();
		}
	} 

}