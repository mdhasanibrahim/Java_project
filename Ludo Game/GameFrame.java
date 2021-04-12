import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class GameFrame extends JFrame implements ActionListener{

    Save s;
	
	int r=-1;
	int flagRandom=0;
	int turn=1;
	
	int redPathTracker1=0,redPathTracker2=0,redPathTracker3=0,redPathTracker4=0;
	int greenPathTracker1=0,greenPathTracker2=0,greenPathTracker3=0,greenPathTracker4=0;
	int yellowPathTracker1=0,yellowPathTracker2=0,yellowPathTracker3=0,yellowPathTracker4=0;
	int bluePathTracker1=0,bluePathTracker2=0,bluePathTracker3=0,bluePathTracker4=0;
	
	JLabel turnLabel;
	
	JButton buttons[]= new JButton[120];
	JButton turnButton;
	
	Container c5;
	
	ImageIcon exitImg,diceimg1,diceimg2,diceimg3,diceimg4,diceimg5,diceimg6;
	ImageIcon playerBlue,playerGreen,playerRed,playerYellow;
	ImageIcon redDouble,greenDouble,yellowDouble,blueDouble;
	ImageIcon redTriple,greenTriple,yellowTriple,blueTriple;
	ImageIcon redQuadruple,greenQuadruple,yellowQuadruple,blueQuadruple;
	
	Font f;
	
	int pathRed1[]={82,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,46,45,44,43,42,93};
	int pathRed2[]={83,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,46,45,44,43,42,93};
	int pathRed3[]={84,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,46,45,44,43,42,93};
	int pathRed4[]={85,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,46,45,44,43,42,93};
	int pathGreen1[]={74,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,25,26,27,28,29,91};
	int pathGreen2[]={75,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,25,26,27,28,29,91};
	int pathGreen3[]={76,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,25,26,27,28,29,91};
	int pathGreen4[]={77,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,25,26,27,28,29,91};
	int pathYellow1[]={78,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,7,8,9,10,11,90};
	int pathYellow2[]={79,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,7,8,9,10,11,90};
	int pathYellow3[]={80,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,7,8,9,10,11,90};
	int pathYellow4[]={81,13,14,15,16,17,54,55,56,57,58,59,65,71,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,7,8,9,10,11,90};
	int pathBlue1[]={86,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,64,63,62,61,60,92};
	int pathBlue2[]={87,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,64,63,62,61,60,92};
	int pathBlue3[]={88,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,64,63,62,61,60,92};
	int pathBlue4[]={89,70,69,68,67,66,48,49,50,51,52,53,47,41,40,39,38,37,36,35,34,33,32,31,30,24,18,19,20,21,22,23,5,4,3,2,1,0,6,12,13,14,15,16,17,54,55,56,57,58,59,65,64,63,62,61,60,92};
	
	GameFrame(Save s){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,200,600,800);
        this.setTitle("GameFrame");
		setResizable(false);
		
        this.s=s;
		
		c5=this.getContentPane();
	    c5.setLayout(null);
	    c5.setBackground(new Color(51,204,255));
        
		f=new Font("Arial",Font.BOLD,50);
		
		exitImg=new ImageIcon("exit.png");
		diceimg1=new ImageIcon("1.png");
		diceimg2=new ImageIcon("2.png");
		diceimg3=new ImageIcon("3.png");
		diceimg4=new ImageIcon("4.png");
		diceimg5=new ImageIcon("5.png");
		diceimg6=new ImageIcon("6.png");
		playerBlue=new ImageIcon("blue.png");
		playerGreen=new ImageIcon("green.png");
		playerRed=new ImageIcon("red.png");
		playerYellow=new ImageIcon("yellow.png");
		
		redDouble=new ImageIcon("redDouble.png");
		greenDouble=new ImageIcon("greenDouble.png");
		yellowDouble=new ImageIcon("yellowDouble.png");
		blueDouble=new ImageIcon("blueDouble.png");
		
		redTriple=new ImageIcon("redTriple.png");
		greenTriple=new ImageIcon("greenTriple.png");
		yellowTriple=new ImageIcon("yellowTriple.png");
		blueTriple=new ImageIcon("blueTriple.png");
		
		redQuadruple=new ImageIcon("redQuadruple.png");
		greenQuadruple=new ImageIcon("greenQuadruple.png");
		yellowQuadruple=new ImageIcon("yellowQuadruple.png");
		blueQuadruple=new ImageIcon("blueQuadruple.png");
		
		
		    int i=0;
		
            for(i=0;i<110;i++)
            buttons[i]=new JButton();
            turnButton=new JButton();		
	
		    int x = 250;
			int y = 70;
                   
				   buttons[0].setBounds(x,y, 30, 30);
				   buttons[1].setBounds(x,y+30, 30, 30);
				   buttons[2].setBounds(x,y+60, 30, 30);
				   buttons[3].setBounds(x,y+90, 30, 30);
				   buttons[4].setBounds(x,y+120, 30, 30);
				   buttons[5].setBounds(x,y+150, 30, 30);
				   buttons[6].setBounds(x+30,y, 30, 30);
				   buttons[7].setBounds(x+30,y+30, 30, 30);
				   buttons[8].setBounds(x+30,y+60, 30, 30);
				   buttons[9].setBounds(x+30,y+90, 30, 30);
				   buttons[10].setBounds(x+30,y+120, 30, 30);
				   buttons[11].setBounds(x+30,y+150, 30, 30);
                   buttons[12].setBounds(x+60,y, 30, 30);				   
				   buttons[13].setBounds(x+60,y+30, 30, 30);
				   buttons[14].setBounds(x+60,y+60, 30, 30);
				   buttons[15].setBounds(x+60,y+90, 30, 30);
				   buttons[16].setBounds(x+60,y+120, 30, 30);
				   buttons[17].setBounds(x+60,y+150, 30, 30);
				   
			 x = 70;
			 y = 250;	   
				   	   
				   buttons[18].setBounds(x,y, 30, 30);
				   buttons[19].setBounds(x+30,y, 30, 30);
				   buttons[20].setBounds(x+60,y, 30, 30);
				   buttons[21].setBounds(x+90,y, 30, 30);
				   buttons[22].setBounds(x+120,y, 30, 30);
				   buttons[23].setBounds(x+150,y, 30, 30);
				   buttons[24].setBounds(x,y+30, 30, 30);
				   buttons[25].setBounds(x+30,y+30, 30, 30);
				   buttons[26].setBounds(x+60,y+30, 30, 30);
				   buttons[27].setBounds(x+90,y+30, 30, 30);
				   buttons[28].setBounds(x+120,y+30, 30, 30);
				   buttons[29].setBounds(x+150,y+30, 30, 30);
				   buttons[30].setBounds(x,y+60, 30, 30);
				   buttons[31].setBounds(x+30,y+60, 30, 30);
				   buttons[32].setBounds(x+60,y+60, 30, 30);
				   buttons[33].setBounds(x+90,y+60, 30, 30);
				   buttons[34].setBounds(x+120,y+60, 30, 30);
				   buttons[35].setBounds(x+150,y+60, 30, 30);
				   
			 x = 250;
			 y = 340;	   
				   
				   buttons[36].setBounds(x,y, 30, 30);
				   buttons[37].setBounds(x,y+30, 30, 30);
				   buttons[38].setBounds(x,y+60, 30, 30);
				   buttons[39].setBounds(x,y+90, 30, 30);
				   buttons[40].setBounds(x,y+120, 30, 30);
				   buttons[41].setBounds(x,y+150, 30, 30);
				   buttons[42].setBounds(x+30,y, 30, 30);
				   buttons[43].setBounds(x+30,y+30, 30, 30);
				   buttons[44].setBounds(x+30,y+60, 30, 30);
				   buttons[45].setBounds(x+30,y+90, 30, 30);
				   buttons[46].setBounds(x+30,y+120, 30, 30);
				   buttons[47].setBounds(x+30,y+150, 30, 30);
                   buttons[48].setBounds(x+60,y, 30, 30);				   
				   buttons[49].setBounds(x+60,y+30, 30, 30);
				   buttons[50].setBounds(x+60,y+60, 30, 30);
				   buttons[51].setBounds(x+60,y+90, 30, 30);
				   buttons[52].setBounds(x+60,y+120, 30, 30);
				   buttons[53].setBounds(x+60,y+150, 30, 30);
				   
			 x = 340;
			 y = 250;	   
				   	   
				   buttons[54].setBounds(x,y, 30, 30);
				   buttons[55].setBounds(x+30,y, 30, 30);
				   buttons[56].setBounds(x+60,y, 30, 30);
				   buttons[57].setBounds(x+90,y, 30, 30);
				   buttons[58].setBounds(x+120,y, 30, 30);
				   buttons[59].setBounds(x+150,y, 30, 30);
				   buttons[60].setBounds(x,y+30, 30, 30);
				   buttons[61].setBounds(x+30,y+30, 30, 30);
				   buttons[62].setBounds(x+60,y+30, 30, 30);
				   buttons[63].setBounds(x+90,y+30, 30, 30);
				   buttons[64].setBounds(x+120,y+30, 30, 30);
				   buttons[65].setBounds(x+150,y+30, 30, 30);
				   buttons[66].setBounds(x,y+60, 30, 30);
				   buttons[67].setBounds(x+30,y+60, 30, 30);
				   buttons[68].setBounds(x+60,y+60, 30, 30);
				   buttons[69].setBounds(x+90,y+60, 30, 30);
				   buttons[70].setBounds(x+120,y+60, 30, 30);
				   buttons[71].setBounds(x+150,y+60, 30, 30);
				   
				//Exit button  
				   buttons[72].setBounds(10,10,50,50);
				//Dice button
				   buttons[73].setBounds(70,550,60,60);
				//green home   
				   buttons[74].setBounds(115,115,30,30);
				   buttons[75].setBounds(175,115,30,30);
				   buttons[76].setBounds(115,175,30,30);
				   buttons[77].setBounds(175,175,30,30);
				//yellow home   
				   buttons[78].setBounds(385,115,30,30);
				   buttons[79].setBounds(445,115,30,30);
				   buttons[80].setBounds(385,175,30,30);
				   buttons[81].setBounds(445,175,30,30);
				//red home   
				   buttons[82].setBounds(115,385,30,30);
				   buttons[83].setBounds(175,385,30,30);
				   buttons[84].setBounds(115,445,30,30);
				   buttons[85].setBounds(175,445,30,30);
				//blue home   
				   buttons[86].setBounds(385,385,30,30);
				   buttons[87].setBounds(445,385,30,30);
				   buttons[88].setBounds(385,445,30,30);
				   buttons[89].setBounds(445,445,30,30);
				//center home   
				   buttons[90].setBounds(280,250,30,30);
				   buttons[91].setBounds(250,280,30,30);
				   buttons[92].setBounds(310,280,30,30);
				   buttons[93].setBounds(280,310,30,30);
			    //design   
				   buttons[94].setBounds(100,70,150,30);
				   buttons[95].setBounds(70,70,30,150);
				   buttons[96].setBounds(70,220,150,30);
				   buttons[97].setBounds(220,100,30,150);
				   
				   buttons[98].setBounds(340,70,150,30);
				   buttons[99].setBounds(490,70,30,150);
				   buttons[100].setBounds(370,220,150,30);
				   buttons[101].setBounds(340,100,30,150);
				   
				   buttons[102].setBounds(70,340,30,150);
				   buttons[103].setBounds(100,340,150,30);
				   buttons[104].setBounds(220,370,30,150);
				   buttons[105].setBounds(70,490,150,30);
				   
				   buttons[106].setBounds(370,340,150,30);
				   buttons[107].setBounds(490,370,30,150);
				   buttons[108].setBounds(340,490,150,30);
				   buttons[109].setBounds(340,340,30,150);
				   
				//TurnButton
				   turnButton.setBounds(350,650,75,50);
				   
	//Background color part			   
				   for(i=0;i<72;i++)
				   buttons[i].setBackground(Color.WHITE);
				   
				   for(i=7;i<12;i++)
				   buttons[i].setBackground(Color.YELLOW);
			       buttons[13].setBackground(Color.YELLOW);
				   
				   for(i=42;i<47;i++)
				   buttons[i].setBackground(Color.RED);
			       buttons[40].setBackground(Color.RED);
				   
				   for(i=25;i<30;i++)
				   buttons[i].setBackground(Color.GREEN);
			       buttons[19].setBackground(Color.GREEN);
				   
				   for(i=60;i<65;i++)
				   buttons[i].setBackground(Color.BLUE);
			       buttons[70].setBackground(Color.BLUE);
				   
				   for(i=74;i<78;i++)
				   buttons[i].setBackground(Color.GREEN);
			   
			       for(i=78;i<82;i++)
				   buttons[i].setBackground(Color.YELLOW);
			   
				   for(i=82;i<86;i++)
				   buttons[i].setBackground(Color.RED);
                     
                   for(i=86;i<90;i++)
				   buttons[i].setBackground(Color.BLUE);

                   buttons[90].setBackground(Color.YELLOW);
				   buttons[91].setBackground(Color.GREEN);
				   buttons[92].setBackground(Color.BLUE);
				   buttons[93].setBackground(Color.RED);
				   
				   for(i=94;i<98;i++)
				   buttons[i].setBackground(Color.GREEN);
			   
				   for(i=98;i<102;i++)
				   buttons[i].setBackground(Color.YELLOW);
                     
                   for(i=102;i<106;i++)
				   buttons[i].setBackground(Color.RED);
			   
			       for(i=106;i<110;i++)
				   buttons[i].setBackground(Color.BLUE);
			    
			       turnButton.setBackground(Color.RED); 
				   
        //adding buttons
		
				   for(i=0;i<110;i++)
				   c5.add(buttons[i]);
			       c5.add(turnButton);
		//adding ActionListener to button	   
			       for(i=0;i<90;i++)
				   buttons[i].addActionListener(this);
			   
        //adding image icons
                   buttons[72].setIcon(exitImg);
				   buttons[73].setIcon(diceimg6);
				   
				   for(i=74;i<78;i++)
				   buttons[i].setIcon(playerGreen);
			   
			       for(i=78;i<82;i++)
				   buttons[i].setIcon(playerYellow);
			   
				   for(i=82;i<86;i++)
				   buttons[i].setIcon(playerRed);
                     
                   for(i=86;i<90;i++)
				   buttons[i].setIcon(playerBlue);
			   
		//adding label
		           turnLabel=new JLabel("Turn:::");
			       turnLabel.setBounds(175,650,400,50);
			       turnLabel.setFont(f);
			       c5.add(turnLabel);

            setVisible(true);	  
		
	}
	
    public int randomNum()
    {
		Random rand = new Random();
		//int a=1+rand.nextInt(6);
		int a=6;
		if(a==1)
			buttons[73].setIcon(diceimg1);
		if(a==2)
			buttons[73].setIcon(diceimg2);
		if(a==3)
			buttons[73].setIcon(diceimg3);
		if(a==4)
			buttons[73].setIcon(diceimg4);
		if(a==5)
			buttons[73].setIcon(diceimg5);
		if(a==6)
			buttons[73].setIcon(diceimg6);
		return a;
	}
	
	
	//for red 1 method
	public void red1()
	{
		if(redPathTracker1==0)
				{
					if(flagRandom==6)
					{
						buttons[pathRed1[redPathTracker1]].setIcon(null);
						redPathTracker1=redPathTracker1+1;
						if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
					    }
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
						}
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redQuadruple);
						}
					    else
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.GREEN);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(redPathTracker1!=0 && (57-redPathTracker1>=flagRandom)  && flagRandom>0)
				{
					if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					{
						buttons[pathRed1[redPathTracker1]].setIcon(null);
				        redPathTracker1=redPathTracker1+flagRandom;
					    if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
					    }
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
						}
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
					    }
				    }
					else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
					{
						buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
				        redPathTracker1=redPathTracker1+flagRandom;
					    if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
					    }
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
						}
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
					{
						buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
				        redPathTracker1=redPathTracker1+flagRandom;
					    if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
					    }
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
						}
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed1[redPathTracker1]].getIcon()==redQuadruple)
					{
						buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
				        redPathTracker1=redPathTracker1+flagRandom;
					    if(buttons[pathRed1[redPathTracker1]].getIcon()==playerRed)
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(redDouble);
					    }
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redDouble)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redTriple);
						}
						else if(buttons[pathRed1[redPathTracker1]].getIcon()==redTriple)
						{
							buttons[pathRed1[redPathTracker1]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed1[redPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.GREEN);
				}
	}
	
	//for red 2 method
	public void red2()
	{
		if(redPathTracker2==0)
				{
					if(flagRandom==6)
					{
						buttons[pathRed2[redPathTracker2]].setIcon(null);
						redPathTracker2=redPathTracker2+1;
						if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
					    }
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
						}
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redQuadruple);
						}
					    else
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.GREEN);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(redPathTracker2!=0 && (57-redPathTracker2>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					{
						buttons[pathRed2[redPathTracker2]].setIcon(null);
				        redPathTracker2=redPathTracker2+flagRandom;
					    if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
					    }
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
						}
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
					    }
				    }
					else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
					{
						buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
				        redPathTracker2=redPathTracker2+flagRandom;
					    if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
					    }
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
						}
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
					{
						buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
				        redPathTracker2=redPathTracker2+flagRandom;
					    if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
					    }
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
						}
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed2[redPathTracker2]].getIcon()==redQuadruple)
					{
						buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
				        redPathTracker2=redPathTracker2+flagRandom;
					    if(buttons[pathRed2[redPathTracker2]].getIcon()==playerRed)
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(redDouble);
					    }
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redDouble)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redTriple);
						}
						else if(buttons[pathRed2[redPathTracker2]].getIcon()==redTriple)
						{
							buttons[pathRed2[redPathTracker2]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed2[redPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.GREEN);
				}
	}
	
	//for red 3 method
	public void red3()
	{
		if(redPathTracker3==0)
				{
					if(flagRandom==6)
					{
						buttons[pathRed3[redPathTracker3]].setIcon(null);
						redPathTracker3=redPathTracker3+1;
						if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
					    }
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
						}
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redQuadruple);
						}
					    else
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.GREEN);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(redPathTracker3!=0 && (57-redPathTracker3>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					{
						buttons[pathRed3[redPathTracker3]].setIcon(null);
				        redPathTracker3=redPathTracker3+flagRandom;
					    if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
					    }
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
						}
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
					    }
				    }
					else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
					{
						buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
				        redPathTracker3=redPathTracker3+flagRandom;
					    if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
					    }
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
						}
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
					{
						buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
				        redPathTracker3=redPathTracker3+flagRandom;
					    if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
					    }
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
						}
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed3[redPathTracker3]].getIcon()==redQuadruple)
					{
						buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
				        redPathTracker3=redPathTracker3+flagRandom;
					    if(buttons[pathRed3[redPathTracker3]].getIcon()==playerRed)
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(redDouble);
					    }
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redDouble)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redTriple);
						}
						else if(buttons[pathRed3[redPathTracker3]].getIcon()==redTriple)
						{
							buttons[pathRed3[redPathTracker3]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed3[redPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.GREEN);
				}
	}
	
	//for red 4 method
	public void red4()
	{
		if(redPathTracker4==0)
				{
					if(flagRandom==6)
					{
						buttons[pathRed4[redPathTracker4]].setIcon(null);
						redPathTracker4=redPathTracker4+1;
						if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
					    }
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
						}
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redQuadruple);
						}
					    else
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.GREEN);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(redPathTracker4!=0 && (57-redPathTracker4>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					{
						buttons[pathRed4[redPathTracker4]].setIcon(null);
				        redPathTracker4=redPathTracker4+flagRandom;
					    if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
					    }
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
						}
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
					    }
				    }
					else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
					{
						buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
				        redPathTracker4=redPathTracker4+flagRandom;
					    if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
					    }
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
						}
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
					{
						buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
				        redPathTracker4=redPathTracker4+flagRandom;
					    if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
					    }
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
						}
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
					    }
					}
					else if(buttons[pathRed4[redPathTracker4]].getIcon()==redQuadruple)
					{
						buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
				        redPathTracker4=redPathTracker4+flagRandom;
					    if(buttons[pathRed4[redPathTracker4]].getIcon()==playerRed)
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(redDouble);
					    }
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redDouble)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redTriple);
						}
						else if(buttons[pathRed4[redPathTracker4]].getIcon()==redTriple)
						{
							buttons[pathRed4[redPathTracker4]].setIcon(redQuadruple);
						}
				//for green
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for blue
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
				//for yellow
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
						else if(buttons[pathRed4[redPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							
						}
					    else
					    {
						    buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.GREEN);
				}
	}
	
	//for green 1 method
	public void green1()
	{
		if(greenPathTracker1==0)
				{
					if(flagRandom==6)
					{
						buttons[pathGreen1[greenPathTracker1]].setIcon(null);
						greenPathTracker1=greenPathTracker1+1;
						if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenQuadruple);
						}
					    else
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.YELLOW);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(greenPathTracker1!=0 && (57-greenPathTracker1>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					{
						buttons[pathGreen1[greenPathTracker1]].setIcon(null);
				        greenPathTracker1=greenPathTracker1+flagRandom;
					    if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
					    }
				    }
					else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
					{
						buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
				        greenPathTracker1=greenPathTracker1+flagRandom;
					    if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
					{
						buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
				        greenPathTracker1=greenPathTracker1+flagRandom;
					    if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenQuadruple)
					{
						buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
				        greenPathTracker1=greenPathTracker1+flagRandom;
					    if(buttons[pathGreen1[greenPathTracker1]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenDouble)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen1[greenPathTracker1]].getIcon()==greenTriple)
						{
							buttons[pathGreen1[greenPathTracker1]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen1[greenPathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.YELLOW);
				}
	}
	
	//for green 2 method
	public void green2()
	{
		if(greenPathTracker2==0)
				{
					if(flagRandom==6)
					{
						buttons[pathGreen2[greenPathTracker2]].setIcon(null);
						greenPathTracker2=greenPathTracker2+1;
						if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenQuadruple);
						}
					    else
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.YELLOW);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(greenPathTracker2!=0 && (57-greenPathTracker2>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					{
						buttons[pathGreen2[greenPathTracker2]].setIcon(null);
				        greenPathTracker2=greenPathTracker2+flagRandom;
					    if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
					    }
				    }
					else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
					{
						buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
				        greenPathTracker2=greenPathTracker2+flagRandom;
					    if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
					{
						buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
				        greenPathTracker2=greenPathTracker2+flagRandom;
					    if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenQuadruple)
					{
						buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
				        greenPathTracker2=greenPathTracker2+flagRandom;
					    if(buttons[pathGreen2[greenPathTracker2]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenDouble)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen2[greenPathTracker2]].getIcon()==greenTriple)
						{
							buttons[pathGreen2[greenPathTracker2]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen2[greenPathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.YELLOW);
				}
	}
	
	//for green 3 method
	public void green3()
	{
		if(greenPathTracker3==0)
				{
					if(flagRandom==6)
					{
						buttons[pathGreen3[greenPathTracker3]].setIcon(null);
						greenPathTracker3=greenPathTracker3+1;
						if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenQuadruple);
						}
					    else
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.YELLOW);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(greenPathTracker3!=0 && (57-greenPathTracker3>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					{
						buttons[pathGreen3[greenPathTracker3]].setIcon(null);
				        greenPathTracker3=greenPathTracker3+flagRandom;
					    if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
					    }
				    }
					else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
					{
						buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
				        greenPathTracker3=greenPathTracker3+flagRandom;
					    if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
					{
						buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
				        greenPathTracker3=greenPathTracker3+flagRandom;
					    if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenQuadruple)
					{
						buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
				        greenPathTracker3=greenPathTracker3+flagRandom;
					    if(buttons[pathGreen3[greenPathTracker3]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenDouble)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen3[greenPathTracker3]].getIcon()==greenTriple)
						{
							buttons[pathGreen3[greenPathTracker3]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen3[greenPathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.YELLOW);
				}
	}
	
	//for green 4 method
	public void green4()
	{
		if(greenPathTracker4==0)
				{
					if(flagRandom==6)
					{
						buttons[pathGreen4[greenPathTracker4]].setIcon(null);
						greenPathTracker4=greenPathTracker4+1;
						if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenQuadruple);
						}
					    else
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.YELLOW);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(greenPathTracker4!=0 && (57-greenPathTracker4>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					{
						buttons[pathGreen4[greenPathTracker4]].setIcon(null);
				        greenPathTracker4=greenPathTracker4+flagRandom;
					    if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
					    }
				    }
					else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
					{
						buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
				        greenPathTracker4=greenPathTracker4+flagRandom;
					    if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
					{
						buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
				        greenPathTracker4=greenPathTracker4+flagRandom;
					    if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
					    }
					}
					else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenQuadruple)
					{
						buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
				        greenPathTracker4=greenPathTracker4+flagRandom;
					    if(buttons[pathGreen4[greenPathTracker4]].getIcon()==playerGreen)
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(greenDouble);
					    }
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenDouble)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenTriple);
						}
						else if(buttons[pathGreen4[greenPathTracker4]].getIcon()==greenTriple)
						{
							buttons[pathGreen4[greenPathTracker4]].setIcon(greenQuadruple);
						}
				//for red
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for blue
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
				//for yellow
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
						else if(buttons[pathGreen4[greenPathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							
						}
					    else
					    {
						    buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.YELLOW);
				}
	}
	
	//for yellow 1 method
	public void yellow1()
	{
		if(yellowPathTracker1==0)
				{
					if(flagRandom==6)
					{
						buttons[pathYellow1[yellowPathTracker1]].setIcon(null);
						yellowPathTracker1=yellowPathTracker1+1;
						if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowQuadruple);
						}
					    else
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.BLUE);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(yellowPathTracker1!=0 && (57-yellowPathTracker1>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					{
						buttons[pathYellow1[yellowPathTracker1]].setIcon(null);
				        yellowPathTracker1=yellowPathTracker1+flagRandom;
					    if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
					    }
				    }
					else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
					{
						buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
				        yellowPathTracker1=yellowPathTracker1+flagRandom;
					    if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
					{
						buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
				        yellowPathTracker1=yellowPathTracker1+flagRandom;
					    if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowQuadruple)
					{
						buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
				        yellowPathTracker1=yellowPathTracker1+flagRandom;
					    if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowDouble)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow1[yellowPathTracker1]].getIcon()==yellowTriple)
						{
							buttons[pathYellow1[yellowPathTracker1]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow1[yellowPathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.BLUE);
				}
	}
	
	//for yellow 2 method
	public void yellow2()
	{
		if(yellowPathTracker2==0)
				{
					if(flagRandom==6)
					{
						buttons[pathYellow2[yellowPathTracker2]].setIcon(null);
						yellowPathTracker2=yellowPathTracker2+1;
						if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowQuadruple);
						}
					    else
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.BLUE);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(yellowPathTracker2!=0 && (57-yellowPathTracker2>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					{
						buttons[pathYellow2[yellowPathTracker2]].setIcon(null);
				        yellowPathTracker2=yellowPathTracker2+flagRandom;
					    if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
					    }
				    }
					else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
					{
						buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
				        yellowPathTracker2=yellowPathTracker2+flagRandom;
					    if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
					{
						buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
				        yellowPathTracker2=yellowPathTracker2+flagRandom;
					    if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowQuadruple)
					{
						buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
				        yellowPathTracker2=yellowPathTracker2+flagRandom;
					    if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowDouble)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow2[yellowPathTracker2]].getIcon()==yellowTriple)
						{
							buttons[pathYellow2[yellowPathTracker2]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow2[yellowPathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.BLUE);
				}
	}
	
	//for yellow 3 method
	public void yellow3()
	{
		if(yellowPathTracker3==0)
				{
					if(flagRandom==6)
					{
						buttons[pathYellow3[yellowPathTracker3]].setIcon(null);
						yellowPathTracker3=yellowPathTracker3+1;
						if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowQuadruple);
						}
					    else
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.BLUE);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(yellowPathTracker3!=0 && (57-yellowPathTracker3>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					{
						buttons[pathYellow3[yellowPathTracker3]].setIcon(null);
				        yellowPathTracker3=yellowPathTracker3+flagRandom;
					    if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
					    }
				    }
					else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
					{
						buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
				        yellowPathTracker3=yellowPathTracker3+flagRandom;
					    if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
					{
						buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
				        yellowPathTracker3=yellowPathTracker3+flagRandom;
					    if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowQuadruple)
					{
						buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
				        yellowPathTracker3=yellowPathTracker3+flagRandom;
					    if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowDouble)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow3[yellowPathTracker3]].getIcon()==yellowTriple)
						{
							buttons[pathYellow3[yellowPathTracker3]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow3[yellowPathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.BLUE);
				}
	}
	
	//for yellow 4 method
	public void yellow4()
	{
		if(yellowPathTracker4==0)
				{
					if(flagRandom==6)
					{
						buttons[pathYellow4[yellowPathTracker4]].setIcon(null);
						yellowPathTracker4=yellowPathTracker4+1;
						if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowQuadruple);
						}
					    else
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
					    }
				        r=-1;
						flagRandom=0;
						turn++;
				        turnButton.setBackground(Color.BLUE);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(yellowPathTracker4!=0 && (57-yellowPathTracker4>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					{
						buttons[pathYellow4[yellowPathTracker4]].setIcon(null);
				        yellowPathTracker4=yellowPathTracker4+flagRandom;
					    if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
					    }
				    }
					else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
					{
						buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
				        yellowPathTracker4=yellowPathTracker4+flagRandom;
					    if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
					{
						buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
				        yellowPathTracker4=yellowPathTracker4+flagRandom;
					    if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
					    }
					}
					else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowQuadruple)
					{
						buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
				        yellowPathTracker4=yellowPathTracker4+flagRandom;
					    if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==playerYellow)
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowDouble);
					    }
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowDouble)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowTriple);
						}
						else if(buttons[pathYellow4[yellowPathTracker4]].getIcon()==yellowTriple)
						{
							buttons[pathYellow4[yellowPathTracker4]].setIcon(yellowQuadruple);
						}
				//for red
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for blue
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue1[bluePathTracker1]])
						{
							bluePathTracker1=0;
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue2[bluePathTracker2]])
						{
							bluePathTracker2=0;
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue3[bluePathTracker3]])
						{
							bluePathTracker3=0;
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathBlue4[bluePathTracker4]])
						{
							bluePathTracker4=0;
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
				//for green
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
						else if(buttons[pathYellow4[yellowPathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							
						}
					    else
					    {
						    buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn++;
				    turnButton.setBackground(Color.BLUE);
				}
	}
	
	//for blue 1 method
	public void blue1()
	{
		if(bluePathTracker1==0)
				{
					if(flagRandom==6)
					{
						buttons[pathBlue1[bluePathTracker1]].setIcon(null);
						bluePathTracker1=bluePathTracker1+1;
						if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueQuadruple);
						}
					    else
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
					    }
				        r=-1;
						flagRandom=0;
						turn=1;
				        turnButton.setBackground(Color.RED);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(bluePathTracker1!=0 && (57-bluePathTracker1>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					{
						buttons[pathBlue1[bluePathTracker1]].setIcon(null);
				        bluePathTracker1=bluePathTracker1+flagRandom;
					    if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
					    }
				    }
					else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
					{
						buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
				        bluePathTracker1=bluePathTracker1+flagRandom;
					    if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
					{
						buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
				        bluePathTracker1=bluePathTracker1+flagRandom;
					    if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueQuadruple)
					{
						buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
				        bluePathTracker1=bluePathTracker1+flagRandom;
					    if(buttons[pathBlue1[bluePathTracker1]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueDouble)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue1[bluePathTracker1]].getIcon()==blueTriple)
						{
							buttons[pathBlue1[bluePathTracker1]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue1[bluePathTracker1]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue1[bluePathTracker1]].setIcon(playerBlue);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn=1;
				    turnButton.setBackground(Color.RED);
				}
	}
	
	//for blue 2 method
	public void blue2()
	{
		if(bluePathTracker2==0)
				{
					if(flagRandom==6)
					{
						buttons[pathBlue2[bluePathTracker2]].setIcon(null);
						bluePathTracker2=bluePathTracker2+1;
						if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueQuadruple);
						}
					    else
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
					    }
				        r=-1;
						flagRandom=0;
						turn=1;
				        turnButton.setBackground(Color.RED);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(bluePathTracker2!=0 && (57-bluePathTracker2>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					{
						buttons[pathBlue2[bluePathTracker2]].setIcon(null);
				        bluePathTracker2=bluePathTracker2+flagRandom;
					    if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
					    }
				    }
					else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
					{
						buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
				        bluePathTracker2=bluePathTracker2+flagRandom;
					    if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
					{
						buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
				        bluePathTracker2=bluePathTracker2+flagRandom;
					    if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueQuadruple)
					{
						buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
				        bluePathTracker2=bluePathTracker2+flagRandom;
					    if(buttons[pathBlue2[bluePathTracker2]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueDouble)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue2[bluePathTracker2]].getIcon()==blueTriple)
						{
							buttons[pathBlue2[bluePathTracker2]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue2[bluePathTracker2]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue2[bluePathTracker2]].setIcon(playerBlue);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn=1;
				    turnButton.setBackground(Color.RED);
				}
	}
	
	//for blue 3 method
	public void blue3()
	{
		if(bluePathTracker3==0)
				{
					if(flagRandom==6)
					{
						buttons[pathBlue3[bluePathTracker3]].setIcon(null);
						bluePathTracker3=bluePathTracker3+1;
						if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueQuadruple);
						}
					    else
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
					    }
				        r=-1;
						flagRandom=0;
						turn=1;
				        turnButton.setBackground(Color.RED);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(bluePathTracker3!=0 && (57-bluePathTracker3>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					{
						buttons[pathBlue3[bluePathTracker3]].setIcon(null);
				        bluePathTracker3=bluePathTracker3+flagRandom;
					    if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
					    }
				    }
					else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
					{
						buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
				        bluePathTracker3=bluePathTracker3+flagRandom;
					    if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
					{
						buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
				        bluePathTracker3=bluePathTracker3+flagRandom;
					    if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueQuadruple)
					{
						buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
				        bluePathTracker3=bluePathTracker3+flagRandom;
					    if(buttons[pathBlue3[bluePathTracker3]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueDouble)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue3[bluePathTracker3]].getIcon()==blueTriple)
						{
							buttons[pathBlue3[bluePathTracker3]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue3[bluePathTracker3]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue3[bluePathTracker3]].setIcon(playerBlue);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn=1;
				    turnButton.setBackground(Color.RED);
				}
	}
	
	//for blue 4 method
	public void blue4()
	{
		if(bluePathTracker4==0)
				{
					if(flagRandom==6)
					{
						buttons[pathBlue4[bluePathTracker4]].setIcon(null);
						bluePathTracker4=bluePathTracker4+1;
						if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueQuadruple);
						}
					    else
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
					    }
				        r=-1;
						flagRandom=0;
						turn=1;
				        turnButton.setBackground(Color.RED);
					}
					else
					{
						//r=-1;
						//flagRandom=0;
					}
						
				}
				else if(bluePathTracker4!=0 && (57-bluePathTracker4>=flagRandom) && flagRandom>0)
				{
					if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					{
						buttons[pathBlue4[bluePathTracker4]].setIcon(null);
				        bluePathTracker4=bluePathTracker4+flagRandom;
					    if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
					    }
				    }
					else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
					{
						buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
				        bluePathTracker4=bluePathTracker4+flagRandom;
					    if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
					{
						buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
				        bluePathTracker4=bluePathTracker4+flagRandom;
					    if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
					    }
					}
					else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueQuadruple)
					{
						buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
				        bluePathTracker4=bluePathTracker4+flagRandom;
					    if(buttons[pathBlue4[bluePathTracker4]].getIcon()==playerBlue)
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(blueDouble);
					    }
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueDouble)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueTriple);
						}
						else if(buttons[pathBlue4[bluePathTracker4]].getIcon()==blueTriple)
						{
							buttons[pathBlue4[bluePathTracker4]].setIcon(blueQuadruple);
						}
				//for green
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen1[greenPathTracker1]])
						{
							greenPathTracker1=0;
							buttons[pathGreen1[greenPathTracker1]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen2[greenPathTracker2]])
						{
							greenPathTracker2=0;
							buttons[pathGreen2[greenPathTracker2]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen3[greenPathTracker3]])
						{
							greenPathTracker3=0;
							buttons[pathGreen3[greenPathTracker3]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathGreen4[greenPathTracker4]])
						{
							greenPathTracker4=0;
							buttons[pathGreen4[greenPathTracker4]].setIcon(playerGreen);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for red
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed1[redPathTracker1]])
						{
							redPathTracker1=0;
							buttons[pathRed1[redPathTracker1]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed2[redPathTracker2]])
						{
							redPathTracker2=0;
							buttons[pathRed2[redPathTracker2]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed3[redPathTracker3]])
						{
							redPathTracker3=0;
							buttons[pathRed3[redPathTracker3]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathRed4[redPathTracker4]])
						{
							redPathTracker4=0;
							buttons[pathRed4[redPathTracker4]].setIcon(playerRed);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
				//for yellow
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow1[yellowPathTracker1]])
						{
							yellowPathTracker1=0;
							buttons[pathYellow1[yellowPathTracker1]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow2[yellowPathTracker2]])
						{
							yellowPathTracker2=0;
							buttons[pathYellow2[yellowPathTracker2]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow3[yellowPathTracker3]])
						{
							yellowPathTracker3=0;
							buttons[pathYellow3[yellowPathTracker3]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
						else if(buttons[pathBlue4[bluePathTracker4]]==buttons[pathYellow4[yellowPathTracker4]])
						{
							yellowPathTracker4=0;
							buttons[pathYellow4[yellowPathTracker4]].setIcon(playerYellow);
							buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
							
						}
					    else
					    {
						    buttons[pathBlue4[bluePathTracker4]].setIcon(playerBlue);
					    }
					}

					
				    r=-1;
					flagRandom=0;
					turn=1;
				    turnButton.setBackground(Color.RED);
				}
	}
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae){
		
		    //dice action
			if(ae.getSource()==buttons[73])
			{
				if(r==-1)
				{
					r=randomNum();
					flagRandom=r;
				    System.out.println(r);
				}
			    if(redPathTracker1==0 && redPathTracker2==0 && redPathTracker3==0 && redPathTracker4==0 && flagRandom!=6 && turn==1)
				{
					r=-1;
					flagRandom=0;
					turn++;
					turnButton.setBackground(Color.GREEN);
				}
				else if(greenPathTracker1==0 && greenPathTracker2==0 && greenPathTracker3==0 && greenPathTracker4==0 && flagRandom!=6 && turn==2)
				{
					r=-1;
					flagRandom=0;
					turn++;
					turnButton.setBackground(Color.YELLOW);
				}
				else if(yellowPathTracker1==0 && yellowPathTracker2==0 && yellowPathTracker3==0 && yellowPathTracker4==0 && flagRandom!=6 && turn==3)
				{
					r=-1;
					flagRandom=0;
					turn++;
					turnButton.setBackground(Color.BLUE);
				}
				else if(bluePathTracker1==0 && bluePathTracker2==0 && bluePathTracker3==0 && bluePathTracker4==0 && flagRandom!=6 && turn==4)
				{
					r=-1;
					flagRandom=0;
					turn=1;
					turnButton.setBackground(Color.RED);
				}
			}
			//Exit action
			if(ae.getSource()==buttons[72])
			{
				new MainFrame(s).setVisible(true);
			    this.dispose();
			}
			
			
		//for red 1
			if(ae.getSource()==buttons[pathRed1[redPathTracker1]] && turn==1)
			{
				int a=flagRandom;
				if(a==6)
				{
					red1();
					r=-1;
					flagRandom=0;
					turn=1;
					turnButton.setBackground(Color.RED);
				}
				else
				{
					red1();
				}
			}
			//for red 2
			if(ae.getSource()==buttons[pathRed2[redPathTracker2]] && turn==1)
			{
                int a=flagRandom;
				if(a==6)
				{
					red2();
					r=-1;
					flagRandom=0;
					turn=1;
					turnButton.setBackground(Color.RED);
				}
				else
				{
					red2();
				}
			}
			//for red 3
			if(ae.getSource()==buttons[pathRed3[redPathTracker3]] && turn==1)
			{
                int a=flagRandom;
				if(a==6)
				{
					red3();
					r=-1;
					flagRandom=0;
					turn=1;
					turnButton.setBackground(Color.RED);
				}
				else
				{
					red3();
				}
			}
			//for red 4
			if(ae.getSource()==buttons[pathRed4[redPathTracker4]] && turn==1)
			{
                int a=flagRandom;
				if(a==6)
				{
					red4();
					r=-1;
					flagRandom=0;
					turn=1;
					turnButton.setBackground(Color.RED);
				}
				else
				{
					red4();
				}	
			}
			
			
			
		
	
	
	       //for green 1
			if(ae.getSource()==buttons[pathGreen1[greenPathTracker1]] && turn==2)
			{
                int a=flagRandom;
				if(a==6)
				{
					green1();
					r=-1;
					flagRandom=0;
					turn=2;
					turnButton.setBackground(Color.GREEN);
				}
				else
				{
					green1();
				}
			}
			//for green 2
			if(ae.getSource()==buttons[pathGreen2[greenPathTracker2]] && turn==2)
			{
                int a=flagRandom;
				if(a==6)
				{
					green2();
					r=-1;
					flagRandom=0;
					turn=2;
					turnButton.setBackground(Color.GREEN);
				}
				else
				{
					green2();
				}	
			}
			//for green 3
			if(ae.getSource()==buttons[pathGreen3[greenPathTracker3]] && turn==2)
			{
                int a=flagRandom;
				if(a==6)
				{
					green3();
					r=-1;
					flagRandom=0;
					turn=2;
					turnButton.setBackground(Color.GREEN);
				}
				else
				{
					green3();
				}	
			}
			//for green 4
			if(ae.getSource()==buttons[pathGreen4[greenPathTracker4]] && turn==2)
			{
                int a=flagRandom;
				if(a==6)
				{
					green4();
					r=-1;
					flagRandom=0;
					turn=2;
					turnButton.setBackground(Color.GREEN);
				}
				else
				{
					green4();
				}	
			}
			
			
			
			
			//for yellow 1
			if(ae.getSource()==buttons[pathYellow1[yellowPathTracker1]] && turn==3)
			{
                int a=flagRandom;
				if(a==6)
				{
					yellow1();
					r=-1;
					flagRandom=0;
					turn=3;
					turnButton.setBackground(Color.YELLOW);
				}
				else
				{
					yellow1();
				}	
			}
			//for yellow 2
			if(ae.getSource()==buttons[pathYellow2[yellowPathTracker2]] && turn==3)
			{
                int a=flagRandom;
				if(a==6)
				{
					yellow2();
					r=-1;
					flagRandom=0;
					turn=3;
					turnButton.setBackground(Color.YELLOW);
				}
				else
				{
					yellow2();
				}
			}
			//for yellow 3
			if(ae.getSource()==buttons[pathYellow3[yellowPathTracker3]] && turn==3)
			{
                int a=flagRandom;
				if(a==6)
				{
					yellow3();
					r=-1;
					flagRandom=0;
					turn=3;
					turnButton.setBackground(Color.YELLOW);
				}
				else
				{
					yellow3();
				}	
			}
			//for yellow 4
			if(ae.getSource()==buttons[pathYellow4[yellowPathTracker4]] && turn==3)
			{
                int a=flagRandom;
				if(a==6)
				{
					yellow4();
					r=-1;
					flagRandom=0;
					turn=3;
					turnButton.setBackground(Color.YELLOW);
				}
				else
				{
					yellow4();
				}
			}
			
			
			
		
	
	
	//for blue 1
			if(ae.getSource()==buttons[pathBlue1[bluePathTracker1]] && turn==4)
			{
                int a=flagRandom;
				if(a==6)
				{
					blue1();
					r=-1;
					flagRandom=0;
					turn=4;
					turnButton.setBackground(Color.BLUE);
				}
				else
				{
					blue1();
				}
			}
			//for blue 2
			if(ae.getSource()==buttons[pathBlue2[bluePathTracker2]] && turn==4)
			{
                int a=flagRandom;
				if(a==6)
				{
					blue2();
					r=-1;
					flagRandom=0;
					turn=4;
					turnButton.setBackground(Color.BLUE);
				}
				else
				{
					blue2();
				}	
			}
			//for blue 3
			if(ae.getSource()==buttons[pathBlue3[bluePathTracker3]] && turn==4)
			{
                int a=flagRandom;
				if(a==6)
				{
					blue3();
					r=-1;
					flagRandom=0;
					turn=4;
					turnButton.setBackground(Color.BLUE);
				}
				else
				{
					blue3();
				}	
			}
			//for blue 4
			if(ae.getSource()==buttons[pathBlue4[bluePathTracker4]] && turn==4)
			{
                int a=flagRandom;
				if(a==6)
				{
					blue4();
					r=-1;
					flagRandom=0;
					turn=4;
					turnButton.setBackground(Color.BLUE);
				}
				else
				{
					blue4();
				}	
			}     		
			
	}	
	
}
	
	




	
