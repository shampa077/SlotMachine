import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanel2 extends JPanel {
    
	private JLabel jcomp3;

    public MyPanel2() {
        //construct components
        
		jcomp3 = new JLabel ("This is Window 2");

        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        
		jcomp3.setBounds (105, 115, 100, 25);

        //add components
           
		add (jcomp3);
    }
}

public class SlotMachine extends JPanel implements ActionListener{

private  JButton btnSpin;
private JLabel  lblAccBalance;
private JLabel  lblStatus;
private  JLabel  lblCheatCode;
private  JTextField  tfCheatCode;

private JButton btnNew;
private  JButton btnLoad;
private JButton btnSave;
private  JButton btnHistory;
private  JButton btnQuit;
ArrayList<ColouredFigure> fig=new ArrayList<ColouredFigure>();
//String path = "src\\figures\\";
String path = "Image/";
private static int sSize=0;
private final Random random = new Random();

private List<JPanel> wheels;
ArrayList<String> cheatcodes=new ArrayList<String>();
boolean cheaton=false;
String cheatstring="";
int point=0;
static final int winpoint=5000;
boolean win=false;
boolean loose=false;

public void loadSlotValues()
{
	
	Vehicle v1= new Vehicle("bus","Red");
    Vehicle v2= new Vehicle("taxi","");
    Vehicle v3= new Vehicle("bus","Yellow");
    Vehicle v4= new Vehicle("lorry","");
    Fruit f1= new Fruit("apple","Red");
    Fruit f2= new Fruit("apple","Green");
    Fruit f3= new Fruit("banana","");
    Fruit f4= new Fruit("kiwi","");
    Number n1= new Number("1");
    Number n2= new Number("2");
    Number n3= new Number("3");
    Sign s1= new Sign("asterisk");
    Sign s2= new Sign("dollar");
	fig.add(v1); 
	sSize++;
	fig.add(v2); 
	sSize++;
	fig.add(v3); 
	sSize++;
	fig.add(v4); 
	sSize++;
	fig.add(f1); 
	sSize++;
	fig.add(f2); 
	sSize++;
	fig.add(f3); 
	sSize++;
	fig.add(f4); 
	sSize++;
	fig.add(n1); 
	sSize++;
	fig.add(n2); 
	sSize++;
	fig.add(n3); 
	sSize++;
	fig.add(s1); 
	sSize++;
	fig.add(s2); 
	sSize++;
	for (int i=0;i<sSize;i++)
	{
		System.out.println("i:"+ i+ " "+ fig.get(i).toString());
	}
	
	cheatcodes.add("2SameCHEAT");
	cheatcodes.add("3SameCHEAT");
	cheatcodes.add("2SameCatCHEAT");
	cheatcodes.add("3SameCatCHEAT");
	cheatcodes.add("2SignCHEAT");
	cheatcodes.add("3SignCHEAT");

}
public void pointcalculation(int [] option)
{
	
	int currentpoint= (getslotFigureValue(option[0])+getslotCategoryValue(option[0]))+ (getslotFigureValue(option[1])+getslotCategoryValue(option[1]))+ (getslotFigureValue(option[2])+getslotCategoryValue(option[2]));
	int extrapoint=0;
	if (getslotCategoryValue(option[0])== getslotCategoryValue(option[1]) || getslotCategoryValue(option[1])== getslotCategoryValue(option[2])|| getslotCategoryValue(option[2])== getslotCategoryValue(option[0]))
	{
		extrapoint=200;
		if (getslotCategoryValue(option[0])== getslotCategoryValue(option[1]) && getslotCategoryValue(option[1])== getslotCategoryValue(option[2]) )
		{
			extrapoint+=200;
			lblStatus.setText("Wow you got all same category slots");
		}
		else
		{
			lblStatus.setText("Wow you got two same category slots");
		}
		
	}
	else
	{
		lblStatus.setText("Alas you got different category slots");
		extrapoint=-200;
		
	}
	if (getslotFigureValue(option[0])== getslotFigureValue(option[1]) || getslotFigureValue(option[1])== getslotFigureValue(option[2])|| getslotFigureValue(option[2])== getslotFigureValue(option[0]))
	{
		extrapoint=400;
		if (getslotFigureValue(option[0])== getslotFigureValue(option[1]) && getslotFigureValue(option[1])== getslotFigureValue(option[2]) )
		{
			extrapoint+=400;
			lblStatus.setText("Wow you got all same slots");
		}
		else
		{
			lblStatus.setText("Wow you got two same slots");
		}
		
	}
	
	lblAccBalance.setText("Your current points "+ (point+ currentpoint+ extrapoint) + ". You have earned points "+ (currentpoint+ extrapoint) +" in this run");
	point+= (currentpoint+ extrapoint);
	if (point>=winpoint)
	{
		win=true;
	}
	if (point<0)
	{
		loose=true;
	}
	
}
public String getPath(int option) 
{
	String path1=path;
	if(option>sSize ||option<0)
		System.out.println("invalid");
	else
	{
		path1+=fig.get(option).getName();
        path1+=".jpg";
        
	}
	return path1;
	
}
public int getslotFigureValue(int option)
{
	int val=-1;
	if(option>sSize ||option<0)
		System.out.println("invalid");
	else
	{
		val=fig.get(option).getFigureValue();
        
	}
	
	return val;
}
public int getslotCategoryValue(int option)
{
	int val=-1;
	if(option>sSize ||option<0)
		System.out.println("invalid");
	else
	{
		if(fig.get(option) instanceof Vehicle)
	    {
	    	 Vehicle v=(Vehicle) fig.get(option);
	    	 val=v.getCatVal();
          
	    	
	    }
		else if (fig.get(option) instanceof Fruit)
		{
			Fruit v=(Fruit) fig.get(option);
	    	 val=v.getCatVal();
		}
		else if (fig.get(option) instanceof Number)
		{
			Number v=(Number) fig.get(option);
	    	 val=v.getCatVal();
		}
		else if (fig.get(option) instanceof Sign)
		{
			Sign v=(Sign) fig.get(option);
	    	 val=v.getCatVal();
		}
        
	}
	
	return val;
	
}
public int gospin() {
	
	
		int index  = random.nextInt(sSize);
		System.out.println(index);
		return index;
	
}
public int randomGenerate(int minimum, int maximum)
{
	
	int n = maximum - minimum + 1;
	int i = random.nextInt(n);
	int randomNum =  minimum + i;
	if (randomNum <0)
	{
		
		System.out.println("Problem");	
	}
	return randomNum;
}
public int[] gospinCheat()
{
	int index[]= new int [3];
	
		if(cheatstring.equals(cheatcodes.get(0)))
		{
			index[0]  = random.nextInt(sSize);
			index[1]  = random.nextInt(sSize);
			index[2]  = index[0];
			System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);			
			return index;
		}
		if(cheatstring.equals(cheatcodes.get(1)))
		{
			index[0]  = random.nextInt(sSize);
			index[1]  = index[0];
			index[2]  = index[0];
			System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);			
			return index;
		}
		if(cheatstring.equals(cheatcodes.get(2)) || cheatstring.equals(cheatcodes.get(3)) )
		{
					index[0]  = random.nextInt(sSize);
					int option=index[0];
					if(fig.get(option) instanceof Vehicle)
				    {
						if (cheatstring.equals(cheatcodes.get(3)))
							index[1]  = randomGenerate(0,3);
						else
							index[1]  = random.nextInt(sSize);
						
						 index[2]  = randomGenerate(0,3);
						 System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);			
				    }
					else if (fig.get(option) instanceof Fruit)
					{
						if (cheatstring.equals(cheatcodes.get(3)))
							index[1]  = randomGenerate(4,7);
						else
							index[1]  = random.nextInt(sSize);
						
						index[2]  = randomGenerate(4,7);
						System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);
					}	
					else if (fig.get(option) instanceof Number)
					{
						if (cheatstring.equals(cheatcodes.get(3)))
							index[1]  = randomGenerate(8,10);
						else
							index[1]  = random.nextInt(sSize);
						
						index[2]  = randomGenerate(8,10);
						 System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);
				    	
					}
					else if (fig.get(option) instanceof Sign)
					{
						if (cheatstring.equals(cheatcodes.get(3)))
							index[1]  = randomGenerate(11,12);
						else
							index[1]  = random.nextInt(sSize);
						
						index[2]  = randomGenerate(11,12);
						System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);
				    	
					}
					return index;	
					
		}
		else if (cheatstring.equals(cheatcodes.get(4)) ||cheatstring.equals(cheatcodes.get(5)))
		{
			index[0]  = randomGenerate(11,12);
			if (cheatstring.equals(cheatcodes.get(5)))
				index[1]  = randomGenerate(11,12);
			else
				index[1]  = random.nextInt(sSize);
			
			index[2]  = randomGenerate(11,12);
			System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);
			
			return index;
		}
		else
		{
			index[0]  = random.nextInt(sSize);
			index[1]  = random.nextInt(sSize);
			index[2]  = random.nextInt(sSize);
			System.out.println(index[0]+ " "+ index[1]+ " "+ index[2]);
			
			return index;
			
		}
	
}
public boolean foundMatch(String cheat)
{
	for (int i=0;i<cheatcodes.size();i++)
	{
		String s=(String)cheatcodes.get(i);
		if (s.equals(cheat))
		{
			cheaton=true;
			cheatstring=cheat;
		}
	}
	return cheaton;
	
}
public void resetGame()
{
	
	 point=0;
	 lblAccBalance.setText("Your account currently contains points: 0");
	
	 wheels.get(0).removeAll();
     wheels.get(0).setBackground(Color.GREEN);
     wheels.get(0).validate();
     wheels.get(0).repaint();
     
     wheels.get(1).removeAll();
     wheels.get(1).setBackground(Color.GREEN);
     wheels.get(1).validate();
     wheels.get(1).repaint();
     
     wheels.get(2).removeAll();
     wheels.get(2).setBackground(Color.GREEN);
     wheels.get(2).validate();
     wheels.get(2).repaint();
	
}
public void actionPerformed(ActionEvent e) {

	
	if (e.getSource()==btnSpin)
	{
		
	    int spinval[]=new int[3];
	    if (foundMatch(tfCheatCode.getText()))
		{
	    	spinval=gospinCheat();
	    	cheaton=false;
	    	cheatstring="";
	    	tfCheatCode.setText("");
	    	
		}
	    else
	    {
	    	spinval[0]=gospin();
	    	spinval[1]=gospin();
	    	spinval[2]=gospin();
	    }
	    pointcalculation(spinval);
	    System.out.println(spinval[0]+ " "+ spinval[1]+ " "+ spinval[2]);
	    
	    wheels.get(0).removeAll();
	     wheels.get(0).setBackground(null);
	     wheels.get(0).validate();
	     wheels.get(0).repaint();
	     
	     wheels.get(1).removeAll();
	     wheels.get(1).setBackground(null);
	     wheels.get(1).validate();
	     wheels.get(1).repaint();
	     
	     wheels.get(2).removeAll();
	     wheels.get(2).setBackground(null);
	     wheels.get(2).validate();
	     wheels.get(2).repaint(); 
	    
	    
	    
	    
		wheels.get(0).removeAll();
        wheels.get(0).add(getImageLabel(getPath(spinval[0])));
        wheels.get(0).validate();
        wheels.get(0).repaint();
        
        wheels.get(1).removeAll();
        wheels.get(1).add(getImageLabel(getPath(spinval[1])));
        wheels.get(1).validate();
        wheels.get(1).repaint();
        
        wheels.get(2).removeAll();
        wheels.get(2).add(getImageLabel(getPath(spinval[2])));
        wheels.get(2).validate();
        wheels.get(2).repaint();
        if (win)
        {
        	System.out.println("Won");
        	win=false;
        	JOptionPane.showMessageDialog(null, "You have won!!");
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Start the Game Again ?");
			System.out.println(dialogResult);
			if(dialogResult == 0){
				resetGame();
			}
			else
			{
				System.exit(1);
			}
        }
        else if(loose)
        {
        	System.out.println("Loose");
        	loose=false;
        	JOptionPane.showMessageDialog(null, "Sorry You have lose the game!!");
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Start the Game Again ?");
			System.out.println(dialogResult);
			if(dialogResult == 0){
				resetGame();
			}
			else
			{
				System.exit(1);
			}
        }
	}
}

