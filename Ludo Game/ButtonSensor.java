import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;



class ButtonSensor implements ActionListener{
	LuduMainFrame objectOfLuduMainFrame;
	public ButtonSensor(LuduMainFrame objectOfLuduMainFrame){
		this.objectOfLuduMainFrame=objectOfLuduMainFrame;
	}
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command == "LogIn"){
			System.out.println("LogIn Button pressed");
			new LoginFrame().setVisible(true);
			objectOfLuduMainFrame.dispose();
		}
		if(command == "..."){
			System.out.println("... Button pressed");
			new SignUpFrame().setVisible(true);
			objectOfLuduMainFrame.dispose();
		}
	}
}



