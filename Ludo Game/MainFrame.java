import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



class MainFrame extends JFrame implements ActionListener{
	private JButton startGameButton,profileButton,logOutButton,exitGameButton;
	private Container c4;
	Save s;

	MainFrame(Save s){
		
		this.s=s;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,200,600,800);
        this.setTitle("MainFrame");
		setResizable(false);
			  
		c4=this.getContentPane();
	    c4.setLayout(null);
	    c4.setBackground(new Color(100,150,70));
		
		startGameButton=new JButton("Start Game");
		startGameButton.setBounds(190,340,200,50);
        c4.add(startGameButton);
		
		profileButton=new JButton("Profile");
		profileButton.setBounds(190,410,200,50);
        c4.add(profileButton);
		
		logOutButton=new JButton("Log Out");
		logOutButton.setBounds(190,480,200,50);
        c4.add(logOutButton);
		
		exitGameButton=new JButton("Exit Game");
		exitGameButton.setBounds(190,550,200,50);
        c4.add(exitGameButton);
		
		startGameButton.addActionListener(this);
        profileButton.addActionListener(this);
		logOutButton.addActionListener(this);
        exitGameButton.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command == "Start Game"){
			System.out.println("Start Game Button pressed");
			GameFrame gf=new GameFrame(s);
			gf.setVisible(true);
			this.dispose();
			
		}
		if(command == "Profile"){
			System.out.println("Profile Button pressed");
			MyProfile mp=new MyProfile(s);
			this.dispose();
			
		}
		
		if(command == "Log Out"){
			System.out.println("Log Out Button pressed");
			new LuduMainFrame().setVisible(true);
			this.dispose();
		}
		
		if(command == "Exit Game"){
			System.out.println("Exit Game Button pressed");
			System.exit(0);
		}
	}

	
}
	
	