public SlotMachine() {
    //construct components
    
    
   
    loadSlotValues();
    btnSpin = new JButton ("Spin");
    btnSpin.setBounds (235, 250, 100, 25);
  
    lblAccBalance = new JLabel ();
    lblAccBalance.setBounds (75, 300, 400, 50);
    lblAccBalance.setText("Your account currently contains points: 0");
    
    lblStatus = new JLabel ();
    lblStatus.setBounds (75, 350, 400, 50);
    lblStatus.setText("");
     
    lblCheatCode = new JLabel ("Have a cheat code ? Enter here : ");
    lblCheatCode.setBounds (75, 400, 400, 50);
    
    wheels = new ArrayList();
    
    tfCheatCode = new JTextField("");
    tfCheatCode.setBounds (350, 400, 100, 50);
    
    /*btnNew = new JButton ("New");
    btnNew.setBounds (25, 450, 100, 25);
    
 /*  btnLoad = new JButton ("Load");
    btnLoad.setBounds (130, 450, 100, 25);
    
    btnSave = new JButton ("Save");
    btnSave.setBounds (235, 450, 100, 25);
    
    btnHistory = new JButton ("History");
    btnHistory.setBounds (340, 450, 100, 25);
    
    btnQuit = new JButton ("Quit");
    btnQuit.setBounds (445, 450, 100, 25);*/
    
   
    JPanel wheel1 = new JPanel();
    wheel1.setBounds (75, 100, 120, 120);
    wheel1.setBorder(BorderFactory.createLineBorder(Color.RED));
    wheels.add(wheel1);
   
    JPanel wheel2 = new JPanel();
    wheel2.setBounds (225, 100, 120, 120);
    wheel2.setBorder(BorderFactory.createLineBorder(Color.RED));
    wheels.add(wheel2);    
   
    JPanel wheel3 = new JPanel();
    wheel3.setBounds (375, 100, 120, 120);
    wheel3.setBorder(BorderFactory.createLineBorder(Color.RED));
    wheels.add(wheel3);
    
    
    btnSpin.addActionListener(this) ;
       
       

    //adjust size and set layout
    setPreferredSize (new Dimension (700, 500));
    setLayout (null);

    //add components
    
    add (wheel1);
    add (wheel2);
    add (wheel3);
    add (btnSpin);
    add (lblAccBalance);
    add (lblStatus);
    add (lblCheatCode);
    add (tfCheatCode);
     /*add (btnNew);
   /* add (btnLoad);
    add (btnSave);
    add (btnHistory);
    add (btnQuit);*/
                       

}

    /**
     *
     * @return
     */
    public List<JPanel> getWheels() {
        return wheels;
    }

    
public JLabel getImageLabel(String path ) {
 
    BufferedImage image;
    JLabel pic = null;     
    /*
    try{
          //System.err.println(path);
        File file = new File(path);
        image = ImageIO.read(file);
        pic = new JLabel(new ImageIcon(image));
        
        //System.err.println(file.getAbsoluteFile());
        
        } catch (Exception ex){
            System.err.println(ex.getLocalizedMessage());
        }
    */
    URL s=getClass().getResource(path);
    System.out.println(s.toString());
    ImageIcon slot = new ImageIcon(s);
    pic= new JLabel(slot);
    return pic;
}

public static void main (String[] args) {
    JFrame frame = new JFrame ("Slot Machine! Try your luck !!! ");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add (new SlotMachine());
    frame.pack();
    frame.setVisible (true);
    
}
}
