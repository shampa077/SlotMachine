import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
String path = "src\\figures\\";
private static int sSize=0;
private final Random random = new Random();

private List<JPanel> wheels;
public void loadSlotValues()
{
	
	Vehicle v1= new Vehicle("Bus","Red");
    Vehicle v2= new Vehicle("Taxi","");
    Fruit f1= new Fruit("Apple","Red");
    Number n1= new Number("One");
    Sign s1= new Sign("Asterisk");
	
	fig.add(v1); 
	sSize++;
	fig.add(v2); 
	sSize++;
	fig.add(f1); 
	sSize++;
	fig.add(n1); 
	sSize++;
	fig.add(s1); 
	sSize++;

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
public void actionPerformed(ActionEvent e) {

	if (e.getSource()==btnSpin)
	{

	    int spinval[]=new int[3];
	    spinval[0]=gospin();
	    spinval[1]=gospin();
	    spinval[2]=gospin();
		wheels.get(0).removeAll();
        wheels.get(0).add(getImageLabel(getPath(spinval[0])));
        wheels.get(0).validate();
        wheels.get(0).repaint();
        
        wheels.get(1).removeAll();
        wheels.get(1).add(getImageLabel(getPath(spinval[1])));
        wheels.get(1).validate();
        wheels.get(1).repaint();
        
        wheels.get(2).removeAll();
        wheels.get(2).add(getImageLabel(getPath(spinval[0])));
        wheels.get(2).validate();
        wheels.get(2).repaint();
	}
}

public SlotMachine() {
    //construct components
    
    
   
    loadSlotValues();
    btnSpin = new JButton ("Spin");
    btnSpin.setBounds (235, 250, 100, 25);
  
    lblAccBalance = new JLabel ();
    lblAccBalance.setBounds (75, 300, 400, 50);
    lblAccBalance.setText("Your account currently contain :");
    
    lblStatus = new JLabel ();
    lblStatus.setBounds (75, 375, 400, 50);
     
    lblCheatCode = new JLabel ("Have a cheat code ? Enter here : ");
    lblCheatCode.setBounds (75, 350, 400, 25);
    
    wheels = new ArrayList();
    
    tfCheatCode = new JTextField("");
    tfCheatCode.setBounds (350, 350, 100, 25);
    
    btnNew = new JButton ("New");
    btnNew.setBounds (25, 450, 100, 25);
    
    btnLoad = new JButton ("Load");
    btnLoad.setBounds (130, 450, 100, 25);
    
    btnSave = new JButton ("Save");
    btnSave.setBounds (235, 450, 100, 25);
    
    btnHistory = new JButton ("History");
    btnHistory.setBounds (340, 450, 100, 25);
    
    btnQuit = new JButton ("Quit");
    btnQuit.setBounds (445, 450, 100, 25);
    
   
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
    add (btnNew);
    add (btnLoad);
    add (btnSave);
    add (btnHistory);
    add (btnQuit);
                       

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
    
    try{
          //System.err.println(path);
        File file = new File(path);
        image = ImageIO.read(file);
        pic = new JLabel(new ImageIcon(image));
        
        //System.err.println(file.getAbsoluteFile());
        
        } catch (Exception ex){
            System.err.println(ex.getLocalizedMessage());
        }
    
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
