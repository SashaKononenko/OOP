import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main {
    public static void main(String[] args) {
		JFrame window = new JFrame("Lab 2");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		landlinePhone phone = new landlinePhone();
		
		JTextField screen = new JTextField();
		JButton greenTube = new JButton("green");
		JButton redTube = new JButton("red");
		JButton btnIncomingCall = new JButton("Test incoming call");
		
		window.getContentPane().add(screen,BorderLayout.NORTH);
		window.getContentPane().add(greenTube,BorderLayout.WEST);
		window.getContentPane().add(redTube,BorderLayout.EAST);
		window.getContentPane().add(btnIncomingCall,BorderLayout.CENTER);
		window.setSize(300,100);
		greenTube.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					phone.SetScreen("saddasd");
				}
			}
		);
		
	}
}

class landlinePhone {
	boolean incomingCall;
	boolean call;
	boolean tubeOnPhone;
	int number = 555214;
	String screen = "";
	
	public void SetScreen(String str);
	{
		this.screen.setText(str);
	}
	
	
	
}