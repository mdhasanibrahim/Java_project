import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


class ProfileFrame extends JFrame implements ActionListener{

//JTable adminTable;

private JLabel profileLabel,nameLabel,ignLabel,countryLabel,emailLabel,totalGamePlayedLabel,totalWinningLabel,totalKillLabel;
private JLabel nl,ignl,cl,el,tgpl,twl,tkl;
private JTextField nameTf,ignTf,countryTf;
private JButton exitButton,backButton;
private Container c4;
private Font f,f1;
Profile p;
Save s;

	ProfileFrame(Save s,Profile p){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(600,200,600,800);
              this.setTitle("ProfileFrame");
			  setResizable(false);
			  this.p=p;
			  this.s=s;
			  c4=this.getContentPane();
	          c4.setLayout(null);
	          c4.setBackground(new Color(110,155,40));
			  
			  String name = p.getName();
             String ign = p.getIgn();
			 String country = p.getCountry();
             String email = p.getEmail();
             int totalgameplayed = p.getTotalGamePlayed();
			 int totalwinning = p.getTotalWinning();
			 int totalkill = p.getTotalKill();
			 String totalgp=String.valueOf(totalgameplayed);
			 String totalw=String.valueOf(totalwinning);
			 String totalk=String.valueOf(totalkill);
			 System.out.println("T :"+totalk);
			 System.out.println("T :"+totalw);
			 System.out.println("T :"+totalgp);
			  
			  f=new Font("Comic San MS",Font.ITALIC,50);
			  f1=new Font("Comic San MS",Font.BOLD,18);
			  
			  //databaseClass dbObj=new databaseClass();
			  //String name=new String(pf.getPassword());
			  
			  profileLabel=new JLabel("***Profile***");
			  profileLabel.setBounds(170,80,600,50);
			  profileLabel.setFont(f);
			  c4.add(profileLabel);
			  
			  nameLabel=new JLabel("Name:    ");
			  nameLabel.setBounds(50,180,200,50);
			  nameLabel.setFont(f1);
			  c4.add(nameLabel);
			  
			  nl=new JLabel(name);
			  nl.setBounds(300,180,200,50);
			  nl.setFont(f1);
			  c4.add(nl);
			  
			  ignLabel=new JLabel("IGN:");
			  ignLabel.setBounds(50,245,200,50);
			  ignLabel.setFont(f1);
			  c4.add(ignLabel);
			  
			  ignl=new JLabel(ign);
			  ignl.setBounds(300,245,200,50);
			  ignl.setFont(f1);
			  c4.add(ignl);
			  
			  countryLabel=new JLabel("Country:");
			  countryLabel.setBounds(50,300,200,50);
			  countryLabel.setFont(f1);
			  c4.add(countryLabel);
			  
			  cl=new JLabel(country);
			  cl.setBounds(300,300,200,50);
			  cl.setFont(f1);
			  c4.add(cl);
			  
			  emailLabel=new JLabel("Email:");
			  emailLabel.setBounds(50,370,200,50);
			  emailLabel.setFont(f1);
			  c4.add(emailLabel);
			  
			  el=new JLabel(email);
			  el.setBounds(300,370,200,50);
			  el.setFont(f1);
			  c4.add(el);
			  
			  totalGamePlayedLabel=new JLabel("Total Game Played:");
			  totalGamePlayedLabel.setBounds(50,430,200,50);
			  totalGamePlayedLabel.setFont(f1);
			  c4.add(totalGamePlayedLabel);
			  
			  tgpl=new JLabel(totalgp);
			  tgpl.setBounds(300,430,200,50);
			  tgpl.setFont(f1);
			  c4.add(tgpl);
			  
			  totalWinningLabel=new JLabel("Total Winning:");
			  totalWinningLabel.setBounds(50,490,200,50);
			  totalWinningLabel.setFont(f1);
			  c4.add(totalWinningLabel);
			  
			  twl=new JLabel(totalw);
			  twl.setBounds(300,490,200,50);
			  twl.setFont(f1);
			  c4.add(twl);
			  
			  totalKillLabel=new JLabel("Total Kill:");
			  totalKillLabel.setBounds(50,550,200,50);
			  totalKillLabel.setFont(f1);
			  c4.add(totalKillLabel);
			  
			  tkl=new JLabel(totalk);
			  tkl.setBounds(300,550,200,50);
			  tkl.setFont(f1);
			  c4.add(tkl);
			  
			  
			  backButton=new JButton("Back");
		      backButton.setBounds(200,650,200,40);
              c4.add(backButton);
			  
			 backButton.addActionListener(this);
			  
              setVisible(true);			 			  
  }
  
 public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command == "Back")
		{
			
			MainFrame mf=new MainFrame(s);
			mf.setVisible(true);
			this.dispose();
		
		}
		
		
 
		
		
		/*else(command == "Exit Game"){
			System.out.println("Exit Game Button pressed");
			System.exit(0);
		}*/
	 
 }
}
 