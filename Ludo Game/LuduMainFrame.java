import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



class LuduMainFrame extends JFrame{
	private JLabel createNewAccountLabel;
    private JButton LoginButton1,CreateButton1;
    private Container c1;
	LuduMainFrame()
	{
		super("LuduMainFrame");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,200,600,800);
		setResizable(false);
	    
		c1=this.getContentPane();
	    c1.setLayout(null);
	    c1.setBackground(new Color(150,204,100));
		
		LoginButton1=new JButton("LogIn");
		LoginButton1.setBounds(150,400,300,60);
        c1.add(LoginButton1);
		
		createNewAccountLabel=new JLabel("Create a new Account?");
	    createNewAccountLabel.setBounds(220,500,150,20);
		c1.add(createNewAccountLabel);
		
		CreateButton1=new JButton("...");
		CreateButton1.setBounds(380,500,20,20);
        c1.add(CreateButton1);
		
        LoginButton1.addActionListener(new ButtonSensor(this));
        CreateButton1.addActionListener(new ButtonSensor(this));
		
        setVisible(true);		
	}
	/*public void paint(Graphics g)
	{
		g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
	
        g.drawString(msg,100,40);
	}*/
	
}