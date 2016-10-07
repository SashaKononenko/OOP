import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main {
    public static void main(String[] args) {
		JFrame window = new JFrame("Lab 2");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		landlinePhone phone = new landlinePhone(false,false,true);
		
		JButton myNam = new JButton("My namber");
		JButton greenTube = new JButton("green");
		JButton redTube = new JButton("red");
		JButton btnIncomingCall = new JButton("Test incoming call");
		JColorChooser col = new JColorChooser();
		
		
		window.getContentPane().add(myNam,BorderLayout.NORTH);
		window.getContentPane().add(greenTube,BorderLayout.WEST);
		window.getContentPane().add(redTube,BorderLayout.EAST);
		window.getContentPane().add(btnIncomingCall,BorderLayout.CENTER);
		window.getContentPane().add(col,BorderLayout.SOUTH);
		window.setSize(300,100);
		
		myNam.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					phone.printMyNumber();
				}
			}
		);
		greenTube.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					phone.clickGreenBtn();
				}
			}
		);
		
		btnIncomingCall.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					phone.emulateIncomingCall();
				}
			}
		);
		redTube.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					phone.clickRedBtn();
				}
			}
		);
		
	}
}

class landlinePhone {
	boolean incomingCall;
	boolean call;
	boolean tubeOnPhone;
	int number;

	//конструктори
	landlinePhone()
	{
		incomingCall = false;
		call = false;
		tubeOnPhone = true;
		number = 555123;
	}
	
	landlinePhone(int a)
	{
		number = a;
	}
	
	landlinePhone(boolean b,boolean c,boolean d)
	{
		this(555123);
		incomingCall = b;
		call = c;
		tubeOnPhone = d;
		
	}
	
	String replics1 = "Incoming call";
	String replics2 = "Talk";
	String replics3 = "Finished talking";
	String replics4 = "Call";
	
	void clickGreenBtn()
	{
		if (incomingCall)
		{
			System.out.println(replics2);
			incomingCall = false;
			tubeOnPhone = false;		
		}
		else
		{
			System.out.println(replics4);
			System.out.println(replics2);
			incomingCall = false;
			call = true;
			tubeOnPhone = false;
		}
		printVar();
	}
	void clickRedBtn()
	{
		if (tubeOnPhone == false)
		{
			System.out.println(replics3);
			tubeOnPhone = true;
			call = false;
			incomingCall = false;
		}
		printVar();
	}
	void emulateIncomingCall()
	{
		System.out.println(replics1);
		incomingCall = true;
		call = false;
		tubeOnPhone = true;
		printVar();
	}
	void printMyNumber()
	{
		System.out.println("My number:"+number);
	}
	void printVar()
	{
		System.out.println("incomingCall:"+incomingCall+" call:"+call+" TubeOnPhone:"+tubeOnPhone);
	}
	
	
	
}